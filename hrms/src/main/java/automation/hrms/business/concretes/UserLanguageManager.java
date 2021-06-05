package automation.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automation.hrms.business.abstracts.UserLanguageService;
import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.core.utilities.results.SuccessDataResult;
import automation.hrms.core.utilities.results.SuccessResult;
import automation.hrms.dataAccess.abstracts.UserLanguageDao;
import automation.hrms.entities.concretes.UserLanguage;

@Service
public class UserLanguageManager implements UserLanguageService{

	private UserLanguageDao userLanguage;

	@Autowired
	public UserLanguageManager(UserLanguageDao userLanguage) {
		super();
		this.userLanguage = userLanguage;
	}

	@Override
	public DataResult<List<UserLanguage>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<UserLanguage>>(this.userLanguage.getByCandidateId(candidateId));
				
	}

	@Override
	public DataResult<List<UserLanguage>> getAll() {
		return new SuccessDataResult<List<UserLanguage>>(this.userLanguage.findAll());
	}

	@Override
	public Result add(UserLanguage userLanguage) {
		this.userLanguage.save(userLanguage);
		return new SuccessResult();
	}

	@Override
	public Result delete(UserLanguage userLanguage) {
		this.userLanguage.delete(userLanguage);
		return new SuccessResult();
	}

	@Override
	public Result update(UserLanguage userLanguage) {
		this.userLanguage.save(userLanguage);
		return new SuccessResult();
	}
}
