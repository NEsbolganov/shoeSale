package com.example.Shoes.Controllers;

import com.example.Shoes.DB.ShoeService;
import com.example.Shoes.DB.dto.CartController;
import com.example.Shoes.DB.dto.Shoe;
import com.example.Shoes.DB.dto.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    private List<Shoe> shoes = new ArrayList<>();
    private final ShoeService shoeService;
    private final CartController cartController;

    @Autowired
    public MainController(ShoeService shoeService, CartController cartController) {
        this.shoeService = shoeService;
        this.cartController = cartController;
    }

    @GetMapping("/admin")
    public String adminPage(Model model){
//        user newUser = new user();
//        model.addAttribute("user", newUser);
        return "auth";
    }

//    @PostMapping("/process")
//    public String processForm(@RequestBody user user, Model model){
//        if(user.equals(new user("admin","add"))){
//            return "redirect:/add";
//        }else{
//            return "redirect:/admin";
//        }
//    }

    @PostMapping("/process")
    public String processForm(@ModelAttribute("user") user user, Model model){
        if(user.equals(new user("admin","add"))){
            return "redirect:/add";
        }else{
            return "redirect:/admin";
        }
    }

    @GetMapping("/add")
    public String addUserPage(Shoe shoe , Model model){
        model.addAttribute("shoe",shoe);
        shoeService.save(shoe);
        return "add";
    }

    @ModelAttribute("cartList")
    public List<Shoe> cartList(){
        return new ArrayList<>();
    }

    @PostMapping("/saveShoe")
    public String saveShoe(Shoe shoe, Model model){
        shoeService.save(shoe);
        model.addAttribute("shoe",new Shoe());
        return "redirect:/add";
    }

    @GetMapping("/shoe/buy")
    public String buy(Model model){
        model.addAttribute("shoeList",shoeService.getAll());
        return "hello";
    }

    @PostMapping("/cart/add")
    public String cart(@RequestParam("id")Integer id, Model model){
        shoes.add(shoeService.get(id));
        cartController.shoeList=shoes;
        model.addAttribute("cartList",shoes);
        return "redirect:/shoe/buy";
    }

    @ModelAttribute("user")
    public user User(){
        return new user();
    }
}
