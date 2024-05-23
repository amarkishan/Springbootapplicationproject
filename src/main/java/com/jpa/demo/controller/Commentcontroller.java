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

@RestController
@RequestMapping("/api/comments")
public class Commentcontroller 
{

//	@Autowired
//	private CommentRepository commentrepository;
	@Autowired
    private TaskinfoRepository taskinfoRepository;
	 
	 //this will return the comment associated with the taskid
	 @GetMapping("/task/{taskid}")
	 public  List<Comments> readcommentsfortask(@PathVariable int taskid)
	 {
		 
		 Optional<Taskinfo> taskinfoOptional = taskinfoRepository.findById(taskid);
		 Taskinfo tf1 = taskinfoOptional.get();
		 List<Comments> c = tf1.getComments();
		 
		 return c;
		 
		 
		 
	 }
}
