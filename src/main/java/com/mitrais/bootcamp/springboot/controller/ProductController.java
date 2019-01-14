package com.mitrais.bootcamp.springboot.controller;

import com.mitrais.bootcamp.springboot.dao.ProductDao;
import com.mitrais.bootcamp.springboot.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductDao productDao;
    private static final String VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM = "products/edit";
    private static final String VIEWS_PRODUCT_LIST = "products/list";

    public ProductController(ProductDao dao){
        this.productDao = dao;
    }

    @GetMapping("")
    private String findAll(Model model){
        model.addAttribute("list", productDao.findAll());
        return VIEWS_PRODUCT_LIST;
    }

    public String addUser(@Valid Product user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-product";
        }

    productDao.save(user);
        model.addAttribute("product", productDao.findAll());
        return "welcome";
    }

    @GetMapping("new")
    private String newForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("new")
    private String create(@Valid Product product
            , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
        }else{
            this.productDao.save(product);
            return "redirect:/products" ;
        }
    }

    @GetMapping("{id}/edit")
    private String initUpdateUserForm(@PathVariable Long id, Model model){
        model.addAttribute("product", productDao.findOne(id));
        return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("{id}/edit")
    private String updateUser(@Valid Product product, BindingResult bindingResult, @PathVariable Long id){
        if(bindingResult.hasErrors()){
            return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
        }else{
            product.setId(id);
            this.productDao.save(product);
            return "redirect:/products" ;
        }
    }

    @GetMapping("{id}/delete")
    private ModelAndView deleteUser(@PathVariable Long id){
        productDao.delete(id);
        return new ModelAndView("redirect:/users");
    }

    @PostMapping
    private String create(@RequestBody Product user){
        productDao.save(user);
        return VIEWS_PRODUCT_LIST;
    }

}
