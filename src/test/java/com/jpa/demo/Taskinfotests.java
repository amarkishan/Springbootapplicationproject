package com.jpa.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jpa.demo.controller.Projectcontroller;
import com.jpa.demo.controller.Taskcontroller;
import com.jpa.demo.entity.Projectinfo;
import com.jpa.demo.entity.Taskinfo;
import com.jpa.demo.repository.ProjectinfoRepository;
import com.jpa.demo.repository.TaskinfoRepository;


public class Taskinfotests 
{
	
	@InjectMocks
	Taskcontroller taskcontrollermock;
	
	@Mock
	private ProjectinfoRepository projectinfoRepositorymock;

  
    @Mock
    private TaskinfoRepository taskinfoRepositorymock;
    
    
	
	
	@Test
	
	public void createtask_test()
	{
		
		
		Projectinfo projectinfo = new Projectinfo();
       

        Taskinfo taskinfo = new Taskinfo();
       
        taskinfo.setProjectinfo(projectinfo);

        when(projectinfoRepositorymock.save(projectinfo)).thenReturn(projectinfo);
        when(taskinfoRepositorymock.save(taskinfo)).thenReturn(taskinfo);

        
        Taskinfo result = taskcontrollermock.createTask(taskinfo);

        
        assertNotNull(result);
       
        //assertEquals("Test Project", result.getProjectinfo().getName());

        verify(projectinfoRepositorymock, times(1)).save(projectinfo);
        verify(taskinfoRepositorymock, times(1)).save(taskinfo);
    
		
	}
	
	@Test
    public void gettask_taskFound() 
	{
        
        int taskId = 1;
        Projectinfo projectinfo = new Projectinfo();
        Taskinfo taskinfo = new Taskinfo();
       

        when(taskinfoRepositorymock.findById(taskId)).thenReturn(Optional.of(taskinfo));

        
        ResponseEntity<Projectinfo> response = taskcontrollermock.gettask(taskId);

        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.hasBody());
        assertEquals(projectinfo, response.getBody());

        verify(taskinfoRepositorymock, times(1)).findById(taskId);
    }

    @Test
    public void gettask_taskNotFound() {
        
        int taskId = 1;

        when(taskinfoRepositorymock.findById(taskId)).thenReturn(Optional.empty());

       
        ResponseEntity<Projectinfo> response = taskcontrollermock.gettask(taskId);

       
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertFalse(response.hasBody());

        verify(taskinfoRepositorymock, times(1)).findById(taskId);
    }

	 
}
