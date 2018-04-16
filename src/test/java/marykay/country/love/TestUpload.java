package marykay.country.love;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import com.marykay.country.love.Application;
import com.marykay.country.love.api.contract.dto.FileDto;
import com.marykay.country.love.util.UploadCommon;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestUpload {

	@Autowired
	HttpServletRequest request;

	/**
	 * 上传图片
	 * 
	 * @throws ParseException
	 * @throws IOException
	 */
	@Test
	public void addExamQuestion() throws ParseException, IOException {

		UploadCommon uploadCommon = UploadCommon.getUploadCommonInstance();

		File file = new File("/Users/yangliu/Downloads/skinanalyzerbg.jpg");
		FileDto fileDto = new FileDto();
		MockMultipartFile mockMultipartFile = new MockMultipartFile("/Users/yangliu/Downloads/skinanalyzerbg1.jpg",
				new FileInputStream(new File("/Users/yangliu/Downloads/skinanalyzerbg.jpg")));

		uploadCommon.uploadImageCom((MultipartFile) mockMultipartFile, request, fileDto);
	}
}
