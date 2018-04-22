package com.marykay.country.love.repository;

import java.util.Date;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.marykay.country.love.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE country_order t SET t.status = :status,t.createdBy = :createdBy, t.createdDate = :createdDate, t.updatedBy = :updatedBy, t.updatedDate = :updatedDate WHERE t.orderUid=:orderUid ")
	int updateOrderStatus(@Param("orderUid") String orderUid, @Param("status") int status,
			@Param("createdBy") String createdBy, @Param("createdDate") Date createdDate,
			@Param("updatedBy") String updatedBy, @Param("updatedDate") Date updatedDate);

	Order findByOrderUid(String orderUid);

}
