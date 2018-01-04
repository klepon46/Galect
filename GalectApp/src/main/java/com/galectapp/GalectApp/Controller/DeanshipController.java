package com.galectapp.GalectApp.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.galect.bean.College;
import com.galect.bean.Department;
import com.galect.repository.CollegeRepo;
import com.galect.repository.DepartmentRepo;
import com.galect.util.JsonParser;
import com.galect.util.Utility;
import com.galectapp.model.Deanship;
import com.galectapp.model.Employee;

@Controller
@RequestMapping("/galect")
public class DeanshipController {

	@Autowired
	private CollegeRepo collegeRepo;

	@Autowired
	private DepartmentRepo departmentRepo;

	@RequestMapping("/deanship")
	public String deanship(Model model) {
		Deanship deanship = new Deanship();

		List<College> colleges = collegeRepo.findAll();

		model.addAttribute("college", deanship);
		model.addAttribute("departement", new Deanship());
		model.addAttribute("colleges", colleges);

		return "deanship";
	}

	@RequestMapping("/onSelectCollege")
	public String onSelectCollege(@ModelAttribute("college") Deanship deanship, Model model,
			HttpServletRequest request) {

		request.getSession().setAttribute("collegeID", deanship.getCollege());
		Deanship departement = new Deanship();

		int id = Integer.valueOf(deanship.getCollege());
		List<College> colleges = collegeRepo.findAll();
		List<Department> deps = departmentRepo.findByCollegeID(id);

		model.addAttribute("college", deanship);
		model.addAttribute("departement", departement);
		model.addAttribute("colleges", colleges);
		model.addAttribute("deps", deps);

		return "deanship";
	}

	@RequestMapping("/onSelectDepartment")
	public String onSelectDepartment(@ModelAttribute("departement") Deanship deanship, Model model,
			HttpServletRequest request) {

		JsonParser jp = new JsonParser();
		JSONArray jArray = jp.getJsonArray("json/test.json");

		List<Employee> employees = new ArrayList<>();
		for (int i = 0; i < jArray.size(); i++) {

			JSONObject jObj = (JSONObject) jArray.get(i);

			String deptFromJson = (String) jObj.get("department");

			if (deptFromJson.equalsIgnoreCase(deanship.getDepartement())) {
				Employee employee = new Employee();
				employees.add(Utility.parseJson(jObj, employee));
			}
		}

		String id = (String) request.getSession().getAttribute("collegeID");
		List<College> colleges = collegeRepo.findAll();
		List<Department> deps = departmentRepo.findByCollegeID(Integer.valueOf(id));

		Deanship college = new Deanship();
		college.setCollege(id);

		model.addAttribute("college", college);
		model.addAttribute("departement", deanship);
		model.addAttribute("colleges", colleges);
		model.addAttribute("employees", employees);
		model.addAttribute("deps", deps);

		return "deanship";
	}
}
