package com.galect.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="College")
public class College {
	
	@Id
	@Column(name="college_ID")
	private Integer collegeID;
	
	@Column(name="collage_Name")
	private String collageName;

	public Integer getCollegeID() {
		return collegeID;
	}

	public void setCollegeID(Integer collegeID) {
		this.collegeID = collegeID;
	}
	public String getCollageName() {
		return collageName;
	}

	public void setCollageName(String collageName) {
		this.collageName = collageName;
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
		College other = (College) obj;
		if (collegeID == null) {
			if (other.collegeID != null)
				return false;
		} else if (!collegeID.equals(other.collegeID))
			return false;
		return true;
	}

}
