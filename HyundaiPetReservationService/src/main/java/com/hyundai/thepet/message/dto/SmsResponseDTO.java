package com.hyundai.thepet.message.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SmsResponseDTO {
    private String requestId;
    private Date requestTime;
    private String statusCode;
    private String statusName;

}
