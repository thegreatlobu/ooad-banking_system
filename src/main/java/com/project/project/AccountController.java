package com.project.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    private DBService service = DBService.getInstance();

    @GetMapping("/create_account/{accno}")
    public String create_account(@PathVariable String accno, Model model)
    {
        Account account = new Account();
        model.addAttribute("account", account);
        model.addAttribute("accno", accno);
        return "create_account";
    }

    @PostMapping("/create_account/{accno}")
    public String create_account(@PathVariable String accno, @ModelAttribute("Account") Account account)
    {
        service.addAccount(account.getAccount_no(), account.getUsername(), account.getAcctype(), account.getBalance());
        System.out.println("name" + account.getUsername());
        System.out.println("type" + account.getAcctype());
        System.out.println("balance" + account.getBalance());
        System.out.println("accno" + account.getAccount_no());

        return "redirect:/home/" + account.getAccount_no();
    }
}
