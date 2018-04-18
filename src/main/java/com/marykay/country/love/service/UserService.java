package com.marykay.country.love.service;

import com.marykay.country.love.api.contract.dto.GetUserDto;
import com.marykay.country.love.api.contract.dto.PageDto;
import com.marykay.country.love.api.contract.request.AddUserRequest;
import com.marykay.country.love.api.contract.response.GetUserResponse;
import com.marykay.country.love.model.PhoneCode;
import com.marykay.country.love.model.User;

public interface UserService {

	/**
	 * 获取用户详细信息
	 * 
	 * @param id
	 *            :用户id
	 */
	User findById(int id);

	PageDto<GetUserDto> getUsersPage(int pageNo, int pageSize, String address, String sex);

	/**
	 * 用户注册
	 * 
	 * @param addUserRequest
	 *            :手机号
	 */
	User add(AddUserRequest addUserRequest);

	/**
	 * 获取验证码
	 * 
	 * @param mobile
	 *            :手机号
	 * @param code
	 *            :验证码
	 */
	PhoneCode addPhoneCode(String mobile, int code);

	/**
	 * 获取用户详细信息
	 * 
	 * @param mobile
	 *            :手机号
	 */
	User findByMobile(String mobile);

	/**
	 * 获取用户详细信息
	 * 
	 * @param userid
	 *            :用户Id
	 */
	GetUserResponse getUser(int userid);

	/**
	 * 修改密码
	 * 
	 * @param user
	 *            :用户信息
	 */
	boolean updatePassword(User user);

	/**
	 * 修改手机号
	 * 
	 * @param user
	 *            :用户信息
	 */
	boolean updatePhone(User user);

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 *            :用户信息
	 */
	boolean updateUser(User user);

	/**
	 * 查看该用户的课程是否学习结束
	 * 1,如果证书表中的courseStatus,examStatus都为1,则该课程已经学习结束
	 * 2,如果证书表中的courseStatus,examStatus都为0,则查询课程视频是否都学习过。
	 * @param level
	 * @param contactId
	 * @return true 完成、false 未完成
	 */
	boolean getPhoneCode(String mobile, int code);

}
