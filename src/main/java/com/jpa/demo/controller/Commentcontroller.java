package com.jpa.demo.controller;

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
import com.jpa.demo.entity.Comments;
import com.jpa.demo.entity.Projectinfo;
import com.jpa.demo.entity.Taskinfo;
import com.jpa.demo.repository.CommentRepository;
import com.jpa.demo.repository.TaskinfoRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/comments")
public class Commentcontroller 
{

	 private static final Logger logger = LoggerFactory.getLogger(Commentcontroller.class);
	@Autowired
	private CommentRepository commentrepository;
	@Autowired
    private TaskinfoRepository taskinfoRepository;
	 
	 //this will return the comment associated with the taskid
	 @GetMapping("/task/{commentid}")
	 public    Taskinfo readcommentsfortask(@PathVariable int commentid)
	 {
		 
		   

	
            logger.info("Received request to get commnets for task with commentid:{}",commentid);
			Optional<Comments> commentoptional = commentrepository.findById(commentid);
			if(commentoptional.isPresent())
			{
				Comments c = commentoptional.get();
			    logger.debug("Found commnet:{}",c);
			    return c.getTaskinfo();
			    
			}
			
			else
			{
				logger.warn("comment with id {} not found",commentid);
				throw new RuntimeException("comment not foound");
				
			}

			
			
			
			
		 
        }

	
}
