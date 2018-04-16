package com.marykay.country.love.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.marykay.country.love.api.contract.dto.GetUserDto;
import com.marykay.country.love.api.contract.dto.PageDto;
import com.marykay.country.love.api.contract.request.AddUserRequest;
import com.marykay.country.love.api.contract.response.GetUserResponse;
import com.marykay.country.love.model.User;
import com.marykay.country.love.repository.UserRepository;
import com.marykay.country.love.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User findByMobile(String mobile) {

		User user = userRepository.findByMobile(mobile);
		return user;
	}

	@Override
	public boolean updatePassword(User user) {
		return userRepository.updatePassword(user.getId(), user.getNewPassword(), user.getOldPassword(),
				user.getUpdatedBy(), user.getUpdatedDate()) > 0;
	}

	@Override
	public boolean updateUser(User user) {
		return userRepository.updateUser(user.getId(), user.getUserName(), user.getSex(), user.getBirthday(),
				user.getSignin(), user.getRemark(), user.getNewAddress(), user.getOldAddress(), user.getPhoto(),
				user.getMaritalStatus(), user.getCreatedBy(), user.getCreatedDate(), user.getUpdatedBy(),
				user.getUpdatedDate()) > 0;
	}

	@Override
	public GetUserResponse getUser(int userid) {
		GetUserResponse getUserResponse = new GetUserResponse();
		User user = userRepository.findById(userid);
		getUserResponse.setGetUserDto(convent(user));
		return getUserResponse;
	}

	private GetUserDto convent(User user) {
		GetUserDto getUserDto = new GetUserDto();
		getUserDto.setId(user.getId());
		getUserDto.setName(user.getUserName());
		getUserDto.setBirthday(user.getBirthday());
		getUserDto.setMobile(user.getMobile());
		getUserDto.setMaritalStatus(user.getMaritalStatus());
		getUserDto.setNewAddress(user.getNewAddress());
		getUserDto.setOldAddress(user.getOldAddress());
		getUserDto.setPhoto(user.getPhoto());
		getUserDto.setRemark(user.getRemark());
		getUserDto.setSex(user.getSex());
		getUserDto.setSignin(user.getSignin());
		getUserDto.setCreatedBy(user.getCreatedBy());
		getUserDto.setCreatedDate(user.getCreatedDate());
		getUserDto.setUpdatedBy(user.getUpdatedBy());
		getUserDto.setUpdatedDate(user.getUpdatedDate());
		return getUserDto;
	}

	@Override
	public User add(AddUserRequest addUserRequest) {
		User user = new User();
		user.setMobile(addUserRequest.getMobile());
		user.setUserName(addUserRequest.getName());
		user.setNewPassword(addUserRequest.getPassword());
		userRepository.save(user);
		return user;
	}

	@Override
	public User findById(int id) {
		User user = userRepository.findById(id);
		return user;
	}

	@Override
	public PageDto<GetUserDto> getUsersPage(int pageNo, int pageSize, String address, String sex) {
		// 分页信息
		Pageable pageable = new PageRequest(pageNo - 1, pageSize); // 页码：前端从1开始，jpa从0开始，做个转换
		// 查询
		Page<User> userList = this.userRepository.findAll(where(address, sex), pageable);
		PageDto<GetUserDto> pageDto = new PageDto<GetUserDto>();
		pageDto.setPageNo(pageNo);
		pageDto.setPageSize(pageSize);
		pageDto.setTotalSize(userList.getTotalElements());

		if (CollectionUtils.isEmpty(userList.getContent())) {
			return pageDto;
		}

		List<GetUserDto> result = new ArrayList<GetUserDto>();
		for (User signIns : userList) {
			result.add(convent(signIns));
		}
		pageDto.setContent(result);
		return pageDto;
	}

	@Override
	public boolean updatePhone(User user) {
		return userRepository.updatePhone(user.getId(), user.getMobile(), user.getUpdatedBy(),
				user.getUpdatedDate()) > 0;
	}

	/**
	 * 条件查询时动态组装条件
	 */
	private Specification<User> where(final String address, final String sex) {
		return new Specification<User>() {
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>(); // 所有的断言
				if (!"".equals(address) && address != null) { // 添加断言
					Predicate preName = cb.like(root.<String>get("newAddress"), "%" + address + "%");
					predicates.add(preName);
				}
				if (!"".equals(sex) && sex != null) { // 添加断言
					Predicate preName = cb.equal(root.<String>get("sex"), sex);
					predicates.add(preName);
				}
				return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
			}
		};
	}
}
