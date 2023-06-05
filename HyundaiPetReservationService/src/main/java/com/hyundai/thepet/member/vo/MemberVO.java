package com.hyundai.thepet.member.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
	private int id;
	private String email;
	private String password;
	private String name;
	private String phone;
	private String birth;
	private int admin;
	private int adminAddress;
}
