package com.project.project;

import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProjectController {
  private ProjectService service = new ProjectService();


  @GetMapping("/login")
	public String login()
  {
    service.getAllUsers();
		return "login";
  }

}
