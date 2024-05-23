package com.jpa.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jpa.demo.controller.Projectcontroller;
import com.jpa.demo.entity.Projectinfo;
import com.jpa.demo.entity.Taskinfo;
import com.jpa.demo.repository.ProjectinfoRepository;
import com.jpa.demo.repository.TaskinfoRepository;

@SpringBootTest
class Projectinfotests
{
	
	@InjectMocks
	Projectcontroller projectcontrollermock;
	@Mock
	private ProjectinfoRepository projectinfoRepositorymock;

  
//    @Mock
//    private TaskinfoRepository taskinfoRepositorymock;
	
    
    //save project
	@Test
	public void saveproject_test() 
    	{
            
            Projectinfo projectinfo = new Projectinfo();
            Taskinfo task1 = new Taskinfo();
            Taskinfo task2 = new Taskinfo();
            List<Taskinfo> tasklist = Arrays.asList(task1, task2);
            projectinfo.setTaskinfolist(tasklist);
            when(projectinfoRepositorymock.save(projectinfo)).thenReturn(projectinfo);
            ResponseEntity<String> response = projectcontrollermock.saveproject(projectinfo);

            
            assertEquals("Project details are saved", response.getBody());
            //assertEquals(200, response.getStatusCodeValue());
            for (Taskinfo task : tasklist) 
            {
                assertEquals(projectinfo, task.getProjectinfo());
            }
            verify(projectinfoRepositorymock, times(1)).save(projectinfo);
        }
	
	
	//project found
	@Test
	public void getProjectById_projectFound() 
	{
	    // Arrange
	    int projectId = 1;
	    Projectinfo projectinfo = new Projectinfo();
	    when( projectinfoRepositorymock.findById(projectId)).thenReturn(Optional.of(projectinfo));
	    ResponseEntity<Projectinfo> response = projectcontrollermock.getProjectById(projectId);
	    
	    assertTrue(response.hasBody());
	    assertEquals(projectinfo, response.getBody());
	    assertEquals(HttpStatus.OK, response.getStatusCode());
	    
	    verify(projectinfoRepositorymock, times(1)).findById(projectId);
	}

	//project not found
	@Test
	public void getProjectById_projectNotFound() 
	{
	    
	    int projectId = 1;
	    
	    when(projectinfoRepositorymock.findById(projectId)).thenReturn(Optional.empty());
	    ResponseEntity<Projectinfo> response = projectcontrollermock.getProjectById(projectId);
	   
	    assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
	    assertFalse(response.hasBody());
	    //assertEquals(projectinfo, response.getBody());
	    
	    verify(projectinfoRepositorymock, times(1)).findById(projectId);
	}
}	

    	
    
    
    
    

