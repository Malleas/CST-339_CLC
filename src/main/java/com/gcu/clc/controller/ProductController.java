package com.gcu.clc.controller;

import com.gcu.clc.business.ProductBusinessService;
import com.gcu.clc.data.ProductDataService;
import com.gcu.clc.model.LoginModel;
import com.gcu.clc.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/delete/{id}")
    public ModelAndView displayDeleteProducts(@RequestParam(value = "id") int id)
    {
        ModelAndView modelAndView = new ModelAndView();
        ProductModel productModel = productBusinessService.getProduct(id);
        modelAndView.addObject("title", "Edit Product Page");
        modelAndView.addObject("productModel", productModel);
        modelAndView.addObject("productID", productModel.getProductId());
        modelAndView.setViewName("deleteProduct");
        return modelAndView;

    }

    @PostMapping("/addProduct")
    public String addProduct(@Valid ProductModel productModel, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Add Product Page");
            return "addProduct";
        }
        if(productBusinessService.addProduct(productModel)){
            return "index";
        }else {
            return "addProduct";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@Valid ProductModel productModel, BindingResult bindingResult, @RequestParam(value = "id") int id)
    {
        if(productBusinessService.deleteProduct(id))
        {
            return "index";
        } else {
            return "deleteProduct";
        }
    }
}
