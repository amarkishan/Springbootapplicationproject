package com.jpa.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import com.jpa.demo.controller.Commentcontroller;

import com.jpa.demo.entity.Comments;
import com.jpa.demo.entity.Taskinfo;
import com.jpa.demo.repository.CommentRepository;


public class Commenttest 
{

	
	
	@InjectMocks
	Commentcontroller commnetcontrollermock; 
    
	@Mock
	
	private CommentRepository commentrepository;
    
	@Test
    public void testReadcommentsfortaskCommentNotFound() 
	{
        // Given
        int commentid = 1;
        
        when(commentrepository.findById(commentid)).thenReturn(Optional.empty());

        // When / Then
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
        	commnetcontrollermock.readcommentsfortask(commentid);
        });
        
        assertEquals("comment not foound", exception.getMessage());
        verify(commentrepository, times(1)).findById(commentid);
    }
	 
	@Test
    public void testReadcommentsfortaskCommentFound() {
        // Given
        int commentid = 1;
        Comments comment = new Comments();
        Taskinfo taskinfo = new Taskinfo();
        comment.setTaskinfo(taskinfo);
        
        when(commentrepository.findById(commentid)).thenReturn(Optional.of(comment));
        Taskinfo result = commnetcontrollermock.readcommentsfortask(commentid);
        assertNotNull(result);
        assertEquals(taskinfo, result);
        verify(commentrepository, times(1)).findById(commentid);
    }
}
