package com.project.project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TransactionController {
    private DBService service = DBService.getInstance();
//    @GetMapping("/transaction/{account_no}")
//    public String Transaction(@PathVariable int account_no,Model model){
//        TransactionClass transfer = new TransactionClass();
//        model.addAttribute("transfer",transfer);
//        return "transaction";
//
//    }
    @GetMapping("/transaction/{acc_no}")
    public String Transaction(@PathVariable int acc_no, Model model){
        TransactionClass transfer = new TransactionClass();
        double bal = service.getBalance(acc_no, "Savings");
        model.addAttribute("transfer",transfer);
        model.addAttribute("accno",acc_no);
        model.addAttribute("bal", bal);
        return "transaction";

    }
//    @PostMapping("/transaction/{accountno}/{}")
//    public String TransferFunds(@PathVariable int accountno,@ModelAttribute TransactionClass transfer){
//        boolean type = transfer.getType();
//        service.getBalance(accountno,type);
//        return "redirect:/home";
//    }
@PostMapping("/transaction/{acc_no}")
public String TransferFunds(@PathVariable int acc_no,@ModelAttribute("TransactionClass") TransactionClass transfer){
    transfer.setAccountno_user(acc_no);
   System.out.println(transfer.gettype());
   System.out.println(transfer.getAccountno_user());
   System.out.println(transfer.getValue());
   System.out.println(transfer.getAccountno());
    double val = service.getBalance(acc_no,"Savings");
    //System.out.println(val);
    service.updateBalance(acc_no,transfer.getAccountno(),transfer.getValue(),transfer.gettype());
    return "redirect:/home/"+ acc_no;
}
}
