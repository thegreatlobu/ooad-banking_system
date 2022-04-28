package com.project.project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FDController {
    private DBService service = DBService.getInstance();
    @GetMapping("/fd/{accno}")
    public String fd(@PathVariable String accno, Model model)
    {
        FD fd = new FD();
        model.addAttribute("fd", fd);
        model.addAttribute("accno", accno);
        return "FD";
    }

    @PostMapping("/fd/{accno}")
    public String fd(@PathVariable String accno, @ModelAttribute("FD") FD fd)
    {
        int amt = fd.getamt();
        int duration = fd.getduration();    
        System.out.println(amt + duration);    
        service.addfd(fd.getcustid(), fd.getamt(), fd.getduration());
        return "redirect:/fdinfo/"+accno;
        //return "FD";
    }
}

