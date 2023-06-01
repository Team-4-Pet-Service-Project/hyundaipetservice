package com.hyundai.thepet.message.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LocationVO {
    private int id;
    private String address;
    private String addressDetail;
    private String dogFacilities;
}
