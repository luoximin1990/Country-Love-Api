package com.marykay.country.love.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.marykay.country.love.api.contract.dto.FileDto;

public class UploadCommon {

	private static UploadCommon uploadCommon;

	public static synchronized UploadCommon getUploadCommonInstance() {
		if (uploadCommon == null) {
			uploadCommon = new UploadCommon();
		}
		return uploadCommon;
	}

	/**
	 * 图片上传
	 * 
	 * @param file
	 * @param request
	 * @param model
	 * @param fileDto
	 * @throws IOException
	 */
	public void uploadImageCom(MultipartFile file, HttpServletRequest request, FileDto fileDto) throws IOException {

		String path = request.getSession().getServletContext().getRealPath("/pages/upload");
		String fileName = file.getOriginalFilename();// 文件名称
		File targetFile = new File(path, fileName);

		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timesuffix = sdf.format(date);
		String imgileName = null;
		if ("png".equals(fileName.substring(fileName.length() - 3))) {
			imgileName = timesuffix + ".png";
		} else if ("jpg".equals(fileName.substring(fileName.length() - 3))) {
			imgileName = timesuffix + ".jpg";
		} else if ("gif".equals(fileName.substring(fileName.length() - 3))) {
			imgileName = timesuffix + ".gif";
		} else if ("jpeg".equals(fileName.substring(fileName.length() - 4))) {
			imgileName = timesuffix + ".jpeg";
		} else if ("bmp".equals(fileName.substring(fileName.length() - 4))) {
			imgileName = timesuffix + ".bmp";
		}

		FileInputStream fis = new FileInputStream(targetFile);
		File inputFile = new File(path + File.separatorChar + imgileName);
		OutputStream fos = new FileOutputStream(inputFile);
		int bytesRead = 0;
		byte[] buffer = new byte[1024 * 8];
		while ((bytesRead = fis.read(buffer)) != -1) {
			fos.write(buffer, 0, bytesRead);
		}
		fos.close();
		fis.close();
		String phone_url = request.getContextPath() + "/pages/upload/" + imgileName;

		fileDto.setFile_name(imgileName);
		fileDto.setFile_url(phone_url);
	}
}
