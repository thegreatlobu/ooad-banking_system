package com.project.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AccountController {
    @GetMapping("/create_account/{accno}")
    public String create_account(@PathVariable String accno)
    {
        System.out.println(accno);
        return "create_account";
    }
}
