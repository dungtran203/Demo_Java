package com.foly.assignment.controller.admin;

import com.foly.assignment.entity.OrderDetail;
import com.foly.assignment.service.OrderDetailService;
import com.foly.assignment.service.impl.OrderDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/order-detail/")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService = new OrderDetailServiceImpl();

    @GetMapping("view")
    public String hienThi(Model model){
        List<OrderDetail> orderDetails = orderDetailService.findAll();
        model.addAttribute("orderDetails", orderDetails);
        return "admin/orderDetail/index";
    }

}
