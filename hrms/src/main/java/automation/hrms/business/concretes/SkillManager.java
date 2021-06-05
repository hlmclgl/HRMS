package automation.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automation.hrms.business.abstracts.SkillService;
import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.core.utilities.results.SuccessDataResult;
import automation.hrms.core.utilities.results.SuccessResult;
import automation.hrms.dataAccess.abstracts.SkillDao;
import automation.hrms.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService{

	private SkillDao skillDao;

	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}

	@Override
	public DataResult<List<Skill>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Skill>>(this.skillDao.getByCandidateId(candidateId));
	}

	@Override
	public DataResult<List<Skill>> getAll() {
		return new SuccessDataResult<List<Skill>>(this.skillDao.findAll());
	}

	@Override
	public Result add(Skill skill) {
		this.skillDao.save(skill);
		return new SuccessResult();
	}

	@Override
	public Result delete(Skill skill) {
		this.skillDao.delete(skill);
		return new SuccessResult();
	}

	@Override
	public Result update(Skill skill) {
		this.skillDao.save(skill);
		return new SuccessResult();
	}
}
