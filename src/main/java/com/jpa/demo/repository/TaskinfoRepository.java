package com.jpa.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.demo.entity.Projectinfo;
import com.jpa.demo.entity.Taskinfo;
@Repository
public interface TaskinfoRepository extends JpaRepository<Taskinfo,Integer> 
{

	

	

	
}
