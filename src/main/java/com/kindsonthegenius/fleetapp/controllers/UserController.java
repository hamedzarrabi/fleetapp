package com.kindsonthegenius.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kindsonthegenius.fleetapp.models.User;
import com.kindsonthegenius.fleetapp.services.UserService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public String getUser(Model model) {
		
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);
		
		return "user";
	}
	
	@PostMapping("/user/addNew")
	public RedirectView addNew(User user, RedirectAttributes redir) {
		
		userService.save(user);

		RedirectView redirectView = new RedirectView("/login", true);
		redir.addFlashAttribute("message", "You successfully registered! You can now login");
		return redirectView;
	}
	
	@RequestMapping(value = "/user/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		
		userService.delete(id);
		return "redirect:/user";
	}
	
	@RequestMapping(value = "/user/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(User user) {
		userService.save(user);
		return "redirect:/user";
	}
	
	@RequestMapping("/user/findById")
	@ResponseBody
	public Optional<User> findById(Integer id) {
		return userService.findById(id);
	}
	
	
}
