package automation.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automation.hrms.business.abstracts.EducationService;
import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.core.utilities.results.SuccessDataResult;
import automation.hrms.core.utilities.results.SuccessResult;
import automation.hrms.dataAccess.abstracts.EducationDao;
import automation.hrms.entities.concretes.Education;

@Service
public class EducationManager implements EducationService{

	private EducationDao educationDao;

	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public DataResult<List<Education>> getByCandidateIdOrderByGraduationYear(int candidateId) {
		return new SuccessDataResult<List<Education>>(this.educationDao.getByCandidateIdOrderByGraduationYear(candidateId),"Eğitimler listelendi.");
	}

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll());
	}

	@Override
	public Result add(Education education) {
		this.educationDao.save(education);
		return new SuccessResult();
	}

	@Override
	public Result delete(Education education) {
		this.educationDao.delete(education);
		return new SuccessResult();
	}

	@Override
	public Result update(Education education) {
		this.educationDao.save(education);
		return new SuccessResult();
	}
}
