package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeRepository extends JpaRepository<UserType,Integer> {
}
