package com.toDo.todocontroller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.toDo.model.ToDO;
import com.toDo.service.ToDoService;

import jakarta.validation.Valid;

@Controller
public class ToDoController {
	
	@Autowired
    private  ToDoService service;
	
	@GetMapping({"/", "viewToDoList"})
	public String viewAllToDoItem(Model model, @ModelAttribute("message") String message) {
		
		model.addAttribute("list", service.getAllToDoItems());

		model.addAttribute("msg", message);
		
		return "ViewToDoList";
		}
	
	@GetMapping("/updateToDoStatus/{id}")
	public String updateToDoItem(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		
		if(service.updateStatue(id)) {
			redirectAttributes.addFlashAttribute("message", "Upadate Success");
			return "redirect:/viewToDoList";
		}
		redirectAttributes.addFlashAttribute("message", "Upadate Failure");
		return "redirect:/viewToDoList";
	}
	
	@GetMapping("/addToDoItem")
	public String addToDoItem(Model model) {
       	
		model.addAttribute("todo", new ToDO());
		return "AddToDoItem";
	}
	@PostMapping("/saveToDoItem")
	public String saveToDoItem( ToDO todo,BindingResult res, RedirectAttributes redirectAttributes) {
		
		if(service.saveOrUpdateToDoItem(todo)) {
			
			redirectAttributes.addFlashAttribute("message", "Save Success");
			return "redirect:/viewToDoList";
		}
		
		redirectAttributes.addFlashAttribute("message", "Save Failure");
		return "redirect:/addToDoItem";
	} 
	
	@GetMapping("/editToDoItem/{id}")
	public String editToDoItem(@PathVariable Long id, Model model) {
		model.addAttribute("todo",service.getTodoItemById(id));
		
		return "EditToDoItem";		
	}
	
	@PostMapping("/editSaveToDoItem")
	public String editSaveToDoItem(ToDO todo, RedirectAttributes redirectAttributes) {
		
		if(service.saveOrUpdateToDoItem(todo))
		{
			redirectAttributes.addFlashAttribute("message", "Edit Success");
			return "redirect:/viewToDoList";
		}
		redirectAttributes.addFlashAttribute("message", "Edit Failure");
        return "redirect:addToDoItem";
	}
	@GetMapping("/deleteToDoItem/{id}")
	public String deleteToDoItem(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		
		if(service.deleteToDoItem(id))
		{
			
			redirectAttributes.addFlashAttribute("message", "Delete Success");
		}
		else
		redirectAttributes.addFlashAttribute("message", "Delete Failure");
		return "redirect:/viewToDoList";
	}
}
