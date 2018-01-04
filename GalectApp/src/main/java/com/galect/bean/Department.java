package com.galect.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Department")
public class Department {
	
	@Id
	@Column(name="department_ID")
	private Integer departmentID;
	
	@Column(name="department_Name")
	private String departmentName;
	
	@Column(name="college_ID")
	private Integer collegeID;

	public Integer getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(Integer departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getCollegeID() {
		return collegeID;
	}

	public void setCollegeID(Integer collegeID) {
		this.collegeID = collegeID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((collegeID == null) ? 0 : collegeID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (collegeID == null) {
			if (other.collegeID != null)
				return false;
		} else if (!collegeID.equals(other.collegeID))
			return false;
		return true;
	}
	

}
