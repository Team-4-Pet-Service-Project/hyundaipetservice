package com.hyundai.thepet.member.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
	
	private String email;
	private String password;
	private String name;
	private String phone;
	private String birth;
}
