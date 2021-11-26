package com.gcu.clc.controller;

import com.gcu.clc.business.ProductBusinessService;
import com.gcu.clc.model.LoginModel;
import com.gcu.clc.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductBusinessService productBusinessService;

    @GetMapping("/")
    public ModelAndView display(){
        ModelAndView modelAndView = new ModelAndView();
        ProductModel productModel = new ProductModel();
        modelAndView.addObject("title", "Product Page");
        modelAndView.addObject("productModel", productModel);
        modelAndView.setViewName("products");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView displayAddProducts(){
        ModelAndView modelAndView = new ModelAndView();
        ProductModel productModel = new ProductModel();
        modelAndView.addObject("title", "Add Product Page");
        modelAndView.addObject("productModel", productModel);
        modelAndView.setViewName("addProduct");
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView displayEditProducts(){
        ModelAndView modelAndView = new ModelAndView();
        ProductModel productModel = new ProductModel();
        modelAndView.addObject("title", "Edit Product Page");
        modelAndView.addObject("productModel", productModel);
        modelAndView.setViewName("editProduct");
        return modelAndView;
    }

    @PostMapping("/addProduct")
    public String addProduct(@Valid ProductModel productModel, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Add Product Page");
            return "addProduct";
        }
        productBusinessService.addProduct(productModel.getProductName(), productModel.getProductDescription(),
                productModel.getProductPrice(), productModel.getProductQuantity());
        return "index";
    }
}
