package com.project.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AccountController {
    @GetMapping("/create_account/{accno}")
    public String create_account(@PathVariable String accno, Model model)
    {
        String account_type = new String();
        model.addAttribute("account_type", account_type);
        System.out.println(accno);
        return "create_account";
    }
}
