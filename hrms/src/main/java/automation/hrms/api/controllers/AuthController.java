package automation.hrms.api.controllers;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import automation.hrms.business.abstracts.AuthService;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.entities.dtos.CandidateForRegisterDto;
import automation.hrms.entities.dtos.EmployerForRegisterDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/employerregister")
    public Result registerForEmployer(@RequestBody EmployerForRegisterDto employerForRegisterDto) {
        return authService.employerRegister(employerForRegisterDto);
    }
	
	 @PostMapping("/candidateregister")
	    public Result registerForCandidate(@RequestBody CandidateForRegisterDto candidateForRegisterDto) throws RemoteException {
	        return authService.candidateRegister(candidateForRegisterDto);
	    }

}
