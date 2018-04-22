package marykay.country.love;

import java.io.IOException;
import java.util.UUID;

import com.marykay.country.love.api.contract.request.PayNotifyRequest;
import com.marykay.country.love.api.contract.request.PayRequest;
import com.marykay.country.love.util.MD5;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TestPay {

	public static void main(String[] args) {

		String uid = "7132805987119764";
		float amount = (float) 0.01;
		int type = 1;
		String notifyurl = "http://localhost:8080/v1/users/pays";
		String returnurl = "https://pay_return";
		String ordernum = "201804201757";
		String orderuid = "yangliu";
		String goodname = "商品名称";
		String token = "waqm1c4bjv3srs3i0ertfar93yd1o1gb";

		PayRequest payRequest = new PayRequest();
		payRequest.setAmount(amount);
		payRequest.setType(type);
		payRequest.setNotifyurl(notifyurl);
		payRequest.setReturnurl(returnurl);
		payRequest.setOrdernum(ordernum);
		payRequest.setOrderuid(orderuid);
		payRequest.setGoodname(goodname);
		String key = goodname + type + notifyurl + returnurl + ordernum + orderuid + amount + token + uid;
		String keyNew = MD5.getMD5(key);
		pay(payRequest, keyNew);

//		 String greenpay_id = UUID.randomUUID().toString().replace("-","");
//		 System.out.println(greenpay_id);
//		 String ordernum = "201804201757";
//		 float amount = (float) 0.01;
//		 float realamount = (float) 0.01;
//		 String orderuid = "yangliu";
//		
//		 PayNotifyRequest payNotifyRequest = new PayNotifyRequest();
//		 payNotifyRequest.setGreenpay_id(greenpay_id);
//		 payNotifyRequest.setOrdernum(ordernum);
//		 payNotifyRequest.setAmount(amount);
//		 payNotifyRequest.setRealamount(realamount);
//		 payNotifyRequest.setOrderuid(orderuid);
//		 String key = ordernum + orderuid + greenpay_id + amount + realamount + token;
//		 String keyNew = MD5.getMD5(key);
//		 payNotifyRequest.setKey(keyNew);
//		 payNotify(payNotifyRequest);
	}

	public static void pay(PayRequest payRequest, String keyNew) {

		OkHttpClient client = new OkHttpClient();
		FormBody body = new FormBody.Builder().add("uid", "")
				.add("amount", String.valueOf(payRequest.getAmount())).add("type", String.valueOf(payRequest.getType()))
				.add("notifyurl", payRequest.getNotifyurl()).add("returnurl", payRequest.getReturnurl())
				.add("ordernum", payRequest.getOrdernum()).add("orderuid", payRequest.getOrderuid())
				.add("goodname", payRequest.getGoodname()).add("key", keyNew).build();
		Request request = new Request.Builder().url("https://www.greenzf.com/api/index").post(body).build();
		try {
			Response response = client.newCall(request).execute();
			if (response.code() == 200) {
				String responseBody = response.body().string();
				System.out.println("");
			} else {
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	public static void payNotify(PayNotifyRequest payNotifyRequest) {
//
//		OkHttpClient client = new OkHttpClient();
//		FormBody body = new FormBody.Builder().add("greenpay_id", payNotifyRequest.getGreenpay_id())
//				.add("ordernum", payNotifyRequest.getOrdernum())
//				.add("amount", String.valueOf(payNotifyRequest.getAmount()))
//				.add("realamount", String.valueOf(payNotifyRequest.getRealamount()))
//				.add("orderuid", payNotifyRequest.getOrderuid()).add("key", payNotifyRequest.getKey()).build();
//		Request request = new Request.Builder().url("https://pay_notify").post(body).build();
//		try {
//			Response response = client.newCall(request).execute();
//			if (response.code() == 200) {
//				String responseBody = response.body().string();
//			} else {
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}
