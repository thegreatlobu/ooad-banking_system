package com.project.project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FDinfoController {
    private DBService service = DBService.getInstance();
    @GetMapping("/fdinfo/{accno}")
    public String fdinfo(@PathVariable String accno, Model model)
    {
        int account_no = Integer.parseInt(accno);
        FD fd  = service.getfd(account_no);
        int amt = fd.getamt();
        int duration = fd.getduration();
        int months = duration/30;
        double maturity = 0;
        if(months <= 1)
        {
            maturity = amt + amt*0.025;
        }
        else if(months<=2 && months>1)
        {
            maturity = amt + amt*0.04;
        }
        else if(months<=3 && months>2)
        {
            maturity = amt*0.05 + amt;
        }
        else if(months<=6 && months>3)
        {
            maturity = amt*0.055 + amt;
        }
        else if(months<=12 && months>6)
        {
            maturity = amt*0.06 + amt;
        }
        model.addAttribute("fd", fd);
        model.addAttribute("amt", amt);
        System.out.println(months);
        model.addAttribute("duration", months);
        System.out.println("maturity" + maturity);
        model.addAttribute("maturity", maturity);
        System.out.println(amt  + duration);
        return "fdinfo";
    }
}

