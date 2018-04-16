package marykay.country.love;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.marykay.country.love.api.contract.request.QuerySendDetailsRequest;
import com.marykay.country.love.api.contract.response.BaseResponse;

/*
功能:		1xinxi.cn HTTP接口 发送短信

说明:		http://sms.1xinxi.cn/asmx/smsservice.aspx?name=登录名&pwd=接口密码&mobile=手机号码&content=内容&sign=签名&stime=发送时间&type=pt&extno=自定义扩展码
*/
public class SmsUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SmsUtils smsUtils = new SmsUtils();
			String telphoneString = "15821941983";
			smsUtils.sendSms(telphoneString);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 随机验证码
	private int code;

	public int getCode() {
		return code;
	}

	public void setCode() {
		code = (int) (Math.random() * 9999) + 1000; // 每次调用生成一次四位数的随机数
	}

	// 短信API产品名称
	static final String product = "Dysmsapi";
	// 短信API产品域名
	static final String domain = "dysmsapi.aliyuncs.com";

	static final String accessKeyId = "LTAIof9JVAdAOQDB";
	static final String accessKeySecret = "Niq2vDxvbKziwJh3unko3yWWss1LzY";

	public BaseResponse sendSms(String telphone) throws Exception {
		// 设置超时时间
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");
		// 初始化ascClient
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		IAcsClient acsClient = new DefaultAcsClient(profile);

		// 组装请求对象
		QuerySendDetailsRequest request = new QuerySendDetailsRequest();
		// 使用post提交
		request.setMethod(MethodType.POST);
		// 待发送的手机号
		// request.setPhoneNumbers(telphone);
		// // 短信签名
		// request.setSignName("星星");
		// // 短信模板ID
		// request.setTemplateCode("SMS_99325057");
		// 验证码
		SmsUtils sms = new SmsUtils();
		sms.setCode();
		String codetemp = sms.getCode() + "";
		System.out.println("code:        " + codetemp);
		/*
		 * 可选:模板中的变量替换JSON串, 如模板内容为"亲爱的${name},您的验证码为${code}"时,
		 * 此处的值为{"name":"Tom","code":"1454"} \ 反斜杠为转义字符，使得输出双引号
		 */
		// request.setTemplateParam("{\"name\":\"Tom\", \"code\":\"" + codetemp
		// + "\"}");
		// 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
		// request.setOutId("1454");
		// BaseResponse response = acsClient.getAcsResponse(request);

		// if (response.getCode() != 0) {
		// // 请求成功
		// System.out.println("发送成功！");
		// } else {
		// System.out.println("发送失败！");
		// }
		return new BaseResponse();
	}

}
