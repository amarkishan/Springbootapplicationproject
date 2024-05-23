package com.jpa.demo.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="projectinfo")
public class Projectinfo implements  Serializable
{
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private int Project_ID;
	
	 private String Project_Name;
	  
	 private String Description;
	  
	 private final Date Created = new Date(System.currentTimeMillis());
	  
	 private Date Modified;
	 
	 
	 
	 
	 @OneToMany(fetch = FetchType.LAZY ,mappedBy="projectinfo",cascade = CascadeType.ALL)
	 @JsonManagedReference
	 private List<Taskinfo> taskinfolist;
	 
	 
	public List<Taskinfo> getTaskinfolist() 
	{
		return taskinfolist;
	}

	public void setTaskinfolist(List<Taskinfo> taskinfolist) {
		this.taskinfolist = taskinfolist;
	}

	public long getProject_ID() {
		return Project_ID;
	}

	public void setProject_ID(int project_ID) {
		Project_ID = project_ID;
	}

	public String getProject_Name() {
		return Project_Name;
	}

	public void setProject_Name(String project_Name) {
		Project_Name = project_Name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	


	public Date getModified() {
		return Modified;
	}

	public void setModified(Date date) {
		Modified = date;
	}
	 
	 
	  
	  
	  

	  

}
