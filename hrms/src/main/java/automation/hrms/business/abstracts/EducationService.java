package automation.hrms.business.abstracts;

import java.util.List;

import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.entities.concretes.Education;

public interface EducationService {
	DataResult<List<Education>> getByCandidateIdOrderByGraduationYear(int candidateId);
	DataResult<List<Education>> getAll();
	Result add(Education education); 
	Result delete(Education education);
	Result update(Education education);
}
