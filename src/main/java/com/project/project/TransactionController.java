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
//    @GetMapping("/transaction/{account_no}")
//    public String Transaction(@PathVariable int account_no,Model model){
//        TransactionClass transfer = new TransactionClass();
//        model.addAttribute("transfer",transfer);
//        return "transaction";
//
//    }
    @GetMapping("/transaction")
    public String Transaction(Model model){
        TransactionClass transfer = new TransactionClass();
        model.addAttribute("transfer",transfer);
        return "transaction";

    }
//    @PostMapping("/transaction/{accountno}/{}")
//    public String TransferFunds(@PathVariable int accountno,@ModelAttribute TransactionClass transfer){
//        boolean type = transfer.getType();
//        service.getBalance(accountno,type);
//        return "redirect:/home";
//    }
@PostMapping("/transaction")
public String TransferFunds(@ModelAttribute TransactionClass transfer){
    boolean type = transfer.getType();
    service.getBalance(1,type);
    return "redirect:/home/{"+ transfer.getAccountno_user() +"}";
}
}
