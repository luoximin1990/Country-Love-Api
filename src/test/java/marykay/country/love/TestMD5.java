package marykay.country.love;

import com.marykay.country.love.util.MD5;

public class TestMD5 {

	public static void main(String[] args) {

		String str = "lee81g";

		System.out.println("md5:" + MD5.getMD5(str));
		System.out.println("length:" + MD5.getMD5(str).length());
	}
}
