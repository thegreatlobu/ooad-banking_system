package com.project.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomePageController {
    @GetMapping("/home/{accountno}")
    public String home(@PathVariable String accountno)
    {
        return "homenew";
    }
}

