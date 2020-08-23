package com.paremal.sheebu.springboot.restcontroller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.paremal.sheebu.springboot.entity.User;
import com.paremal.sheebu.springboot.model.Question;
import com.paremal.sheebu.springboot.repository.UserRepository;
import com.paremal.sheebu.springboot.service.SurveyService;

@RestController
public class SurveyController {
	
	@Autowired
	private SurveyService surveyService;
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/surveys/{surveyId}/questions")
	public List<Question> retrieveQuestions(@PathVariable String surveyId){
		
		return surveyService.retrieveQuestions(surveyId);
	}
	
	@GetMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question retrieveQuestion(@PathVariable String surveyId,
										@PathVariable String questionId) {
		
		return surveyService.retrieveQuestion(surveyId, questionId);
		
	}
	
	@PostMapping("/surveys/{surveyId}/questions")
	public ResponseEntity<?> addQuestion(@PathVariable String surveyId,
										@RequestBody Question newQuestion){
		Question createdTodo = surveyService.addQuestion(surveyId, newQuestion);

        if (createdTodo == null) {
            return ResponseEntity.noContent().build();
        }
        
       

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(location).build();

	}

}
