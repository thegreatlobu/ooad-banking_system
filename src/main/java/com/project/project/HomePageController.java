package com.project.project;

// import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePageController {
    private DBService service = DBService.getInstance();

    @GetMapping("/home/{accno}")
    public String home(@PathVariable String accno, Model model)
    {
        System.out.println("Hash code of service obj in HomePageController" + service.hashCode());
        int account_no = Integer.parseInt(accno);
        User user = service.getUser(account_no);
        // System.out.println(user.getAccount_no());
        // System.out.println(user);
        Account account = service.getAccount(account_no);
        model.addAttribute("user", user);
        model.addAttribute("account", account);
        return "homenew";
    }



    @PostMapping("/home/{accno}")
    public String home(@PathVariable String accno, @ModelAttribute("User") User user)
    {
        
        return "redirect:/create_account";
    }

}

