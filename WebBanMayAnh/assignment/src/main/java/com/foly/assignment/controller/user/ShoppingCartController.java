package com.foly.assignment.controller.user;

import com.foly.assignment.entity.Account;
import com.foly.assignment.entity.Cart;
import com.foly.assignment.entity.Item;
import com.foly.assignment.entity.Order;
import com.foly.assignment.entity.Product;
import com.foly.assignment.service.AccountService;
import com.foly.assignment.service.OrderDetailService;
import com.foly.assignment.service.OrderService;
import com.foly.assignment.service.ProductService;
import com.foly.assignment.service.ShoppingCartService;
import com.foly.assignment.service.impl.AccountServiceImpl;
import com.foly.assignment.service.impl.OrderDetailServiceImpl;
import com.foly.assignment.service.impl.OrderServiceImpl;
import com.foly.assignment.service.impl.ProductServiceImpl;
import com.foly.assignment.service.impl.ShoppingCartServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/user/cart/")
public class ShoppingCartController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    ProductService productService = new ProductServiceImpl();

    @Autowired
    OrderService orderService = new OrderServiceImpl();

    @Autowired
    OrderDetailService orderDetailService = new OrderDetailServiceImpl();

    @Autowired
    ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();

    @Autowired
    private AccountService accountService = new AccountServiceImpl();

    ArrayList<Item> list = new ArrayList<>();

    @RequestMapping("view")
    public String view(Model model) {

        if(list.isEmpty()){
            model.addAttribute("mess", "Giỏ hàng của bạn không có sản phẩm nào");
        } else {
            Cart cart = (Cart) httpSession.getAttribute("cart");
            System.out.println(cart.toString());
            list = cart.getItems();
            int tongsp = 0;
            int tongDouble = 0;
            for (Item o : list) {
                tongDouble += Double.parseDouble(String.valueOf(o.getQty()))
                        * Double.parseDouble(String.valueOf(o.getPrice()));

            }

            model.addAttribute("item", list);
            model.addAttribute("tongsp", list.size());
            model.addAttribute("tongth", Integer.valueOf(tongDouble));
            model.addAttribute("tamtinh", Integer.valueOf(tongDouble));
        }
        return "user/cart/index";
    }

    @RequestMapping("add/{id}")
    public String add(@PathVariable("id") Integer id) {
        Optional<Product> product = productService.findById(id);
        Item item = new Item(product.get().getId(),
                product.get().getName(),
                product.get().getPrice(),
                1);
        Cart cartSesion = (Cart) httpSession.getAttribute("cart");
        if (cartSesion == null) {
            Cart cart = new Cart();
            list.add(item);
            cart.setItems(list);
            httpSession.setAttribute("cart", cart);
        } else {
            Cart cart = (Cart) httpSession.getAttribute("cart");
            ArrayList<Item> listItem = cart.getItems();
            for (Item itemTmp : listItem) {
                if (itemTmp.getId().equals(id)) {
                    itemTmp.setQty(item.getQty() + 1);
                    return "redirect:/user/cart/view";
                }
            }
            listItem.add(item);
            System.out.println("add");
        }
        return "redirect:/user/cart/view";
    }

    @RequestMapping("remove/{id}")
    public String remove(Model model, @PathVariable("id") Integer id) {
        list.remove(list.get(Integer.valueOf(id)));
        shoppingCartService.remove(id);
        model.addAttribute("item", list);
        System.out.println("remove");
        return "redirect:/user/cart/view";
    }

    @RequestMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, @RequestParam("qty") int qty) {
        for (Item item : list) {
            if (item.getId() == id) {
                item.setQty(Integer.valueOf(qty));
            }
        }
        return "redirect:/user/cart/view";
    }

    @RequestMapping("clear")
    public String clear() {
        list.clear();
        return "redirect:/user/cart/view";
    }

    @PostMapping("addOrder")
    public String addOrder(Model model,@RequestParam("account") String username,
                           @RequestParam("address") String address) {
        Account account = accountService.findByUser(username).orElse(null);
        Order orders = Order.builder()
                .account(account)
                .address(address)
                .build();
        orders.setCreateDate(new Date());
        Account acc;
        acc = accountService.findByUser(account.getUsername()).get();
        model.addAttribute("user", acc);
        orderService.save(orders);
        list.clear();
        return "redirect:/user/cart/view";
    }

    @PostMapping("addOrderDetail")
    public String addOrderDetail(Model model,@RequestParam("price") Float price,
                                 @RequestParam("quantity") Integer quantity,
                                 @RequestParam("product") Integer productid,
                                 @RequestParam("order") String orderid) {
        Product product = productService.findById(productid).orElse(null);
        Order order = orderService.findById(Integer.valueOf(orderid)).orElse(null);
//        Cart cart = (Cart) httpSession.getAttribute("cart");
//        OrderDetail orderDetail = OrderDetail.builder()
//                .price(Float.valueOf(list.get().getPrice()))
//                .quantity(list.get().getQty())
//                .product(product)
//                .order(order)
//                .build();
//        orderDetailService.save(orderDetail);
        return "redirect:/user/cart/view";
    }

}
