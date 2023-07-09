package com.foly.assignment.controller.admin;

import com.foly.assignment.entity.Account;
import com.foly.assignment.service.AccountService;
import com.foly.assignment.service.impl.AccountServiceImpl;
import jakarta.servlet.ServletContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/admin/account/")
public class AccountController {

    @Autowired
    private AccountService accountService = new AccountServiceImpl();

    @GetMapping("index")
    public String index() {
        return "commons/account";
    }

    @GetMapping("view")
    public String getAll(@RequestParam(defaultValue = "1") int page, Model model) {
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 4);
        Page<Account> listAccount = accountService.findAll(pageable);
        model.addAttribute("listAccount", listAccount);
        return "admin/account/index";
    }

    @GetMapping("detail{u}")
    public String detail(@PathVariable("u") String u, Model model, @RequestParam(defaultValue = "1") int page){
        Account account = accountService.findByUser(u).orElse(null);
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 2);
        Page<Account> listAccount = accountService.findAll(pageable);
        model.addAttribute("account", account);
        model.addAttribute("listAccount", listAccount);
        return "admin/account/detail";
    }

    @GetMapping("view-add")
    public String viewAdd(Model model) {
        List<Account> accountList = accountService.findAll();
        model.addAttribute("accountList", accountList);
        return "admin/account/add";
    }

    @GetMapping("view-update/{u}")
    public String viewUpdate(@PathVariable("u") String u, Model model) {
        Account account = accountService.findByUser(u).orElse(null);
        List<Account> categoryList = accountService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("account", account);
        return "admin/account/update";
    }

    @Autowired
    ServletContext context;
    @PostMapping("add")
    public String add(ModelMap model, @RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam("fullname") String fullname,
                             @RequestParam("email") String email,
                             @RequestParam("photo") MultipartFile photo) {

        if (photo.isEmpty()){
            model.addAttribute("mess", "Vui lòng chọn file");
        } else {
            try {
                String imagePath = context.getRealPath("/avata/" + photo.getOriginalFilename());
                photo.transferTo(new File(imagePath));
                model.addAttribute("photo", imagePath);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        Account account = Account.builder()
                .username(username)
                .password(password)
                .fullname(fullname)
                .email(email)
                .photo(photo.getOriginalFilename())
                .active(false)
                .admin(false)
                .build();
        accountService.save(account);
        return "redirect:/admin/account/view";
    }

    @PostMapping("update")
    public String update(ModelMap model, @RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam("fullname") String fullname,
                             @RequestParam("email") String email,
                             @RequestParam("photo") MultipartFile photo,
                             @RequestParam("active") boolean active,
                             @RequestParam("admin") boolean admin) {

        if (photo.isEmpty()){
            model.addAttribute("mess", "Vui lòng chọn file");
        } else {
            try {
                String imagePath = context.getRealPath("/avata/" + photo.getOriginalFilename());
                photo.transferTo(new File(imagePath));
                model.addAttribute("photo", imagePath);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        Account account = Account.builder()
                .username(username)
                .password(password)
                .fullname(fullname)
                .email(email)
                .photo(photo.getOriginalFilename())
                .active(active)
                .admin(admin)
                .build();
        Account findAcc = accountService.findByUser(username).orElse(null);
        account.setUsername(findAcc.getUsername());
        BeanUtils.copyProperties(account, findAcc);
        accountService.save(findAcc);
        return "redirect:/admin/account/view";
    }

    @GetMapping("delete/{username}")
    public String delete(@PathVariable("username") String username) {
        accountService.deleteById(username);
        return "redirect:/admin/account/view";
    }

}
