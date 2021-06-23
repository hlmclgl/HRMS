package automation.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import automation.hrms.business.abstracts.UserLanguageService;
import automation.hrms.entities.concretes.UserLanguage;

@RestController
@RequestMapping("/api/userlanguages")
@CrossOrigin
public class UserLanguagesController {

	private UserLanguageService userLanguageService;

	@Autowired
	public UserLanguagesController(UserLanguageService userLanguageService) {
		super();
		this.userLanguageService = userLanguageService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.userLanguageService.getAll());
	}
	
	@GetMapping("/getbyid")
	public ResponseEntity<?> getByCandidateId(@RequestParam int candidateId){
		return ResponseEntity.ok(this.userLanguageService.getByCandidateId(candidateId));
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody UserLanguage userLanguage){
		return ResponseEntity.ok(this.userLanguageService.add(userLanguage));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody UserLanguage userLanguage){
		return ResponseEntity.ok(this.userLanguageService.delete(userLanguage));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody UserLanguage userLanguage){
		return ResponseEntity.ok(this.userLanguageService.update(userLanguage));
	}
}
