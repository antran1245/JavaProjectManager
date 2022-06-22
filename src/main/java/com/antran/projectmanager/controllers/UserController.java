package com.antran.projectmanager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.antran.projectmanager.models.LoginUser;
import com.antran.projectmanager.models.User;
import com.antran.projectmanager.services.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
//	================== Display ==================
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "/login/login.jsp";
	}
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		Long id = (Long)session.getAttribute("uuid");
		User user = userService.findUser(id);
		model.addAttribute("user", user);
		return "dashboard.jsp";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("uuid");
		return "redirect:/";
	}
//	=================== Action ====================
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model, HttpSession session) {
		User user = userService.login(loginUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "/login/login.jsp";
		}
		session.setAttribute("uuid", user.getId());
		return "redirect:/dashboard";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User user, BindingResult result, Model model, HttpSession session) {
		User newUser = userService.register(user, result);
		if(result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "/login/login.jsp";
		}
		session.setAttribute("uuid", newUser.getId());
		return "redirect:/dashboard";
	}
}
