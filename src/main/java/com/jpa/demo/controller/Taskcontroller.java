package com.jpa.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.demo.entity.Projectinfo;
import com.jpa.demo.entity.Taskinfo;
import com.jpa.demo.repository.ProjectinfoRepository;
import com.jpa.demo.repository.TaskinfoRepository;
@RestController
@RequestMapping("/api/tasks")
public class Taskcontroller 

{

      @Autowired
      private ProjectinfoRepository projectinfoRepository;
	  
      @Autowired
	    private TaskinfoRepository taskinfoRepository;
      
	 
      @PostMapping("/tasks")
      public  Taskinfo createTask(@RequestBody Taskinfo task) 
      {
    	  Projectinfo projectinfo =task.getProjectinfo();
    	  
    	  projectinfoRepository.save(projectinfo);
    	  
    	  return taskinfoRepository.save(task);
    	  
      }
      
      

	        
	    
	    @GetMapping("/task/{taskid}")
	    
	    public    ResponseEntity<Projectinfo> gettask(@PathVariable int taskid)
	    {
	    	Optional<Taskinfo> t = taskinfoRepository.findById(taskid);
	    	
	    	
	    	
	    	if (t.isPresent()) 
	    	{
	    	     Taskinfo task1 = t.get();
	    	 return ResponseEntity.ok(task1.getProjectinfo());
	    	 } else 
	    	 {
	    	            return ResponseEntity.notFound().build();
	    	  }
	    	  
	    }
	    
	    
}



