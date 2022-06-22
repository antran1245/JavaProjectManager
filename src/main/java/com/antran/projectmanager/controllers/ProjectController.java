package com.antran.projectmanager.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.antran.projectmanager.models.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {

//	======================= Display ============================
	@GetMapping("/new")
	public String newProject(Model model) {
		model.addAttribute("newProject", new Project());
		return "/project/addProject.jsp";
	}
	
//	======================= Action =============================
	@PostMapping("/new")
	public String createProject(@Valid @ModelAttribute("newProject") Project project, BindingResult result) {
		
		if(result.hasErrors()) {
			return "/project/addProject.jsp";
		}
		return "redirect:/dashboard";
	}
}
