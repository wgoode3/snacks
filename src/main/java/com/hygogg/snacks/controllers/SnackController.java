package com.hygogg.snacks.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hygogg.snacks.models.Snack;
import com.hygogg.snacks.services.SnackService;

@Controller
public class SnackController {

	private final SnackService snackService;
	
	public SnackController(SnackService snackService) {
		this.snackService = snackService;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("snacks", snackService.getAll());
		return "index.jsp";
	}
	
	@RequestMapping("/snacks")
	public String create(@RequestParam Map<String, String> body) {
		System.out.println(body);
		Snack toSave = new Snack(
				body.get("name"), 
				body.get("flavor"), 
				Integer.parseInt(body.get("calories"))
		);
		snackService.create(toSave);
		return "redirect:/";
	}
	
}

