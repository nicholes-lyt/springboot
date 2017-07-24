package com.springboot.demo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.demo.jpa.entity.User;
@Repository
public interface  UserRepository extends JpaRepository<User, Integer>{
	
	@Query("select u from User u where u.username=?1 and u.password=?2")
    User login(String username, String password);
	
	User findUserByUsername(String username);
}
