package com.hyundai.thepet.message.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SmsRequestDTO {
	private String type;
	private String contentType;
    private String countryCode;
    private String from;
    private String content;
    private List<MessageDTO> messages;
}
