package com.marykay.country.love.api.controller.external;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marykay.country.love.api.contract.dto.BaseResult;
import com.marykay.country.love.api.contract.dto.FileDto;
import com.marykay.country.love.api.contract.dto.GetUserDto;
import com.marykay.country.love.api.contract.dto.PageDto;
import com.marykay.country.love.api.contract.request.AddUserRequest;
import com.marykay.country.love.api.contract.request.ChangeMobileRequest;
import com.marykay.country.love.api.contract.request.ChangePasswordRequest;
import com.marykay.country.love.api.contract.request.GetUserListRequest;
import com.marykay.country.love.api.contract.request.GetUserLoginRequest;
import com.marykay.country.love.api.contract.request.UpdateUserRequest;
import com.marykay.country.love.api.contract.response.GetUserListResponse;
import com.marykay.country.love.api.contract.response.GetUserResponse;
import com.marykay.country.love.model.User;
import com.marykay.country.love.service.UserService;
import com.marykay.country.love.util.UploadCommon;

import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by yangliu on 18/4/8.
 */
@RestController
@EnableAutoConfiguration
public class UsersController {

	@Autowired
	HttpServletRequest request;

	@Autowired
	private UserService userService;

	/**
	 * 用户注册
	 * 
	 * @param addUserRequest
	 */
	@ApiOperation(value = "registered user", notes = "registered user")
	@RequestMapping(value = "/v1/users/add", method = RequestMethod.POST)
	public BaseResult add(@Valid AddUserRequest addUserRequest) {
		BaseResult result = new BaseResult();
		// 查看手机号是否存在
		User user = userService.findByMobile(addUserRequest.getMobile());
		if (user != null) {
			result.setCode(1);
			result.setMsg("手机号已注册，请换其他手机号注册!");
			return result;
		}

		User users = userService.add(addUserRequest);
		result.setCode(0);
		result.setContent(users);
		result.setMsg("注册成功!");
		return result;
	}

	/**
	 * 更新用户信息
	 * 
	 * @param file
	 * @param updateUserRequest
	 * @throws IOException
	 */
	@ApiOperation(value = "modifying user information", notes = "modifying user information")
	@RequestMapping(value = { "/v1/users/information" }, method = RequestMethod.PUT)
	public BaseResult userUpdate(// @RequestParam(value = "image_file", required
									// = false) MultipartFile file,
			@RequestBody UpdateUserRequest updateUserRequest) throws IOException {

		UploadCommon uploadCommon = UploadCommon.getUploadCommonInstance();
		FileDto fileDto = new FileDto();

		// TODO
		// uploadCommon.uploadImageCom(file, request, fileDto);

		BaseResult result = new BaseResult();
		
		User user = new User();
		user.setId(updateUserRequest.getId());
		user.setUserName(updateUserRequest.getName());
		user.setSex(updateUserRequest.getSex());
		user.setBirthday(updateUserRequest.getBirthday());
		user.setSignin(updateUserRequest.getSignin());
		user.setRemark(updateUserRequest.getRemark());
		user.setNewAddress(updateUserRequest.getNewAddress());
		user.setOldAddress(updateUserRequest.getOldAddress());
		// TODO
		// user.setPhoto(fileDto.getFile_url());
		user.setPhoto("12312");
		user.setMaritalStatus(updateUserRequest.getMaritalStatus());
		user.setCreatedBy(String.valueOf(updateUserRequest.getId()));
		user.setCreatedDate(new Date());
		user.setUpdatedBy(String.valueOf(updateUserRequest.getId()));
		user.setUpdatedDate(new Date());

		if (userService.updateUser(user)) {
			result.setCode(0);
			result.setMsg("修改成功");
			return result;
		}
		result.setCode(-1);
		result.setMsg("修改失败");
		return result;
	}

