package automation.hrms.business.abstracts;

import automation.hrms.core.utilities.results.Result;
import automation.hrms.entities.dtos.CandidateForRegisterDto;
import automation.hrms.entities.dtos.EmployerForRegisterDto;
import automation.hrms.entities.dtos.UserForLoginDto;

public interface AuthService {

	Result login(UserForLoginDto userForLoginDto);
	Result employerRegister(EmployerForRegisterDto employerForRegisterDto);
	Result candidateRegister(CandidateForRegisterDto candidateForRegisterDto);
	
}
