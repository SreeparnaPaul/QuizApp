package com.Quiz_App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Quiz_App.entites.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
