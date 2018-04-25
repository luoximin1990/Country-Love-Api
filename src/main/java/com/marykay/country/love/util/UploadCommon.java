package com.marykay.country.love.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

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
	public void uploadImageCom(MultipartFile multipartFile, HttpServletRequest request, FileDto fileDto)
			throws IOException {

		String filePath = "/Users/yangliu/Desktop/home/countrylove/pages/imgs/";
		String file_name = null;
		try {
			file_name = saveImg(multipartFile, filePath);
			
			String phone_url = filePath + file_name;
//			String phone_url = request.getServletContext().getRealPath("/pages/upload/") + file_name;
			fileDto.setFile_name(file_name);
			fileDto.setFile_url(phone_url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * 保存文件，直接以multipartFile形式
     * @param multipartFile
     * @param path 文件保存绝对路径
     * @return 返回文件名
     * @throws IOException
     */
    public static String saveImg(MultipartFile multipartFile,String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        String fileName = UUID.randomUUID().toString().replace("-", "") + ".png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + File.separator + fileName));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return fileName;
    }
}
