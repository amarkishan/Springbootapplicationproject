package com.jpa.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.demo.entity.Comments;
import com.jpa.demo.entity.Projectinfo;

@Repository
public interface CommentRepository extends JpaRepository<Comments,Integer> 
{
	

}
