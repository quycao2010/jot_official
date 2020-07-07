package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class WebController {
    List<Product> products = new CopyOnWriteArrayList<>();
    List<CustomerContact> contacts = new CopyOnWriteArrayList<>();

    @GetMapping("/")
    public String index(Model model){
        products.add(new Product(1,"Wash Denim",550000,"98% cotton & 2% spandex"));
        products.add(new Product(2,"Denim Jacket",600000,"100% denim handle by hands"));
        products.add(new Product(3,"Long Sleeve Tee",750000,"98% cotton & 2% spandex"));
        model.addAttribute("products",products);
        return "index";
    }

    @GetMapping("/products/{productId}")
    public String detailProduct(@PathVariable(name = "productId") Integer id, Model model){
        for(int i = 0 ; i < products.size(); i++){
            if(products.get(i).getId() == id){
                System.out.println(products.get(i).getName());
                model.addAttribute("detailProduct",products.get(i));
            }
        }
        return "detail";
    }

    @PostMapping("/addContact")
    public String addContact(@RequestParam("fullName") String fullName, @RequestParam("email") String email){
        CustomerContact contact = new CustomerContact(email,fullName);
        contacts.add(contact);
        System.out.println("FullName:" + contact.getFullName());
        return "index";
    }
}
