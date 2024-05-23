package com.jpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.demo.entity.Projectinfo;


@Repository
public interface ProjectinfoRepository extends JpaRepository<Projectinfo,Integer>  
{

	
	

}

