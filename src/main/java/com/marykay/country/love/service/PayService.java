package com.marykay.country.love.service;

import com.marykay.country.love.api.contract.request.PayRequest;
import com.marykay.country.love.model.Order;

public interface PayService {

	/**
	 * 支付是否完成
	 * 
	 * @param payRequest
	 * @return true 支付完成、false 未完成
	 */
	boolean pay(PayRequest payRequest);
	
	Order add(Order order);
	
	/**
	 * 修改订单状态信息
	 * 
	 * @param user
	 *            :用户信息
	 */
	boolean updateOrderStatus(Order user);
	
	/**
	 * 查询订单状态
	 * 
	 * @param orderUid
	 *            :订单号
	 */
	Order getOrderDetail(String orderUid);
}
