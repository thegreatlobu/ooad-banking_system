package com.project.project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TransactionController {
    private DBService service = new DBService();
    @GetMapping("/{account_no}/transaction")
    public String Transaction(@PathVariable int account_no,Model model){
        TransactionClass transfer = new TransactionClass();
        model.addAttribute("transfer",transfer);
        return "transaction";
    }
    @PostMapping("/{account_no}/transaction")
    public String TransferFunds(@PathVariable int account_no,Model model){

        return "redirect:/{" + account_no + "}/home";
    }
}
