package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.dto.MyData;

@Repository
public interface DemoRepository extends JpaRepository<MyData, Long> {
  
}
