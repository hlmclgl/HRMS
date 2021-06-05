package automation.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automation.hrms.business.abstracts.JobAdvertService;
import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.ErrorDataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.core.utilities.results.SuccessDataResult;
import automation.hrms.core.utilities.results.SuccessResult;
import automation.hrms.dataAccess.abstracts.JobAdvertDao;
import automation.hrms.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService{

	private JobAdvertDao jobAdvertDao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.findAll());
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		jobAdvert.getReleaseDate().equals(LocalDate.now());
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("iş ilanı eklendi.");
	}

	@Override
	public Result update(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("iş ilanı güncellendi.");
	}

	@Override
	public Result delete(JobAdvert jobAdvert) {
		this.jobAdvertDao.delete(jobAdvert);
		return new SuccessResult("iş ilanı kaldırıldı.");
	}

	@Override
	public DataResult<JobAdvert> changeStatus(int employerId, int announcementId, boolean status) {
		List<JobAdvert> adverts = this.jobAdvertDao.getByEmployerId(announcementId);
		for(JobAdvert jobAdvert : adverts) 
		{if(announcementId==jobAdvert.getId()) {
			jobAdvert.setActive(status);
			this.jobAdvertDao.save(jobAdvert);
			return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getById(announcementId));
		}
			}
		return new ErrorDataResult<JobAdvert>();
	}

	@Override
	public DataResult<List<JobAdvert>> getByIsActive() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByIsActiveTrue());
	}

	@Override
	public DataResult<List<JobAdvert>> getByApplicationDeadlineLessThanEqual(LocalDate date) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByDeadlineLessThanEqual(date));
	}

	@Override
	public DataResult<List<JobAdvert>> getByIsActiveAndApplicationDeadlineLessThanEqual(LocalDate date) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByIsActiveTrueAndDeadlineLessThanEqual(date));
	}

	@Override
	public DataResult<List<JobAdvert>> getByIsActiveAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByIsActiveTrueAndEmployer_CompanyName(companyName));
	}

	@Override
	public DataResult<List<JobAdvert>> getByEmployerId(int id) {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getByEmployerId(id));
	}

	@Override
	public JobAdvert getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
