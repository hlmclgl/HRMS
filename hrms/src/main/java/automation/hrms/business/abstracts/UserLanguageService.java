package automation.hrms.business.abstracts;

import java.util.List;

import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.entities.concretes.UserLanguage;

public interface UserLanguageService {
	DataResult<List<UserLanguage>> getByCandidateId(int candidateId);
	DataResult<List<UserLanguage>> getAll();
	Result add(UserLanguage userLanguage);
	Result delete(UserLanguage userLanguage);
	Result update(UserLanguage userLanguage);
}
