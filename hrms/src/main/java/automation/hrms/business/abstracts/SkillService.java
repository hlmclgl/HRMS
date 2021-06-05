package automation.hrms.business.abstracts;

import java.util.List;

import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.entities.concretes.Skill;

public interface SkillService {
	DataResult<List<Skill>> getByCandidateId(int candidateId);
	DataResult<List<Skill>> getAll();
	Result add(Skill skill);
	Result delete(Skill skill);
	Result update(Skill skill);
}
