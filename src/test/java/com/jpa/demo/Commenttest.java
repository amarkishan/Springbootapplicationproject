package com.jpa.demo;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.demo.controller.Commentcontroller;
import com.jpa.demo.controller.Taskcontroller;
import com.jpa.demo.repository.CommentRepository;
import com.jpa.demo.repository.TaskinfoRepository;

public class Commenttest 
{

	
	
	@InjectMocks
	Commentcontroller commnetcontrollermock; 
    @Mock
    private TaskinfoRepository taskinfoRepository;
    
    
	 
}
