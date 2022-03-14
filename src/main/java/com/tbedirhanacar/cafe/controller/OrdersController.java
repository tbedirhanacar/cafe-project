package com.tbedirhanacar.cafe.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tbedirhanacar.cafe.entity.Orders;
import com.tbedirhanacar.cafe.service.OrdersService;

@RestController
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
	
    @PostMapping("/createOrder")
    public Orders saveDepartment(@RequestBody Orders order){

        return ordersService.saveOrder(order);
    }
	
    @GetMapping("/allOrders")
    public List<Orders> getAllOrders(){
    	return ordersService.getAllOrders();
    }
    
    @GetMapping("/getOrder/{id}")
    public Orders getOrder(@PathVariable("id") Long id) {
    	return ordersService.getOrder(id);
    }
    
}
