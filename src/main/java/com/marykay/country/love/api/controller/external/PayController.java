package com.marykay.country.love.api.controller.external;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marykay.country.love.api.contract.request.PayNotifyRequest;
import com.marykay.country.love.api.contract.request.PayRequest;
import com.marykay.country.love.api.contract.response.GetOrderResponse;
import com.marykay.country.love.api.contract.response.PayResponse;
import com.marykay.country.love.model.Order;
import com.marykay.country.love.service.PayService;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by yangliu on 18/4/20.
 */
@RestController
@EnableAutoConfiguration
public class PayController {

	@Autowired
	HttpServletRequest request;

	@Autowired
	private PayService payService;

	/**
	 * 用户发起付款
	 * 
	 * @param payRequest
	 */
	@ApiOperation(value = "user pays", notes = "user pays")
	@RequestMapping(value = "/v1/users/pay", method = RequestMethod.POST)
	public PayResponse pay(@Valid PayRequest payRequest) {
		PayResponse response = new PayResponse();
		String orderUid = UUID.randomUUID().toString().replace("-", "");
		Boolean result = payService.pay(payRequest, orderUid);
		Order order = new Order();
		if (result) {
			order.setOrderUid(orderUid);
			order.setAmount(payRequest.getAmount());
			order.setType(payRequest.getType());
			order.setGoodname(payRequest.getGoodname());
			order.setStatus(1);
			order.setCreatedBy(payRequest.getMobile());
			order.setCreatedDate(new Date());
			order.setUpdatedBy(payRequest.getMobile());
			order.setUpdatedDate(new Date());
			order = payService.add(order);
		}
		response.setAmount(order.getAmount());
		response.setOrderuid(order.getOrderUid());
		return response;
	}

	/**
	 * 付款成功后更新订单状态
	 * 
	 * @param payNotifyRequest
	 */
	@ApiOperation(value = "update orders status", notes = "update orders status")
	@RequestMapping(value = "/v1/users/orders/update", method = RequestMethod.POST)
	public void payNotify(@Valid PayNotifyRequest payNotifyRequest) {

		Order order = new Order();
		order.setOrderUid(payNotifyRequest.getOrderuid());
		order.setStatus(2);// 支付完成
		order.setCreatedBy(payNotifyRequest.getMobile());
		order.setCreatedDate(new Date());
		order.setUpdatedBy(payNotifyRequest.getMobile());
		order.setUpdatedDate(new Date());
		payService.updateOrderStatus(order);
	}

	/**
	 * 查询订单状态
	 * 
	 * @param orderUid
	 */
	@ApiOperation(value = "get order status", notes = "get order status")
	@RequestMapping(value = "/v1/users/{orderUid}/details", method = RequestMethod.GET)
	public GetOrderResponse getOrderStatus(@PathVariable String orderUid) {

		GetOrderResponse getOrderResponse = new GetOrderResponse();
		Order order = payService.getOrderDetail(orderUid);
		getOrderResponse.setStatus(order.getStatus());
		return getOrderResponse;
	}
}
