package com.project.project;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
  private DBService service = DBService.getInstance();

  

  @GetMapping("/")
  public String login(Model model)
  {
    User user = new User();
    // User user1 = service.getUser(1);
    // System.out.println(user1.getAccount_no());
    // System.out.println(user1);
    model.addAttribute("user", user);
    return "login";
  }

  
  @PostMapping("/")
	public String login(@ModelAttribute("User") User user)
  {
    System.out.println("Hash code of service obj in LoginController" + service.hashCode());
    ArrayList<User> users = service.getAllUsers();
    for(User u:users)
    {
      int db_accuser = u.getAccount_no();
      String db_pwduser = u.getPassword();
      // System.out.println(db_accuser + db_pwduser);
      // System.out.println("Input " + user.getAccount_no() + user.getPassword());
      if (user.getAccount_no() == db_accuser && user.getPassword().equals(db_pwduser))
      {
        //Redirect to home page
        System.out.println("Login Successfull!!!!!!!!!!!!!!!");
        return "redirect:/home/" + user.getAccount_no();
      }

      //TODO: Generate alert for invalid login
      System.out.println("Invalid Credentials. Please Try Again");

      
    }
		return "login";
  }

  @GetMapping("/signup")
  public String signup(Model model)
  {
    User user = new User();
    model.addAttribute("User", user);
    return "signup";
  }

  @PostMapping("/signup")
  public String signup(@ModelAttribute("User") User user)
  {
    //Add user to database
    // System.out.println(user);
    // System.out.println(user.getAccount_no());
    // System.out.println(user.getpan_no());
    // System.out.println(user.getPhone_no());
    // System.out.println(user.getDOB());
    // System.out.println(user.getAadhar_no());
    service.addUser(user.getPassword(), user.getDOB(), user.getpan_no(), user.getAadhar_no(), user.getPhone_no(), user.getUsername());
    return "signup";
  }


}
