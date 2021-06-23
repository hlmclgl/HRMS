package automation.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import automation.hrms.business.abstracts.ActivationByStaffService;
import automation.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/activationbystaff")
@CrossOrigin
public class ActivationByStaffController {

	private ActivationByStaffService activationByStaffService;

	@Autowired
	public ActivationByStaffController(ActivationByStaffService activationByStaffService) {
		super();
		this.activationByStaffService = activationByStaffService;
	};
	
	@GetMapping("/activatemployer")
    public ResponseEntity<?> activateEmployer(@RequestParam int employerId,@RequestParam int staffId){
        Result result=this.activationByStaffService.activateEmployer(employerId, staffId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
