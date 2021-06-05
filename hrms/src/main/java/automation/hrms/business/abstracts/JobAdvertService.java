package automation.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {

	DataResult<List<JobAdvert>> getAll();
	Result add(JobAdvert jobAdvert);
	Result update(JobAdvert jobAdvert);
	Result delete(JobAdvert jobAdvert);
	DataResult<JobAdvert> changeStatus(int employerId,int announcementId, boolean status);
	DataResult<List<JobAdvert>> getByIsActive();
	DataResult<List<JobAdvert>> getByApplicationDeadlineLessThanEqual(LocalDate date);
	DataResult<List<JobAdvert>> getByIsActiveAndApplicationDeadlineLessThanEqual(LocalDate date);
	DataResult<List<JobAdvert>> getByIsActiveAndEmployer_CompanyName(String companyName);
	DataResult<List<JobAdvert>> getByEmployerId(int id);
	JobAdvert getById(int id);

}
