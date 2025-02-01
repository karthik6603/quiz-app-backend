package com.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quizapp.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

	List<Question>findByCategory(String category);

	@Query(value = "SELECT id FROM question WHERE category = ?1 ORDER BY RAND() LIMIT 5", nativeQuery = true)
	List<Integer> findRandomQuestionByCategory(String category, int numQ);


	
}
