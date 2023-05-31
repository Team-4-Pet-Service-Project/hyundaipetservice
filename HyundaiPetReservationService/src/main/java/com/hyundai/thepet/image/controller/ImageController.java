package com.hyundai.thepet.image.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hyundai.thepet.image.vo.ImageVO;

@RequestMapping(value = "image")
@RestController
public class ImageController {

	Logger log = LogManager.getLogger("case3");

	// ajax로 이미지파일 서버에 올리는 부분이다.
	@PostMapping(value = "uploadAjax", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ImageVO> uploadAjax(MultipartFile uploadFile) {

		// 이미지 파일 체크
		File checkfile = new File(uploadFile.getOriginalFilename());
		String type = null;

		try {
			type = Files.probeContentType(checkfile.toPath());
			// log.debug("MIME TYPE : " + type);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (!type.startsWith("image")) {
			ImageVO vo = null;
			return new ResponseEntity<ImageVO>(vo, HttpStatus.BAD_REQUEST);
		}

		// 날짜폴더에 사진 집어 넣기
		String uploadFolder = "C:\\upload";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		String datePath = str.replace("-", File.separator);
		File uploadPath = new File(uploadFolder, datePath);
		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}

		// 이미지 정보 객체
		ImageVO vo = new ImageVO();

		String uploadFileName = uploadFile.getOriginalFilename();
		String uuid = UUID.randomUUID().toString();
		uploadFileName = uuid + "_" + uploadFileName;
		// 파일 위치와 파일 이름 합친 File 객체
		File saveFile = new File(uploadPath, uploadFileName);
		vo.setFileName(uploadFileName);
		vo.setUploadPath(datePath);
		vo.setUuid(uuid);
		// 파일 저장
		try {
			uploadFile.transferTo(saveFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<ImageVO> result = new ResponseEntity<ImageVO>(vo, HttpStatus.OK);
		return result;
	}

	// 이미지 보여주는 곳
	@GetMapping(value = "display")
	public ResponseEntity<byte[]> getImage(String fileName) {
		File file = new File("c:\\upload\\" + fileName);
		ResponseEntity<byte[]> result = null;
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 이미지 올린거 삭제하는 부분
	@PostMapping(value = "delete")
	public ResponseEntity<String> deleteFile(String fileName) {
		File file = null;
		try {
			file = new File("c:\\upload\\" + fileName);
			file.delete();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("fail", HttpStatus.NOT_IMPLEMENTED);
		}
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	//여긴 이미지 수정할 때 이미지 올린거 삭제하는 부분

}
