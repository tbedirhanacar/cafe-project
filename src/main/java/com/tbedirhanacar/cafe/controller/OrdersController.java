package com.tbedirhanacar.cafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
    
    @DeleteMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable("id") Long id) {
    	String orderName = ordersService.getOrder(id).getOrderName();
    	ordersService.deleteOrder(id);
    	return "Order '"+ orderName+"(ID:"+id+")' has been deleted"; 
    }
    
    @PatchMapping("/updateOrder/{id}")
    public Orders updateOrders(@PathVariable("id") Long id, @RequestBody Orders order) {
    	return ordersService.updateOrders(id, order);
    }
    
    
}
