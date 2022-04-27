package com.project.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePageController {
    private DBService service = new DBService();

    @GetMapping("/home")
    public String home(@RequestParam(value="accno") String accno, Model model)
    {
        int account_no = Integer.parseInt(accno);
        User user = service.getUser(account_no);
        System.out.println(user.getAccount_no());
        model.addAttribute("user", user);
        return "home";
    }



    @PostMapping("/home")
    public String home(@RequestParam(value="accno") String accno)
    {
        return "redirect:/create_account";
    }

}

