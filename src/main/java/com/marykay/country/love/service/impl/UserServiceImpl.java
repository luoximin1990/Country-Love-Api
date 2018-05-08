package com.marykay.country.love.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.marykay.country.love.api.contract.dto.GetUserDto;
import com.marykay.country.love.api.contract.dto.PageDto;
import com.marykay.country.love.api.contract.request.AddUserRequest;
import com.marykay.country.love.api.contract.response.GetUserResponse;
import com.marykay.country.love.model.PhoneCode;
import com.marykay.country.love.model.User;
import com.marykay.country.love.repository.PhoneCodeRepository;
import com.marykay.country.love.repository.UserRepository;
import com.marykay.country.love.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PhoneCodeRepository phoneCodeRepository;

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
				user.getSignin(), user.getRemark(), user.getNewAddress(), user.getOldAddress(), user.getMaritalStatus(),
				user.getUpdatedBy(), user.getUpdatedDate()) > 0;
	}

	@Override
	public boolean upload(User user) {
		return userRepository.updateUserPhoto(user.getId(), user.getPhoto(), user.getCreatedBy(), user.getCreatedDate(),
				user.getUpdatedBy(), user.getUpdatedDate()) > 0;
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
		getUserDto.setUserName(user.getUserName());
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
		User user =  new User();
		userRepository.saveUser(addUserRequest.getUserName(), addUserRequest.getMobile(),
				addUserRequest.getPassword(), addUserRequest.getMobile(), new Date(), addUserRequest.getMobile(),
				new Date());
		user.setUserName(addUserRequest.getUserName());
		user.setMobile(addUserRequest.getMobile());
		return user;
	}

	@Override
	public PhoneCode addPhoneCode(String mobile, int code) {
		PhoneCode phoneCode = new PhoneCode();
		phoneCode.setMobile(mobile);
		phoneCode.setCode(code);
		phoneCodeRepository.save(phoneCode);
		return phoneCode;
	}

	@Override
	public boolean getPhoneCode(String mobile, int code) {

		PhoneCode phoneCode = phoneCodeRepository.findByMobileAndCode(mobile, code);
		if (phoneCode != null) {
			if (code == phoneCode.getCode()) {
				return true;
			}
		}
		return false;
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
		// function 1
		Page<User> userList = this.userRepository.findAll(where(address,sex), pageable);
		// function 2
//		User user = new User();
//		user.setNewAddress(address);
//		user.setSex(sex);
//		Page<User> userList2 = this.findPageList(pageNo,pageSize,user);
		
		// function 3
//		Page<User> userList = this.findUserList(address, sex,  pageSize,  pageNo);
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
	private Specification<User> where(String newAddress, String sex) {
		return new Specification<User>() {
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>(); // 所有的断言
//				if (!"".equals(newAddress) && newAddress != null) { // 添加断言
//					Predicate preName = cb.like(root.get("newAddress"), "%" + newAddress + "%");
//					predicates.add(preName);
//				}
				if (!"".equals(sex) && sex != null) { // 添加断言
					Predicate preName = cb.equal(root.get("sex"), sex);
					predicates.add(preName);
				}
				return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
			}
		};
	}
	
    /** 
     * 分页列表模糊 查询 
     *  
     * @param page 
     * @param rows 
     * @param user 
     * @return 
     */  
    public Page<User> findPageList(Integer page,Integer rows,User user){  
        page = (page == null) ? 1 : page;  
        rows = (rows == null) ? 10 : rows;  
  
        Pageable pageable = new PageRequest(page - 1, rows, Direction.DESC,"createdDate");//id倒序排列  
        return (Page<User>) userRepository.findAll(new Specification() {  
            @Override  
            public Predicate toPredicate(Root root, CriteriaQuery query,  
                                         CriteriaBuilder cb) {  
  
                  
                //操作对象 模糊查询  
                if (user.getNewAddress() != null && !"".equals(user.getNewAddress())) {  
                    Predicate objects ;  
                    objects = cb.like(root.get("newAddress"), "%" + user.getNewAddress() + "%");  
                    query.where(objects);  
                }  
                //操作类型  精确查询  
                if (user.getSex() != null && !"".equals(user.getSex())) {  
                    Predicate type ;  
                    type = cb.equal(root.get("sex"), user.getSex());  
                    query.where(type);  
                }  
                  
                return null;  
            };  
        }, pageable);  
    }; 

    /** 
     * 首页按住址和性别分页模糊查询
     *  
     * @param address
     * @param sex
     * @param pageSize
     * @param pageNo
     * @return 
     */
    public Page<User> findUserList(String address, String sex, int pageSize, int pageNo) {
		// 创建查询条件数据对象
		User user = new User();
		user.setNewAddress(address);
		user.setSex(sex);

		Sort sort = new Sort(Direction.DESC, "createdDate");
		PageRequest pageRequest = new PageRequest(pageNo - 1, pageSize, sort);

		// 创建比较对象，对字符串模糊查询
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING);

		// 查询
		Page<User> users = userRepository.findAll(Example.of(user, matcher), pageRequest);

		return users;
	}
}
