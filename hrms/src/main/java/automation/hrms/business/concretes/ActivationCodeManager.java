package automation.hrms.business.concretes;

import java.security.SecureRandom;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automation.hrms.business.abstracts.ActivationCodeService;
import automation.hrms.core.entities.concrete.User;
import automation.hrms.core.utilities.results.ErrorResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.core.utilities.results.SuccessResult;
import automation.hrms.dataAccess.abstracts.ActivationCodeDao;
import automation.hrms.dataAccess.abstracts.CandidateDao;
import automation.hrms.dataAccess.abstracts.UserDao;
import automation.hrms.entities.concretes.ActivationCode;

@Service
public class ActivationCodeManager implements ActivationCodeService{

	private ActivationCodeDao activationCodeDao;
	private UserDao userDao;
	private CandidateDao candidateDao;
	
	@Autowired
	public ActivationCodeManager(ActivationCodeDao activationCodeDao, UserDao userDao, CandidateDao candidateDao) {
		super();
		this.activationCodeDao = activationCodeDao;
		this.userDao = userDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public ActivationCode getByActivationCode(String activationCode) {
		return this.activationCodeDao.getByActivationCode(activationCode);
	}

	String generatedCode="";
	@Override
	public String createActivationCode(User user) {
		
		for(int i=0;i==0;i=0){
            generatedCode = codeGenerator(16);

            if(getByActivationCode(generatedCode) == null){
                break;
            }
        }
		
		ActivationCode activationCode = new ActivationCode();
		activationCode.setUser(user);
		activationCode.setActivationCode(generatedCode);
		
		activationCodeDao.save(activationCode);
		return generatedCode;
	}

	@Override
	public Result activateUser(String code) {
		if(activationCodeDao.getByActivationCode(code) == null) {
			return new ErrorResult("Hatalı kod");
		}
		
		User user = userDao.getOne(activationCodeDao.getByActivationCode(code).getUser().getId());
		user.setConfirmMail(true);
		userDao.save(user);
		
		ActivationCode activationCode = activationCodeDao.getByActivationCode(code);
		activationCode.setConfirm(true);
		activationCode.setConfirmDate(LocalDate.now());
		activationCodeDao.save(activationCode);
		
		return new SuccessResult("Kullanıcı aktifleşti.");
	}

	private final String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private SecureRandom salter = new SecureRandom();
	private String codeGenerator(int length){
        StringBuilder generator = new StringBuilder(length);
        for(int i=0;i<length;i++){
            generator.append(characters.charAt(salter.nextInt(characters.length())));
        }
        return generator.toString();
    }
}
