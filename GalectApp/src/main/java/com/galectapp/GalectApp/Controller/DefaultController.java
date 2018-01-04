package com.galectapp.GalectApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.galect.repository.CollegeRepo;
import com.galect.util.JsonParser;
import com.galectapp.model.Employee;

@Controller
@RequestMapping("/galect")
public class DefaultController {
	

	@RequestMapping("/default")
	public String index() {
		determinePage();
		return "redirect:deanship";
	}

	private String determinePage(){
		
		JsonParser jp = new JsonParser();
		jp.getJsonFromLocal("json/test.json");
		
		Employee employee = jp.parseJsonToModel();
		
		System.out.println(employee.getJobTitle());
		
		
		return "";
	}

}
