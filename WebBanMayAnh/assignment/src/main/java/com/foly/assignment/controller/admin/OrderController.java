package com.foly.assignment.controller.admin;

import com.foly.assignment.entity.Account;
import com.foly.assignment.entity.Order;
import com.foly.assignment.service.AccountService;
import com.foly.assignment.service.OrderService;
import com.foly.assignment.service.SessionService;
import com.foly.assignment.service.impl.AccountServiceImpl;
import com.foly.assignment.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/order/")
public class OrderController {

    @Autowired
    private OrderService orderService = new OrderServiceImpl();

    @Autowired
    private AccountService accountService = new AccountServiceImpl();

    @Autowired
    SessionService session;

    @GetMapping("view")
    public String hienThi(Model model){
        List<Order> order = orderService.findAll();
        model.addAttribute("order", order);
        return "admin/order/index";
    }
    @GetMapping("view-add")
    public String viewAdd(Model model) {
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);
        return "admin/order/add";
    }

}
