package com.hyundai.thepet.message.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReservationVO {
    private int id;
    private Date reservationDate;
    private String reservationStartTime;
    private String reservationEndTime;
    private int price;
    private int customerCount;
    private int memberId;
    private int dogId;
    private int locationId;
}
