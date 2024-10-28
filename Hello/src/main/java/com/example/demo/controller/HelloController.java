package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.HelloModel;

import com.example.demo.repository.HelloRepository;

@Controller
public class HelloController {
	@Autowired
	HelloRepository ar;
	@PostMapping("/insertData")
	public String insertData(HelloModel am)
	{
		
		ar .save(am);
		return "redirect:/display";

	}
	
	
	@GetMapping("/display")
	public String displayCar(Model model)
	{	
		List<HelloModel> student_list=(List<HelloModel>)ar.findAll();
		model.addAttribute("students",student_list);
		return "display";
	}
	
	@PostMapping("/deletebyid")
	public String deletebyid(int id)
	{
		try
		{
			ar .deleteById(id);
		}
		catch(Exception e)
		{
			System.out.println("error");
		}
			return "data deleted";
	}
	
	@GetMapping("/deleteall")
	public String deleteall()
	{
		try
		{
			ar .deleteAll();
		}
		catch(Exception e)
		{
			System.out.println("error");
		}
		return "all data deleted";
	}
	
	@GetMapping("/edit/{id}")
	public String editCar(@PathVariable("id")Integer id, Model model)
	{	
		HelloModel students =	ar.findById(id).get();
		model.addAttribute("students",students);
		return "edit";
	}
	@PostMapping("/editAction")
	public String editCar(HelloModel c)
	{	
		Integer id=c.getId();
		String name = c.getName();
		int marks = c.getMarks();
		HelloModel stu =	ar.findById(id).get();
		
		stu.setName(name);
		stu.setMarks(marks);

		
		ar.save(stu);
		
		
		return "redirect:/display";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCar(@PathVariable("id")Integer id)
	{	
		ar.deleteById(id);
		return "redirect:/display";
		
	}
	
}

