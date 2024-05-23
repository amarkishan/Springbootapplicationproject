package com.jpa.demo.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="taskinfo")
public class Taskinfo implements Serializable 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Task_ID;
    
    private String Task_Name;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    @JsonBackReference
    private Projectinfo projectinfo;
    
    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "taskinfo", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comments> comments;
    
    
    
    private String Description;
    private String UniqueKey;
    private Date Created;
    private Date Modified;
    private String CreatedBy;
    private String ModifiedBy;
    private int Priority;
    private String Status;
    private String EstimatedTime;
    private String ActualTime;

    // Getters and setters

    public int getTask_ID() {
        return Task_ID;
    }

    public void setTask_ID(int task_ID) {
        Task_ID = task_ID;
    }

    public String getTask_Name() {
        return Task_Name;
    }

    public void setTask_Name(String task_Name) {
        Task_Name = task_Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUniqueKey() {
        return UniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        UniqueKey = uniqueKey;
    }

    public Date getCreated() {
        return Created;
    }

    public void setCreated(Date created) {
        Created = created;
    }

    public Date getModified() {
        return Modified;
    }

    public void setModified(Date modified) {
        Modified = modified;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getModifiedBy() {
        return ModifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        ModifiedBy = modifiedBy;
    }

    public int getPriority() {
        return Priority;
    }

    public void setPriority(int priority) {
        Priority = priority;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getEstimatedTime() {
        return EstimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        EstimatedTime = estimatedTime;
    }

    public String getActualTime() {
        return ActualTime;
    }

    public void setActualTime(String actualTime) {
        ActualTime = actualTime;
    }

    public Projectinfo getProjectinfo() {
        return projectinfo;
    }

    public void setProjectinfo(Projectinfo projectinfo) {
        this.projectinfo = projectinfo;
    }

   public List<Comments> getComments() {
        return comments;
    }

   public void setComments(List<Comments> comments) {
       this.comments = comments;
   }



  

  

   
}
