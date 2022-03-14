package com.tbedirhanacar.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tbedirhanacar.cafe.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>{

}
