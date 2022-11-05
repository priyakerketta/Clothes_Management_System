package com.cloth_management.Controller;

import com.cloth_management.Models.User;
import com.cloth_management.Repository.UserRepositoryImpl;
import com.cloth_management.service.SecurityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    private SecurityServices securityServices;
    @Autowired
    private UserRepositoryImpl userRepositoryImpl;
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
//        model.addAttribute("naam",securityservices.findLoggedInUsername());
        model.addAttribute("customer", new User());
        model.addAttribute("error_msg", "errorrr!!");
        return "register";
    }
    @RequestMapping(path="/register",method= RequestMethod.POST)
    public String makeit(User user, Model model){
//        if(userRepositoryImpl.getCustomerbyUsername(user.getUsername()) != null)
//        {
////            model.addAttribute("naam",securityservices.findLoggedInUsername());
//            model.addAttribute("customer", new User());
//            model.addAttribute("error_msg", "Username already exists!!");
//            return "signup";
//        }
        userRepositoryImpl.addUser(user);
//        customerRepository.addCustomer(customer.getFirstName(), customer.getLastName(), customer.getEmailAddress(), customer.getUserName(), customer.getPassword(),"user");
        return "redirect:/login";
    }

}
