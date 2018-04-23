package com.marykay.country.love.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marykay.country.love.api.contract.request.PayRequest;
import com.marykay.country.love.model.Order;
import com.marykay.country.love.repository.OrderRepository;
import com.marykay.country.love.service.PayService;
import com.marykay.country.love.util.MD5;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class PayServiceImpl implements PayService {

	final String uid = "7132805987119764";
	final String token = "waqm1c4bjv3srs3i0ertfar93yd1o1gb";

	@Autowired
	OrderRepository orderRepository;

	@Override
	public boolean pay(PayRequest payRequest, String orderUid) {

		String key = convert(payRequest, orderUid);
		OkHttpClient client = new OkHttpClient();
		FormBody body = new FormBody.Builder().add("uid", uid).add("amount", String.valueOf(payRequest.getAmount()))
				.add("type", String.valueOf(payRequest.getType())).add("notifyurl", payRequest.getNotifyurl())
				.add("returnurl", payRequest.getReturnurl()).add("ordernum", payRequest.getOrdernum())
				.add("orderuid", orderUid).add("goodname", payRequest.getGoodname()).add("key", key).build();
		Request request = new Request.Builder().url("https://www.greenzf.com/api/index").post(body).build();
		try {
			Response response = client.newCall(request).execute();
			if (response.code() == 200) {
				return true;
			} else {
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private String convert(PayRequest payRequest, String orderUid) {

		String key = payRequest.getGoodname() + payRequest.getType() + payRequest.getNotifyurl()
				+ payRequest.getReturnurl() + payRequest.getOrdernum() + orderUid + payRequest.getAmount() + token
				+ uid;
		String keyNew = MD5.getMD5(key);
		return keyNew;
	}

	@Override
	public Order add(Order order) {
		order = orderRepository.save(order);
		return order;
	}

	@Override
	public boolean updateOrderStatus(Order order) {
		return orderRepository.updateOrderStatus(order.getOrderUid(), order.getStatus(), order.getCreatedBy(),
				order.getCreatedDate(), order.getUpdatedBy(), order.getUpdatedDate()) > 0;
	}

	@Override
	public Order getOrderDetail(String orderUid) {
		Order order = orderRepository.findByOrderUid(orderUid);
		return order;
	}
}
