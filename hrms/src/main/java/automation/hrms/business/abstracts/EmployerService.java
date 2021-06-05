package automation.hrms.business.abstracts;

import java.util.List;

import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.entities.concretes.Employer;

public interface EmployerService {

	Result add(Employer employer);
	Result delete(Employer employer);
	Result update(Employer employer);
	DataResult<Employer> getById(int id);
	DataResult<Employer> getByMail(String email);
	DataResult<List<Employer>> getAll();
}
