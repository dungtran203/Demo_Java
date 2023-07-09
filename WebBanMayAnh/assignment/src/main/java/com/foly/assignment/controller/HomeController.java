package com.foly.assignment.controller;

import com.foly.assignment.dao.ProductDao;
import com.foly.assignment.entity.Product;
import com.foly.assignment.service.AccountService;
import com.foly.assignment.service.ProductService;
import com.foly.assignment.service.SessionService;
import com.foly.assignment.service.impl.AccountServiceImpl;
import com.foly.assignment.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/home/")
public class HomeController {

    @Autowired
    private SessionService session;

    @Autowired
    private ProductDao dao;

    @Autowired
    private ProductService productService = new ProductServiceImpl();

    @Autowired
    private AccountService accountService = new AccountServiceImpl();

    @GetMapping("view")
    public String getAll(@RequestParam(defaultValue = "1") int page, Model model) {
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 6);
        Page<Product> listProduct = productService.findAll(pageable);
        model.addAttribute("item", listProduct);
        return "commons/home";
    }

    @GetMapping("detail{id}")
    public String detail(@PathVariable("id") String id, Model model, @RequestParam(defaultValue = "1") int page){
        Product product = productService.findById(Integer.valueOf(id)).orElse(null);
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 6);
        Page<Product> listProduct = productService.findAll(pageable);
        model.addAttribute("product", product);
        model.addAttribute("listProduct", listProduct);
        return "user/product/detail";
    }

}
