package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.View;
import com.nhnacademy.springjpa.idClass.ViewId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewRepository extends JpaRepository<View, ViewId> {
}
