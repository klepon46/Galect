package com.galectapp.GalectApp.Controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.galect.util.JsonParser;
import com.galect.util.Utility;
import com.galectapp.model.Employee;

@Controller
@RequestMapping("/galect")
public class ChairmanController {

	@RequestMapping("/chairman")
	public String chairman(@RequestParam("deptName") String deptName, Model model) {

		JsonParser jp = new JsonParser();
		JSONArray jArray = jp.getJsonArray("json/test.json");

		List<Employee> employees = new ArrayList<>();
		for (int i = 0; i < jArray.size(); i++) {

			JSONObject jObj = (JSONObject) jArray.get(i);

			String deptFromJson = (String) jObj.get("department");

			if (deptFromJson.equalsIgnoreCase(deptName)) {
				Employee employee = new Employee();
				employees.add(Utility.parseJson(jObj, employee));
			}
		}

		model.addAttribute("employees", employees);

		return "chairman";
	}

}
