package com.galect.util;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.galectapp.model.Employee;

public class JsonParser {

	private Employee employee;
	private JSONObject jo;

	public void getJsonFromLocal(String localPath) {
		JSONParser parser = new JSONParser();
		String hardCodedUser = "john";

		try {
			Object obj = parser.parse(new FileReader(localPath));
			JSONObject jObject = (JSONObject) obj;

			JSONArray jArray = (JSONArray) jObject.get("data");

			JSONObject jsonObject = null;
			for (int i = 0; i < jArray.size(); i++) {
				jsonObject = (JSONObject) jArray.get(i);
				String name = (String) jsonObject.get("employee_name");

				if (name.equalsIgnoreCase(hardCodedUser)) {
					break;
				}
			}

			jo = jsonObject;

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

	}

	public JSONArray getJsonArray(String localPath) {

		JSONParser parser = new JSONParser();
		JSONArray jArray = null;

		try {
			Object obj = parser.parse(new FileReader(localPath));
			JSONObject jObject = (JSONObject) obj;

			jArray = (JSONArray) jObject.get("data");

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		return jArray;
	}

	public void getJsonFromUrl(String url) {

	}

	public Employee parseJsonToModel() {
		employee = new Employee();
		employee.setEmployeeName((String) jo.get("employee_name"));
		employee.setStaffID((String) jo.get("123456"));
		employee.setDepartment((String) jo.get("department"));
		employee.setEmailAdress((String) jo.get("email_address"));
		employee.setJobTitle((String) jo.get("job_title"));
		employee.setRank((String) jo.get("rank"));
		employee.setJoiningDate((String) jo.get("joining_date"));
		employee.setEmpUserName((String) jo.get("emp_user_name"));
		return employee;
	}

}
