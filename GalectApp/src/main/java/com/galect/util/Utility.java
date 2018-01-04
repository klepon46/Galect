package com.galect.util;

import org.json.simple.JSONObject;

import com.galectapp.model.Employee;

public class Utility {
	public static Employee parseJson(JSONObject jo, Employee employee){
		
		employee.setEmployeeName((String) jo.get("employee_name"));
		employee.setStaffID((String) jo.get("staff_id"));
		employee.setDepartment((String) jo.get("department"));
		employee.setEmailAdress((String) jo.get("email_address"));
		employee.setJobTitle((String) jo.get("job_title"));
		employee.setRank((String) jo.get("rank"));
		employee.setJoiningDate((String) jo.get("joining_date"));
		employee.setEmpUserName((String) jo.get("emp_user_name"));
		
		return employee;
	}

}
