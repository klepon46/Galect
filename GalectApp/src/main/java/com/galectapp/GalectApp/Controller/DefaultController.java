package com.galectapp.GalectApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.galect.util.JsonParser;
import com.galectapp.model.Employee;

@Controller
@RequestMapping("/galect")
public class DefaultController {

	@RequestMapping("/default")
	public String index(Model model) {
		String urlRedirect = determinePage();
		return "redirect:"+urlRedirect;
		//return "redirect:deanship";
	}
	
	private String determinePage() {

		String redirect = null;
		JsonParser jp = new JsonParser();
		jp.getJsonFromLocal("json/test.json");

		Employee employee = jp.parseJsonToModel();

		String jobTitle = employee.getJobTitle();
		
		if (jobTitle.equalsIgnoreCase("Dean, Graduate Studies") 
				|| jobTitle.equalsIgnoreCase("graduate")) {
			redirect = "deanship";
		} else if (jobTitle.equalsIgnoreCase("Dean,")) {
			String collegeID = "1";//assume JSON have collegeID
			redirect = "dean/"+collegeID;
		} else if (jobTitle.equalsIgnoreCase("Chairman")) {
			redirect = "chairman?deptName="+employee.getDepartment();
		}else if (jobTitle.equalsIgnoreCase("lecturer")){
			redirect = "student/"+ employee.getStaffID();
		}
		
		return redirect;
	}

}
