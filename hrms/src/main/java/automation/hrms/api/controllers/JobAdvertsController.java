package automation.hrms.api.controllers;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import automation.hrms.business.abstracts.JobAdvertService;
import automation.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertsController {

	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.jobAdvertService.getAll());
	}
	
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody JobAdvert jobAdvert){
        return ResponseEntity.ok(this.jobAdvertService.add(jobAdvert)) ;
    }
    
    @GetMapping("/getbyactive")
    public ResponseEntity<?> getByIsActive() {
        return ResponseEntity.ok(this.jobAdvertService.getByIsActive()) ;
    }
    
    @GetMapping("/getbyapplicationdeadline")
    public ResponseEntity<?> getByApplicationDeadline(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(this.jobAdvertService.getByApplicationDeadlineLessThanEqual(date));
    }
    
    @GetMapping("/getbyactiveandapplicationdeadline")
    public ResponseEntity<?> getByIsActiveAndApplicationDeadlineLessThanEqual(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(this.jobAdvertService.getByIsActiveAndApplicationDeadlineLessThanEqual(date));
    }
    
    @GetMapping("/getbyactiveandcompanyname")
    public ResponseEntity<?> getByIsActiveAndEmployerCompanyName(@RequestParam String companyName) {
        return ResponseEntity.ok(this.jobAdvertService.getByIsActiveAndEmployer_CompanyName(companyName));
    }
    
    @GetMapping("/getbyemployer")
    public ResponseEntity<?> getByEmployer(@RequestParam int id) {
        return ResponseEntity.ok(this.jobAdvertService.getByEmployerId(id));
    }
    
    @GetMapping("/changestatus")
    public ResponseEntity<?> changeStatus(@RequestParam int employerId,@RequestParam int announcementId,@RequestParam boolean status) {
        return ResponseEntity.ok(this.jobAdvertService.changeStatus(employerId,announcementId,status));
    }
}
