package com.springboot.demo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.demo.jpa.entity.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
