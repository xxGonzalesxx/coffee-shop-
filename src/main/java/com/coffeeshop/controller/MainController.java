package com.coffeeshop.controller;

import com.coffeeshop.entity.Order;
import com.coffeeshop.repository.OrderRepository;
import com.coffeeshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class MainController {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("featured", productRepository.findByCategory("coffee"));
        return "index";
    }

    @GetMapping("/menu")
    public String menu(Model model) {
        model.addAttribute("coffees", productRepository.findByCategory("coffee"));
        model.addAttribute("teas", productRepository.findByCategory("tea"));
        model.addAttribute("desserts", productRepository.findByCategory("dessert"));
        return "menu";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/order")
    public String order(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("products", productRepository.findAll());
        return "order";
    }

    @PostMapping("/order")
    public String submitOrder(@ModelAttribute Order order) {
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus("pending");
        orderRepository.save(order);
        return "redirect:/order-success";
    }

    @GetMapping("/order-success")
    public String orderSuccess() {
        return "order-success";
    }
}
