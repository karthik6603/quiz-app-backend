package com.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizapp.dao.QuizDao;
import com.quizapp.feign.QuizInterface;
import com.quizapp.model.QuestionWrapper;
import com.quizapp.model.Quiz;
import com.quizapp.model.Response;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;

	@Autowired
	QuizInterface quizInterface;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		List<Integer> questions =  quizInterface.getQuestions(category, numQ).getBody();
//		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionIds(questions);
		quizDao.save(quiz);
		
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
		
	}

	public ResponseEntity<List<QuestionWrapper>> getQUizQuestions(int id) {
		Quiz quiz = quizDao.findById(id).get();
		List<Integer> questionIds = quiz.getQuestionIds();
		
		ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);
		
		return questions;
	}

	public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {

		ResponseEntity<Integer> score = quizInterface.getScore(responses);
		
		return score;
	}
	
	
	
}
