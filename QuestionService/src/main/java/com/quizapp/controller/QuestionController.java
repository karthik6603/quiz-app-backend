package com.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quizapp.model.Question;
import com.quizapp.model.QuestionWrapper;
import com.quizapp.model.Response;
import com.quizapp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;

	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestion() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
		return questionService.getQuestionsByCategory(category);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<String> updateQuestion(@PathVariable int id, @RequestBody Question question) {
		return questionService.updateQuestion(question);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable int id) {
		return questionService.deleteQuestion(id);
	}
	
	@GetMapping("generate")
	public ResponseEntity<List<Integer>> getQuestions(@RequestParam String categoryName, @RequestParam int numQuestions) {
		return questionService.getAllQuestionsForQuiz(categoryName, numQuestions);
	}
	
	@PostMapping("getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
		return questionService.getQuestionsFromId(questionIds);
	}
	
	@PostMapping("getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
		return questionService.getScore(responses);
	}
	
}
