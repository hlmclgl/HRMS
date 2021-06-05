package automation.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automation.hrms.business.abstracts.JobService;
import automation.hrms.core.utilities.business.BusinessRules;
import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.ErrorResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.core.utilities.results.SuccessDataResult;
import automation.hrms.core.utilities.results.SuccessResult;
import automation.hrms.dataAccess.abstracts.JobDao;
import automation.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService{

	private JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public Result add(Job job) {
		Result result = BusinessRules.run(checkJob(job.getPosition()));
		if (result != null) {
			return result;
		}
			
		this.jobDao.save(job);
		return new SuccessResult("Veri eklendi.");
	}

	@Override
	public Result delete(Job job) {
		this.jobDao.delete(job);
		return new SuccessResult("Veri silindi.");
	}

	@Override
	public Result update(Job job) {
		this.jobDao.save(job);
		return new SuccessResult("Veri güncellendi.");
	}

	@Override
	public DataResult<Job> getById(int id) {
		return new SuccessDataResult<Job>(this.jobDao.getOne(id), "Veri getirildi.");
				
	}

	@Override
	public DataResult<Job> getByPosition(String position) {
		return null;
	}

	@Override
	public DataResult<List<Job>> getAll() {
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(), "Veri getirildi.");
	}

	private Result checkJob(String name) {
		List<Job> list = this.jobDao.findAll();
		for (Job job : list) {
			if(job.getPosition() == name) {
				return new ErrorResult("Aynı isimde birden fazla pozisyon eklenemez.");
			}
		}
		return new SuccessResult();
	}
}
