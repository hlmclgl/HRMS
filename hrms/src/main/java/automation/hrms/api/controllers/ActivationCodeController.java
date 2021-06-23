package automation.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import automation.hrms.business.abstracts.ActivationCodeService;
import automation.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/activationcode")
@CrossOrigin
public class ActivationCodeController {

	private ActivationCodeService activationCodeService;

	@Autowired
	public ActivationCodeController(ActivationCodeService activationCodeService) {
		super();
		this.activationCodeService = activationCodeService;
	};
	
	@GetMapping("/active/{code}")
    public ResponseEntity<?> activateUser(@PathVariable String code){
        Result result=this.activationCodeService.activateUser(code);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
