package automation.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automation.hrms.business.abstracts.EmployerService;
import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.core.utilities.results.SuccessDataResult;
import automation.hrms.core.utilities.results.SuccessResult;
import automation.hrms.dataAccess.abstracts.EmployerDao;
import automation.hrms.entities.concretes.Employer;


@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public Result add(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult("Veri eklendi");
	}

	@Override
	public Result delete(Employer employer) {
		this.employerDao.delete(employer);
		return new SuccessResult("Veri silindi");
	}

	@Override
	public Result update(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult("Veri güncellendi");
	}

	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.getOne(id), "Veri getirildi.");
				
		
	}

	@Override
	public DataResult<Employer> getByMail(String email) {
		return null;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Veri getirildi.");
				
	}

}
