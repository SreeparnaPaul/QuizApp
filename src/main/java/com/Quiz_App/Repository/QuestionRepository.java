package com.Quiz_App.Repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Quiz_App.entites.Questions;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Integer> {

}
