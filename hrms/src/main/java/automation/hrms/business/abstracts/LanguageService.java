package automation.hrms.business.abstracts;

import java.util.List;

import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.entities.concretes.Language;

public interface LanguageService {
	Result add(Language language);
    DataResult<List<Language>> getAll();
}
