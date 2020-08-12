package com.hygogg.snacks.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hygogg.snacks.models.Snack;
import com.hygogg.snacks.services.SnackService;


@Controller
public class SnackController {

	private final SnackService snackService;
	
	public SnackController(SnackService snackService) {
		this.snackService = snackService;
	}
	
	@RequestMapping("/")
	public String index(Model model, HttpServletRequest request) {
		String q = request.getParameter("q");
		System.out.println(q);
		if(q == null) {
			model.addAttribute("all", snackService.getAll());			
		} else {
			model.addAttribute("all", snackService.search(q));	
		}
		model.addAttribute("healthyOptions", snackService.getHealthyOptions());
		model.addAttribute("snack", new Snack());
		return "index.jsp";
	}
	
	@RequestMapping(value="/snacks", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("snack") Snack snack, BindingResult result, Model model) {
		if(result.hasErrors()) {
			// display error messages
			model.addAttribute("all", snackService.getAll());
			return "index.jsp";
		} else {			
			snackService.create(snack);
		}
		return "redirect:/";
	}
	
	@RequestMapping("/snacks/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("snack", snackService.getOne(id));
		return "edit.jsp";
	}
	
	@RequestMapping(value="/snacks/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("snack") Snack snack, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "edit.jsp";
		} else {			
			snackService.update(snack, id);
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/snacks/{id}/remove")
	public String remove(@PathVariable("id") Long id) {
		snackService.remove(id);
		return "redirect:/";
	}
	
}

