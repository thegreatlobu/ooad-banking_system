package com.project.project;

import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProjectController {
  private ProjectService service = new ProjectService();


  @RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login()
    {
        //service.getAllUsers();
		return "login";
    }
  @RequestMapping(value = "/login",method = RequestMethod.POST)
  public String input(String userName,String password){
      return "login";
  }

}
