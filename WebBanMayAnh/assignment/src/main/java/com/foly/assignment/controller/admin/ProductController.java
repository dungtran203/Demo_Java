package com.foly.assignment.controller.admin;

import com.foly.assignment.entity.Category;
import com.foly.assignment.entity.Product;
import com.foly.assignment.service.CategoryService;
import com.foly.assignment.service.ProductService;
import com.foly.assignment.service.impl.CategoryServiceImpl;
import com.foly.assignment.service.impl.ProductServiceImpl;
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
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/product/")
public class ProductController {

    @Autowired
    private ProductService productService = new ProductServiceImpl();

    @Autowired
    private CategoryService categoryService = new CategoryServiceImpl();

    @GetMapping("view")
    public String getAll(@RequestParam(defaultValue = "1") int page, Model model) {
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 4);
        Page<Product> listProduct = productService.findAll(pageable);
        model.addAttribute("listProduct", listProduct);
        return "admin/product/index";
    }

    @GetMapping("detail{id}")
    public String detail(@PathVariable("id") String id, Model model, @RequestParam(defaultValue = "1") int page){
        Product product = productService.findById(Integer.valueOf(id)).orElse(null);
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 6);
        Page<Product> listProduct = productService.findAll(pageable);
        model.addAttribute("product", product);
        model.addAttribute("listProduct", listProduct);
        return "admin/product/detail";
    }

    @GetMapping("view-add")
    public String viewAdd(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "admin/product/add";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") String id, Model model) {
        Product product = productService.findById(Integer.valueOf(id)).orElse(null);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("product", product);
        return "admin/product/update";
    }

    @Autowired
    ServletContext context;
    @PostMapping("add")
    public String add(ModelMap model, @RequestParam("name") String name,
                             @RequestParam("image") MultipartFile image, @RequestParam("price") String price,
                             @RequestParam("available") String available, @RequestParam("category") String categoryid ) {

        if (image.isEmpty()){
            model.addAttribute("mess", "Vui lòng chọn file");
        } else {
            try {
                String imagePath = context.getRealPath("/files/" + image.getOriginalFilename());
                image.transferTo(new File(imagePath));
                model.addAttribute("image", imagePath);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        Category category = categoryService.findById(categoryid).orElse(null);
        Product product = Product.builder()
                .name(name)
                .image(image.getOriginalFilename())
                .price(Float.valueOf(price))
                .available(Boolean.valueOf(available))
                .category(category)
                .build();
        product.setCreateDate(new Date());
        productService.save(product);
        return "redirect:/admin/product/view";
    }

    @PostMapping("update")
    public String update(ModelMap model, @RequestParam("id") String id,@RequestParam("name") String name,
                                @RequestParam("image") MultipartFile image,@RequestParam("price") String price,
                                @RequestParam("available") String available,@RequestParam("category") String categoryid ) {

        if (image.isEmpty()){
            model.addAttribute("mess", "Vui lòng chọn file");
        } else {
            try {
                String imagePath = context.getRealPath("/files/" + image.getOriginalFilename());
                image.transferTo(new File(imagePath));
                model.addAttribute("image", imagePath);
            } catch (Exception e){

            }
        }

        Category category = categoryService.findById(id).orElse(null);
        Product product = Product.builder()
                .name(name)
                .image(image.getOriginalFilename())
                .price(Float.valueOf(price))
                .available(Boolean.valueOf(available))
                .category(category)
                .build();
        product.setCreateDate(new Date());
        Product findProduct = productService.findById(Integer.valueOf(id)).orElse(null);
        product.setId(findProduct.getId());
        BeanUtils.copyProperties(product, findProduct);
        productService.save(findProduct);
        return "redirect:/admin/product/view";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        productService.deleteById(Integer.valueOf(id));
        return "redirect:/admin/product/view";
    }

}
