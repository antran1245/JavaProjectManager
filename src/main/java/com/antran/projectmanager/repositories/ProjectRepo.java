package com.antran.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.antran.projectmanager.models.Project;
import com.antran.projectmanager.models.User;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Long> {

//	all projects
	List<Project> findAll();
	
//	all projects by one users
//	List<Project> findByUser(User user);
	
//	all projects not by one users
//	List<Project> findByUserNot(User user);
}
