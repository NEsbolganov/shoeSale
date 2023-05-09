package com.example.Shoes.DB.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {
    public List<Shoe> shoeList = new ArrayList<>();

    public CartController(List<Shoe> shoeList) {
        this.shoeList = shoeList;
    }

    @GetMapping("/cart")
    public String cart(Model model){
        int sum =0;
        for (int i = 0; i < shoeList.size(); i++) {
            sum+=shoeList.get(i).getPrice();
        }
        model.addAttribute("cartList",shoeList);
        model.addAttribute("sum",sum);
        return "cart";
    }
}
