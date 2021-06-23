package automation.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import automation.hrms.business.abstracts.WorkExperienceService;
import automation.hrms.entities.concretes.WorkExperience;

@RestController
@RequestMapping("/api/workexperiences")
@CrossOrigin
public class WorkExperiencesController {

	private WorkExperienceService workExperienceService;

	@Autowired
	public WorkExperiencesController(WorkExperienceService workExperienceService) {
		super();
		this.workExperienceService = workExperienceService;
	}
	
	@PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) WorkExperience workExperience){
        return ResponseEntity.ok(this.workExperienceService.add(workExperience));
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.workExperienceService.getAll());
    }

    @GetMapping("/getbyidorderbydesc")
    public ResponseEntity<?> getAllOrderByLeaveDate(@RequestParam int candidateId){
        return ResponseEntity.ok(this.workExperienceService.getByCandidateIdOrderByFinishDate(candidateId));
    }

	
}
