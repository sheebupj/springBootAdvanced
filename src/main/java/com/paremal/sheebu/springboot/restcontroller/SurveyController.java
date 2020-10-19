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

import com.paremal.sheebu.springboot.repository.oracle.AddressRepository;
import com.paremal.sheebu.springboot.repository.oracle.UserRepository;
import com.paremal.sheebu.springboot.repository.oracle.UserRepository2;
import com.paremal.sheebu.springboot.entity.oracle.Address;
import com.paremal.sheebu.springboot.entity.oracle.User;
import com.paremal.sheebu.springboot.entity.oracle.User2;
import com.paremal.sheebu.springboot.model.Question;
import com.paremal.sheebu.springboot.service.SurveyService;

@RestController
public class SurveyController {
	
	@Autowired
	private SurveyService surveyService;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserRepository2 userRepo2;
	
	@Autowired
	private AddressRepository addressRepo;
	
	@GetMapping("/surveys/{surveyId}/questions")
	public List<Question> retrieveQuestions(@PathVariable String surveyId){
		inserUser("Sheebu");
		inserAddress("pappanoor");
		return surveyService.retrieveQuestions(surveyId);
	}
	
	@GetMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question retrieveQuestion(@PathVariable String surveyId,
										@PathVariable String questionId) {
		inserUser("Merin");
		inserAddress("Meenangadi");
		
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
	
	
	void inserUser(String name) {
		User2 user2= new User2();
		user2.setName(name);
		user2.setRole("Admin");
		userRepo2.save(user2);
	}
	void inserAddress(String name) {
		Address adr= new Address();
		adr.setHousename(name);
		adr.setPlace(name);
		adr.setPostoffice(name);
		addressRepo.save(adr);
	}

}
