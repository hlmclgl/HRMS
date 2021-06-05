package automation.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automation.hrms.business.abstracts.WorkExperienceService;
import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.core.utilities.results.SuccessDataResult;
import automation.hrms.core.utilities.results.SuccessResult;
import automation.hrms.dataAccess.abstracts.WorkExperienceDao;
import automation.hrms.entities.concretes.WorkExperience;

@Service
public class WorkExperienceManager implements WorkExperienceService{

	private WorkExperienceDao workExperience;

	@Autowired
	public WorkExperienceManager(WorkExperienceDao workExperience) {
		super();
		this.workExperience = workExperience;
	}


	@Override
	public DataResult<List<WorkExperience>> getAll() {
		return new SuccessDataResult<List<WorkExperience>>(this.workExperience.findAll());
	}

	@Override
	public DataResult<List<WorkExperience>> getByCandidateIdOrderByFinishDate(int candidateId) {
		return new SuccessDataResult<List<WorkExperience>>(this.workExperience.getByCandidateIdOrderByFinishDate(candidateId));
	}

	@Override
	public Result add(WorkExperience workExperience) {
		this.workExperience.save(workExperience);
		return new SuccessResult();
	}
}