	/**
	 * 用户登录
	 * 
	 * @param getUserLoginRequest
	 */
	@ApiOperation(value = "login", notes = "login")
	@RequestMapping(value = "/v1/user/login", method = RequestMethod.GET)
	public BaseResult Login(@Valid GetUserLoginRequest getUserLoginRequest) {
		BaseResult result = new BaseResult();
		User user = userService.findByMobile(getUserLoginRequest.getMobile());
		if (user == null) {
			result.setCode(1);
			result.setMsg("用户名不存在");
			return result;
		}

		if (user.getNewPassword().equals(getUserLoginRequest.getPassword())) {
			result.setCode(0);
			result.setMsg("登陆成功");
			return result;
		}
		result.setCode(2);
		result.setMsg("密码错误");
		return result;
	}

	/**
	 * 修改密码
	 * 
	 * @param changePasswordRequest
	 */
	@ApiOperation(value = "change password", notes = "change password")
	@RequestMapping(value = { "/v1/users/changePassword" }, method = RequestMethod.PUT)
	public BaseResult changePassword(@Valid ChangePasswordRequest changePasswordRequest) {

		BaseResult result = new BaseResult();

		User userInfo = userService.findById(changePasswordRequest.getId());
		if (userInfo.getNewPassword().equals(changePasswordRequest.getPassword())) {
			result.setCode(-1);
			result.setMsg("密码与旧密码一致，请重新输入");
			return result;
		}
		User user = new User();
		user.setId(changePasswordRequest.getId());
		user.setOldPassword(userInfo.getNewPassword());
		user.setNewPassword(changePasswordRequest.getPassword());
		user.setUpdatedBy(String.valueOf(changePasswordRequest.getId()));
		user.setUpdatedDate(new Date());

		if (userService.updatePassword(user)) {
			result.setCode(0);
			result.setMsg("密码修改成功");
			return result;
		}
		result.setCode(-1);
		result.setMsg("密码修改失败");
		return result;
	}

	/**
	 * 修改手机号
	 * 
	 * @param changeMobileRequest
	 */
	@ApiOperation(value = "change phone", notes = "change phone")
	@RequestMapping(value = { "/v1/users/changePhone" }, method = RequestMethod.PUT)
	public BaseResult changePhone(@Valid ChangeMobileRequest changeMobileRequest) {

		BaseResult result = new BaseResult();

		User userInfo = userService.findById(changeMobileRequest.getId());
		if (userInfo != null) {
			User users = userService.findByMobile(changeMobileRequest.getMobile());
			if (users != null) {
				result.setCode(1);
				result.setMsg("手机号已经注册，请更换其他手机号");
				return result;
			} else {
				User user = new User();
				user.setId(changeMobileRequest.getId());
				user.setMobile(changeMobileRequest.getMobile());
				if (userService.updatePhone(user)) {
					result.setCode(0);
					result.setMsg("手机号修改成功");
					return result;
				} else {
					result.setCode(-1);
					result.setMsg("手机号修改失败");
					return result;
				}
			}
		}
		result.setCode(-1);
		result.setMsg("用户不存在");
		return result;
	}

	/**
	 * 根据用户id获取用户详细信息
	 *
	 * @param userid
	 */
	@ApiOperation(value = "getting user details", notes = "getting user details")
	@RequestMapping(value = "/v1/users/{userid}", method = RequestMethod.GET)
	public GetUserResponse getUserDetail(@PathVariable Integer userid) {

		GetUserResponse getUserResponse = userService.getUser(userid);

		return getUserResponse;
	}

	/**
	 * 获取首页信息
	 *
	 * @param getUserListRequest
	 * @param sex
	 */
	@ApiOperation(value = "getting dashboard users", notes = "getting dashboard users")
	@RequestMapping(value = "/v1/users/query", method = RequestMethod.GET)
	public GetUserListResponse getUsers(@Valid GetUserListRequest getUserListRequest, @PathVariable String sex) {

		GetUserListResponse getUserResponse = new GetUserListResponse();

		PageDto<GetUserDto> users = userService.getUsersPage(getUserListRequest.getPageNo(),
				getUserListRequest.getPageSize(), getUserListRequest.getAddress(), sex);
		getUserResponse.pageNo = users.getPageNo();
		getUserResponse.pageSize = users.getPageSize();
		getUserResponse.totalCount = users.getTotalSize();
		getUserResponse.setGetUserDtoList(users.getContent());
		return getUserResponse;
	}
}
