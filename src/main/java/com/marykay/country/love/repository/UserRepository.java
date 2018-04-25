package com.marykay.country.love.repository;

import java.util.Date;
import javax.transaction.Transactional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.marykay.country.love.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByMobile(String mobile);

	User findById(int id);

	@Transactional
	@Modifying
	@Query("UPDATE user t SET t.newPassword = :newPassword, t.oldPassword = :oldPassword, t.updatedBy = :updatedBy, t.updatedDate = :updatedDate WHERE t.id=:id ")
	int updatePassword(@Param("id") int id, @Param("newPassword") String newPassword,
			@Param("oldPassword") String oldPassword, @Param("updatedBy") String updatedBy,
			@Param("updatedDate") Date updatedDate);

	@Transactional
	@Modifying
	@Query("UPDATE user t SET t.mobile = :mobile, t.updatedBy = :updatedBy, t.updatedDate = :updatedDate WHERE t.id=:id ")
	int updatePhone(@Param("id") int id, @Param("mobile") String mobile, @Param("updatedBy") String updatedBy,
			@Param("updatedDate") Date updatedDate);

	@Transactional
	@Modifying
	@Query("UPDATE user t SET t.userName = :userName,t.sex = :sex,t.birthday = :birthday,t.signin = :signin,t.remark = :remark,t.newAddress = :newAddress,t.oldAddress = :oldAddress,t.maritalStatus = :maritalStatus,t.createdBy = :createdBy, t.createdDate = :createdDate, t.updatedBy = :updatedBy, t.updatedDate = :updatedDate WHERE t.id=:id ")
	int updateUser(@Param("id") int id, @Param("userName") String userName, @Param("sex") String sex,
			@Param("birthday") String birthday, @Param("signin") String signin, @Param("remark") String remark,
			@Param("newAddress") String newAddress, @Param("oldAddress") String oldAddress,
			@Param("maritalStatus") int maritalStatus, @Param("createdBy") String createdBy,
			@Param("createdDate") Date createdDate, @Param("updatedBy") String updatedBy,
			@Param("updatedDate") Date updatedDate);

	@Transactional
	@Modifying
	@Query("UPDATE user t SET t.photo = :photo,t.createdBy = :createdBy, t.createdDate = :createdDate, t.updatedBy = :updatedBy, t.updatedDate = :updatedDate WHERE t.id=:id ")
	int updateUserPhoto(@Param("id") int id, @Param("photo") String photo, @Param("createdBy") String createdBy,
			@Param("createdDate") Date createdDate, @Param("updatedBy") String updatedBy,
			@Param("updatedDate") Date updatedDate);

	Page<User> findAll(Specification<User> spec, Pageable pageable);
}
