package com.galectapp.GalectApp.Controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.galect.util.JsonParser;
import com.galect.util.Utility;
import com.galectapp.model.Employee;

@Controller
@RequestMapping("/galect")
public class StudentController {

	@RequestMapping("/student/{id}")
	public String student(@PathVariable("id") String id, Model model) {

		JsonParser jp = new JsonParser();
		JSONArray jArray = jp.getJsonArray("json/test.json");

		List<Employee> employees = new ArrayList<>();
		for (int i = 0; i < jArray.size(); i++) {

			JSONObject jObj = (JSONObject) jArray.get(i);

			String staffIdFromJson = (String) jObj.get("staff_id");

			if (staffIdFromJson.equalsIgnoreCase(id)) {
				Employee employee = new Employee();
				employees.add(Utility.parseJson(jObj, employee));
			}
		}

		model.addAttribute("employees", employees);

		return "student";
	}

}
