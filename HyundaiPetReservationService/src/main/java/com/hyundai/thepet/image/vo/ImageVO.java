package com.hyundai.thepet.image.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageVO {
	private String uploadPath;
	private String uuid;
	
	private String fileName;
	
	private int reservation_id;
}
