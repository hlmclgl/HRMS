package automation.hrms.business.abstracts;

import java.util.List;

import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.entities.concretes.WorkExperience;

public interface WorkExperienceService {
	DataResult<List<WorkExperience>> getAll();
	DataResult<List<WorkExperience>> getByCandidateIdOrderByFinishDate(int candidateId);
	Result add(WorkExperience workExperience);
}
