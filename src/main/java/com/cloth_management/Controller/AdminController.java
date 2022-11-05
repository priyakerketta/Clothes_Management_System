package com.cloth_management.Controller;

import com.cloth_management.service.SecurityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @Autowired
    SecurityServices securityServices;

    @GetMapping("/admin")
    public String adminHome()
    {
        return "admin";
    }


}
