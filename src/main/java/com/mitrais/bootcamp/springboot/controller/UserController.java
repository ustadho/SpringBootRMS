package com.mitrais.bootcamp.springboot.controller;

import com.mitrais.bootcamp.springboot.dao.UserDao;
import com.mitrais.bootcamp.springboot.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.net.URI;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserDao userDao;
    private static final String VIEWS_USER_CREATE_OR_UPDATE_FORM = "users/edit";
    private static final String VIEWS_USER_LIST = "users/list";

    public UserController(UserDao ud){
        this.userDao = ud;
    }

    @GetMapping("/signup")
    public  String signup(){
        return "add-users";
    }


    @GetMapping("")
    private String findAll(Model model){
        model.addAttribute("list", userDao.findAll());
        return VIEWS_USER_LIST;
    }

    public String addUser(@Valid User user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-users";
        }

        userDao.save(user);
        model.addAttribute("users", userDao.findAll());
        return "welcome";
    }

    @GetMapping("new")
    private String newForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return VIEWS_USER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("new")
    private String create(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return VIEWS_USER_CREATE_OR_UPDATE_FORM;
        }else{
            this.userDao.save(user);
            return "redirect:/users" ;
        }
    }

    @GetMapping("{id}/edit")
    private String initUpdateUserForm(@PathVariable Long id, Model model){
        model.addAttribute("user", userDao.findOne(id));
        return VIEWS_USER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("{id}/edit")
    private String updateUser(@Valid User user, BindingResult bindingResult, @PathVariable Long id){
        if(bindingResult.hasErrors()){
            return VIEWS_USER_CREATE_OR_UPDATE_FORM;
        }else{
            user.setId(id);
            this.userDao.save(user);
            return "redirect:/users" ;
        }
    }

    @GetMapping("{id}/delete")
    private ModelAndView deleteUser(@PathVariable Long id){
        userDao.delete(id);
        return new ModelAndView("redirect:/users");
    }

    @PostMapping
    private String create(@RequestBody User user){
        userDao.save(user);
        return VIEWS_USER_LIST;
    }

}
