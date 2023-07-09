package com.foly.assignment.controller.admin;

import com.foly.assignment.entity.Category;
import com.foly.assignment.service.CategoryService;
import com.foly.assignment.service.impl.CategoryServiceImpl;
import jakarta.servlet.ServletContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequestMapping("/admin/category/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService = new CategoryServiceImpl();

    @GetMapping("view")
    public String getAll(@RequestParam(defaultValue = "1") int page, Model model) {
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 2);
        Page<Category> listCategory = categoryService.findAll(pageable);
        model.addAttribute("listCategory", listCategory);
        return "admin/category/index";
    }

    @GetMapping("detail{id}")
    public String detail(@PathVariable("id") String id, Model model, @RequestParam(defaultValue = "1") int page){
        Category category = categoryService.findById(id).orElse(null);
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 2);
        Page<Category> listCategory = categoryService.findAll(pageable);
        model.addAttribute("category", category);
        model.addAttribute("listCategory", listCategory);
        return "admin/category/detail";
    }

    @GetMapping("view-add")
    public String viewAdd(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "admin/category/add";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") String id, Model model) {
        Category category = categoryService.findById(id).orElse(null);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("category", category);
        return "admin/category/update";
    }

    @Autowired
    ServletContext context;
    @PostMapping("add")
    public String addMayTinh(@RequestParam("id") String id,@RequestParam("name") String name) {

        Category category = Category.builder()
                .id(id)
                .name(name)
                .build();
        categoryService.save(category);
        return "redirect:/admin/category/view";
    }

    @PostMapping("update")
    public String updateMayTinh(@RequestParam("id") String id, @RequestParam("name") String name) {

        Category category = Category.builder()
                .id(id)
                .name(name)
                .build();
        Category findCategory = categoryService.findById(id).orElse(null);
        category.setId(findCategory.getId());
        BeanUtils.copyProperties(category, findCategory);
        categoryService.save(category);
        return "redirect:/admin/category/view";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        categoryService.deleteById(id);
        return "redirect:/admin/category/view";
    }

}
