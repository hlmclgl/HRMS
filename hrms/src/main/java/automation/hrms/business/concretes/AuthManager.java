package automation.hrms.business.concretes;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automation.hrms.business.abstracts.AuthService;
import automation.hrms.business.abstracts.CandidateService;
import automation.hrms.business.abstracts.EmployerService;
import automation.hrms.business.abstracts.MailService;
import automation.hrms.business.abstracts.UserService;
import automation.hrms.core.utilities.business.BusinessRules;
import automation.hrms.core.utilities.results.ErrorResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.core.utilities.results.SuccessResult;
import automation.hrms.entities.concretes.Candidate;
import automation.hrms.entities.concretes.Employer;
import automation.hrms.entities.dtos.CandidateForRegisterDto;
import automation.hrms.entities.dtos.EmployerForRegisterDto;
import automation.hrms.entities.dtos.UserForLoginDto;

@Service
public class AuthManager implements AuthService{

	private UserService userService;
	private CandidateService candidateService;
	private ModelMapper modelMapper;
	private MailService mailService;
	private EmployerService employerService;
	@Autowired
	public AuthManager(UserService userService, CandidateService candidateService, ModelMapper modelMapper,
			MailService mailService, EmployerService employerService) {
		super();
		this.userService = userService;
		this.candidateService = candidateService;
		this.modelMapper = modelMapper;
		this.mailService = mailService;
		this.employerService = employerService;
	}

	@Override
	public Result login(UserForLoginDto userForLoginDto) {
		var userToCheck = checkEmail(userForLoginDto.getEmail());
		if (userToCheck != null) {
			return new ErrorResult("The user not found.");
		}
		return new SuccessResult() ; 
	}

	@Override
	public Result employerRegister(EmployerForRegisterDto employer) {
		Result result = BusinessRules.run(
				checkEmailVerification(employer.getEmail()), checkEmail(employer.getEmail()), checkPassword(employer.getPassword(), employer.getRepassword()));
		
		if (result != null) {
			return result;
		}
		
		Employer newEmployer = modelMapper.map(employer, Employer.class);
		this.employerService.add(newEmployer);
		return new SuccessResult("Başarıyla kaydoldunuz.");
	}

	@Override
	public Result candidateRegister(CandidateForRegisterDto candidate) {
		Result result = BusinessRules.run(checkEmail(candidate.getEmail()), checkNationalityId(candidate.getNationalIdentity()),
				checkEmailVerification(candidate.getEmail()), checkPassword(candidate.getPassword(), candidate.getRepassword()));
		if(result != null) {
			return result;
		}
		
		Candidate newCandidate = modelMapper.map(candidate, Candidate.class);
		this.candidateService.add(newCandidate);
		return new SuccessResult("Başarıyla kaydoldunuz.");
	}

	private Result checkEmail(String email) {
		Result result = this.userService.findByMail(email);
		
		if (result.getMessage() != null) {
			return new ErrorResult("Bu e-mail ile kayıtlı bir kullanıcı zaten var.");
		}
		return new SuccessResult();
	}
	
	private Result checkEmailVerification(String email) {
		Result result = this.mailService.confirm(email);
		if(result == null) {
			return new ErrorResult("Kullanıcı kayıtlı.");
		}
		return new SuccessResult();
	}
	
	private Result checkPassword(String password, String rePassword) {
		if (!password.equals(rePassword)) {
			return new ErrorResult("İki şifre aynı değil.");
		}
		return new SuccessResult();
	}
	
	private Result checkNationalityId(String nationalityId) {
		Result result = this.candidateService.findByNationalityId(nationalityId);
		if (result.getMessage() != null) {
			return new ErrorResult("Kullanıcı zaten kayıtlı.");
		}
		return new SuccessResult() ;
	}
	
	private Result checkDomain(EmployerForRegisterDto employerForRegisterDto) {
		String domain = employerForRegisterDto.getEmail().split("@")[0];
        if(domain.equals(employerForRegisterDto.getWebAddress())){
        	return new SuccessResult();
        }
        System.out.println(employerForRegisterDto.getEmail().split("@")[0]);
        return new ErrorResult("Şirket maili ile domain aynı olmalıdır.");
	}
	
}
