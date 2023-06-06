package com.hyundai.thepet.dog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DogVO {
	private int id;
	private String name;
	private int age;
	private String breed;
	private String dogSize;
	private String specialNote;
	private int memberId;
}
