package com.gtmsoftware.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtmsoftware.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
