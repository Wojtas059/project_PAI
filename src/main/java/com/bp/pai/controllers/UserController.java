/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bp.pai.controllers;

/**
 *
 * @author wojto
 */
import com.bp.pai.dao.userDao;
import com.bp.pai.dao.alcoholDao;
import com.bp.pai.entity.User;
import com.bp.pai.entity.Alcohol;
import static java.lang.System.out;
import java.security.Principal;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private userDao dao;
    @Autowired
    private alcoholDao alcodao;

    @GetMapping("/login")
    public String loginPage() {
        //zwrócenie nazwy widoku logowania - login.html
        return "login";
    }
    
    @GetMapping("/register")
    public String registerPage(Model m) {
        //dodanie do modelu nowego użytkownika
        m.addAttribute("user", new User());
        //zwrócenie nazwy widoku rejestracji - register.html
        return "register";
    }
    
    

    @PostMapping("/register")
    public String registerPagePOST(@ModelAttribute(value = "user") @Valid User user, BindingResult binding) {
        if (dao.findByLogin(user.getLogin()) != null)
        {
            binding.rejectValue("login", "error.login", "Konto o podanym loginie już istnieje.");
            
        }
        if (dao.findByEmail(user.getEmail()) != null)
        {   
            binding.rejectValue("email", "error.email", "Konto o podanym emailu juz istnije ");
           
        }
        if (binding.hasErrors()) {
            return "register"; // powrót do formularza
        }
        
        
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);
        //przekierowanie do adresu url: /login
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String profilePage(Model m, Principal principal) {
        //dodanie do modelu obiektu user - aktualnie zalogowanego użytkownika:
        m.addAttribute("user", dao.findByLogin(principal.getName()));
        //zwrócenie nazwy widoku profilu użytkownika - profile.html
        return "profile";
    }


    @GetMapping("/see")
    public String seePage(Model m) {

        m.addAttribute("alcohols", alcodao.findAll());
        m.addAttribute("users", dao);
        return "see";
    }
    @GetMapping("/editdesc")
    public String editdescPage(Model m, Principal principal) {
        m.addAttribute("alcohols", alcodao.findByUserid(dao.findByLogin(principal.getName()).getUserid()));
        return "editdesc";
    }
    
    @GetMapping("/editdescid/{alcoid}")
    public String editdescidPage(Model m, Principal principal, @PathVariable("alcoid") int alcoid) {
        out.print(alcoid);
        m.addAttribute( alcodao.findByAlcoid(alcoid));
        return "editdescid";
    }
    @PostMapping("/editdescid")
    public String saveEditdescPage(@ModelAttribute(value = "alcohol") @Valid Alcohol alcohol, BindingResult binding, Principal principal) {
        if (binding.hasErrors()) {
            return "editdescid"; // powrót do formularza
        }
        alcohol.setUserid(dao.findByLogin(principal.getName()).getUserid());
        alcohol.setLike_(0);
        out.print("id: "+alcohol.getAlcoid());
        alcodao.save(alcohol);
        //przekierowanie do adresu url: /login
        return "redirect:/editdesc";
    }
    
    
    

    @GetMapping("/logout")
    public String logoutPage() {
        //dodanie do modelu nowego użytkownika
        return "login";
    }

    @GetMapping("/delete")
    public String deletePage(Principal principal) {
        dao.delete(dao.findByLogin(principal.getName()));
        return "redirect:/login";
    }

    @GetMapping("/edit")
    public String editPage(Model m, Principal principal) {
        m.addAttribute(dao.findByLogin(principal.getName()));
        return "edit";
    }

    @PostMapping("/edit")
    public String saveEditPage(@ModelAttribute(value = "user") @Valid User user, BindingResult binding) {
        if (binding.hasErrors()) {
            return "edit"; // powrót do formularza
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        dao.save(user);
        return "profile";
    }
    
    @GetMapping("/add")
    public String addPage(Model m, Principal principal) {
        m.addAttribute("alcohol", new Alcohol());
        return "add";
    }
    
    @PostMapping("/add")
    public String addPagePOST(@ModelAttribute(value = "alcohol") @Valid Alcohol alcohol, BindingResult binding, Principal principal) {

        if (binding.hasErrors()) {
           return "add"; // powrót do formularza
        }
        
        alcohol.setUserid(dao.findByLogin(principal.getName()).getUserid());
        alcohol.setLike_(0);
        alcodao.save(alcohol);
        //przekierowanie do adresu url: /login
        return "redirect:/see";
    }
    
    
}   
