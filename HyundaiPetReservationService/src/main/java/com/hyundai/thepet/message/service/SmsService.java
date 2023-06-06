package com.hyundai.thepet.message.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyundai.thepet.message.dto.MessageDTO;
import com.hyundai.thepet.message.dto.SmsRequestDTO;
import com.hyundai.thepet.message.dto.SmsResponseDTO;

import lombok.RequiredArgsConstructor;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@PropertySource("classpath:config/sms.properties")
@RequiredArgsConstructor
@Service
public class SmsService {
	@Value("${naver-cloud-sms.accessKey}")
	private String accessKey;
	
	@Value("${naver-cloud-sms.secretKey}")
	private String secretKey;
	
	@Value("${naver-cloud-sms.serviceId}")
	private String serviceId;
	
	@Value("${naver-cloud-sms.senderPhone}")
	private String senderPhone;
	
	

	public String makeSignature(String time) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
		String space = " ";
        String newLine = "\n";
        String method = "POST";
        String url = "/sms/v2/services/"+ this.serviceId+"/messages";
        String timestamp = time.toString();
        String accessKey = this.accessKey;
        String secretKey = this.secretKey;
 
        String message = new StringBuilder()
                .append(method)
                .append(space)
                .append(url)
                .append(newLine)
                .append(timestamp)
                .append(newLine)
                .append(accessKey)
                .toString();
 
        SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(signingKey);
 
        byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
        String encodeBase64String = Base64.getEncoder().encodeToString(rawHmac);
 
        return encodeBase64String;
	}
	
	public SmsResponseDTO sendSMS(MessageDTO messageDto) throws JsonProcessingException, RestClientException, URISyntaxException, InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
		// 현재시간
        String time = Long.toString(System.currentTimeMillis());

		// 헤더세팅
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-ncp-apigw-timestamp", time);
        headers.set("x-ncp-iam-access-key", accessKey);
        headers.set("x-ncp-apigw-signature-v2", makeSignature(time)); // signature 서명

        List<MessageDTO> messages = new ArrayList<>();
        messages.add(messageDto);

		// api 요청 양식에 맞춰 세팅
        SmsRequestDTO request = SmsRequestDTO.builder()
                .type("LMS") // LMS로 변경
                .contentType("COMM")
                .countryCode("82")
                .from(senderPhone)
                .content("::")
                .messages(messages)
                .build();

        //request를 json형태로 body로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        String body = objectMapper.writeValueAsString(request);
        System.out.println(body);
        
        // body와 header을 합친다
        HttpEntity<String> httpBody = new HttpEntity<>(body, headers);
        
        System.out.println(httpBody);
        

        //restTemplate를 통해 외부 api와 통신
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
//        String encodedServiceId = URLEncoder.encode(serviceId, "UTF-8");
        String uri = "https://sens.apigw.ntruss.com/sms/v2/services/" + this.serviceId + "/messages";
        
        SmsResponseDTO smsResponseDto = restTemplate.postForObject(new URI(uri), httpBody, SmsResponseDTO.class);
        
        return smsResponseDto;
	}
}