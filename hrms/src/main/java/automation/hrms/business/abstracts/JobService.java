package automation.hrms.business.abstracts;

import java.util.List;

import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.entities.concretes.Job;

public interface JobService {

	Result add(Job job);
	Result delete(Job job);
	Result update(Job job);
	DataResult<Job> getById(int id);
	DataResult<Job> getByPosition(String position);
	DataResult<List<Job>> getAll();
}
