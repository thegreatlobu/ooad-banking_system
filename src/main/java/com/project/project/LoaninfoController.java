package com.project.project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoaninfoController {
    private DBService service = DBService.getInstance();

    @GetMapping("/loaninfo/{accno}")
    public String loaninfo(@PathVariable String accno,  Model model)
    {
        int account_no = Integer.parseInt(accno);
        Loan loan  = service.getloan(account_no);
        int custid = loan.getcustid();
        int amt = loan.getamt();
        int duration = loan.getduration();
        int emi = loan.getemi();
        double rate = loan.getrate();
        String type = loan.gettype();

        model.addAttribute("loan", loan);
        model.addAttribute("custid", custid);
        model.addAttribute("amt", amt);
        model.addAttribute("duration", duration);
        model.addAttribute("emi", emi);
        model.addAttribute("rate", rate);
        model.addAttribute("type", type);
        System.out.println("end of add attr");
        return "loaninfo";
    }
}

