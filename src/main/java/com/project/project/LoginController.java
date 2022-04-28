package com.project.project;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
  private DBService service = new DBService();

  @GetMapping("/")
  public String login(Model model)
  {
    User user = new User();
    model.addAttribute("user", user);
    return "login";
  }

  
  @PostMapping("/")
	public String login(@ModelAttribute("User") User user)
  {
    ArrayList<User> users = service.getAllUsers();
    for(User u:users)
    {
      int db_accuser = u.getAccount_no();
      String db_pwduser = u.getPassword();
      System.out.println(db_accuser + db_pwduser);
      System.out.println("Input " + user.getAccount_no() + user.getPassword());
      if (user.getAccount_no() == db_accuser && user.getPassword().equals(db_pwduser))
      {
        //Redirect to home page
        System.out.println("Login Succesfull!!!!!!!!!!!!!!!");
        return "redirect:/home/"+u.getAccount_no();
      }
      else{
      //TODO: Generate alert for invalid login

      
      }
    }
		return "login";
  }

  @GetMapping("/signup")
  public String signup(Model model)
  {
    User user = new User();
    model.addAttribute("user", user);
    return "signup";
  }

  @PostMapping("/signup")
  public String signup(@ModelAttribute("User") User user)
  {
    //Add user to database
    service.addUser(user.getPassword(), user.getDOB(), user.getPan_no(), user.getAadhar_no(), user.getPhone_no(), user.getUsername());
    return "login";
  }


}
