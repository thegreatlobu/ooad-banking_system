package com.project.project;
import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoanController {
    private DBService service = DBService.getInstance();

    @GetMapping("/loan/{accno}")
    public String loan(@PathVariable String accno, Model model)
    {
        Loan loan = new Loan();
        model.addAttribute("loan", loan);
        model.addAttribute("accno", accno);
        return "loan";
    }

    @PostMapping("/loan/{accno}")
    public String loan(@PathVariable String accno, @ModelAttribute("Loan") Loan loan)
    {
        int account_no = Integer.parseInt(accno);
        int amt = loan.getamt();
        int duration = loan.getduration();    
        String type = loan.gettype();
        double rate = 0.04;
        int emi = (int)(((amt*rate)*(Math.pow((1+rate),duration)))/((Math.pow((1+rate),duration)-1)));
        service.addloan(account_no, loan.getamt(), loan.getduration(),emi, rate, loan.gettype());
        return "redirect:/loaninfo/" + account_no ;
    }
}

