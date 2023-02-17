package com.javastack.spring.safetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.javastack.spring.safetravels.models.Travel;
import com.javastack.spring.safetravels.service.TravelService;

@Controller
public class MainController {
	@Autowired
	TravelService travelService;
	
	@GetMapping("/")
	public String home(@ModelAttribute("travel") Travel travel, Model model) {
		List<Travel> travels = travelService.allTravels();
		model.addAttribute("travels", travels);
		return "index.jsp";
	}
	
	@PostMapping("/addTravel")
	public String home(@Valid @ModelAttribute("travel") 
		Travel travel, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Travel> travels = travelService.allTravels();
			model.addAttribute("travels", travels);
			return "index.jsp";
		}
		travelService.addTravel(travel);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editTravel(@PathVariable("id") Long id, @ModelAttribute("travel") Travel travel, Model model) {
		model.addAttribute("travel", travelService.findTravel(id));
		return "edit.jsp";
	}
	
	@PostMapping("/edit/{id}")
	public String updateTravel(@Valid @ModelAttribute("travel") 
		Travel travel, BindingResult result, @PathVariable("id") Long id, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("travel", travel);
			return "index.jsp";
		}
		travelService.updateTravel(travel);
		return "redirect:/";
	}
	
	@DeleteMapping("travel/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		travelService.deleteTravelById(id);
	    return "redirect:/";
	}
	
	@GetMapping("/travel/{id}")
	public String oneTravel(@PathVariable("id") Long id, Model model) {
		Travel travel = travelService.findTravel(id);
		model.addAttribute("travel", travel);
		return "show.jsp";
	}


}
