package com.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizapp.dao.QuestionDao;
import com.quizapp.model.Question;
import com.quizapp.model.QuestionWrapper;
import com.quizapp.model.Response;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.FOUND);
	}

	public ResponseEntity<String> addQuestion(Question question) {
		questionDao.save(question);
		return new ResponseEntity<>("Successfully added", HttpStatus.CREATED);
	}

	public ResponseEntity<String> updateQuestion(Question question) {
		Question existingQuestion = questionDao.getById(question.getId());

	    if (existingQuestion != null) {
	    	existingQuestion.setQuestionTitle(question.getQuestionTitle());
	    	existingQuestion.setOption1(question.getOption1());
	    	existingQuestion.setOption2(question.getOption2());
	    	existingQuestion.setOption3(question.getOption3());
	    	existingQuestion.setOption4(question.getOption4());
	    	existingQuestion.setRightAnswer(question.getRightAnswer());
	    	existingQuestion.setDifficultyLevel(question.getDifficultyLevel());

	        questionDao.save(existingQuestion);
	        return new ResponseEntity<>("Successfully updated the question", HttpStatus.ACCEPTED);
	    } else {
	        return new ResponseEntity<>("Question with ID " + question.getId() + " not found!", HttpStatus.ACCEPTED);
	    }
	}

	public ResponseEntity<String> deleteQuestion(int id) {
		Question q = questionDao.getById(id);
		questionDao.delete(q);
		return new ResponseEntity<>("Deletion Success", HttpStatus.ACCEPTED);
	}

	public ResponseEntity<List<Integer>> getAllQuestionsForQuiz(String categoryName, int numQuestions) {
		List<Integer> questions =  questionDao.findRandomQuestionByCategory(categoryName, numQuestions);
		
		
		return new ResponseEntity<>(questions, HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
		List<QuestionWrapper> wrappers = new ArrayList<>();
		List<Question> questions = new ArrayList<>();
		
		for(Integer id : questionIds) {
			questions.add(questionDao.findById(id).get());
		}
		
		for(Question q : questions) {
			QuestionWrapper wrapper = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			wrappers.add(wrapper);
		}
		
		return new ResponseEntity<>(wrappers, HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<Response> responses) {

		int right = 0;
		for(Response response : responses) {
			Question question = questionDao.findById(response.getId()).get();
			if(response.getResponse().equals(question.getRightAnswer()))
					right++;
		}
		
		return new ResponseEntity<>(right, HttpStatus.OK);
	}

}
