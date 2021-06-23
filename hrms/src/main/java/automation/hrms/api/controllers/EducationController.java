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

import automation.hrms.business.abstracts.EducationService;
import automation.hrms.entities.concretes.Education;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationController {

	private EducationService educationService;

	@Autowired
	public EducationController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.educationService.getAll());
	}
	
	@GetMapping("/getbyid")
	public ResponseEntity<?> getByCandidateIdOrderByGraduationYear(@RequestParam int candidateId){
		return ResponseEntity.ok(this.educationService.getByCandidateIdOrderByGraduationYear(candidateId));
	}
	
    @PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Education education){
		return ResponseEntity.ok(this.educationService.add(education));
	}
    
    @PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody Education education){
		return ResponseEntity.ok(this.educationService.delete(education));
	}
    
    @PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody Education education){
		return ResponseEntity.ok(this.educationService.update(education));
	}
}
