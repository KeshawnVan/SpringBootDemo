package com.demo.demo.repository;

import com.demo.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    List<User> findByNameAndAge(String name, Integer age);
}
