package com.jpa.demo.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api")
public class Projectcontroller 
{

    @Autowired
    private ProjectinfoRepository projectinfoRepository;

  
//    @Autowired
//    private TaskinfoRepository taskinfoRepository;
   
    
  
    //good
    @PostMapping("/project")
    public  ResponseEntity<String> saveproject(@RequestBody Projectinfo projectinfo ) 
    {
        
            List <Taskinfo> tasklist =projectinfo.getTaskinfolist();  
            
            for(Taskinfo t:tasklist)
            {
            	t.setProjectinfo(projectinfo);
            }
            
           
    	    projectinfoRepository.save(projectinfo);
    	    return ResponseEntity.ok("Project details are saved");
      }
   
    //good
    @GetMapping("/project/{projectid}")
    public ResponseEntity<Projectinfo> getProjectById(@PathVariable int projectid) 
    {
        Optional<Projectinfo> projectOptional = projectinfoRepository.findById(projectid);
        
        if (projectOptional.isPresent()) {
            Projectinfo project = projectOptional.get();
            return ResponseEntity.ok(project);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
   

    
    
    @GetMapping("/projects")
    public  List<Projectinfo> getprojects()
    {
    	return  projectinfoRepository.findAll();
    }	
 
}
    	 
    
    
  
    
    

  

