package com.tbedirhanacar.cafe.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tbedirhanacar.cafe.entity.Orders;
import com.tbedirhanacar.cafe.repository.OrdersRepository;

@Service
public class OrdersService {
	
	@Autowired
	private OrdersRepository ordersRepository;
	
    public Orders saveOrder(Orders order) {
    	order.setOrderTime(LocalTime.now());
        return ordersRepository.save(order);	
    }
    
    public List<Orders> getAllOrders(){
    	return ordersRepository.findAll();
    }
    
    public Orders getOrder(Long id) {
    	return ordersRepository.findById(id).get();
    }
    
    public void deleteOrder(Long id) {
    	ordersRepository.deleteById(id);
    }
    
    public Orders updateOrders(Long id, Orders order) {
    	Orders ordDB = ordersRepository.findById(id).get();
    	ordDB.setOrderName(order.getOrderName());
    	return ordersRepository.save(ordDB);
    }

}
