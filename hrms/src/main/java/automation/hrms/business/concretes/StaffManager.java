package automation.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automation.hrms.business.abstracts.StaffService;
import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.core.utilities.results.SuccessDataResult;
import automation.hrms.core.utilities.results.SuccessResult;
import automation.hrms.dataAccess.abstracts.StaffDao;
import automation.hrms.entities.concretes.Staff;


@Service
public class StaffManager implements StaffService{

	private StaffDao staffDao;
	
	@Autowired
	public StaffManager(StaffDao staffDao) {
		super();
		this.staffDao = staffDao;
	}

	@Override
	public Result add(Staff staff) {
		this.staffDao.save(staff);
		return new SuccessResult("Veri eklendi.");
	}

	@Override
	public Result delete(Staff staff) {
		this.staffDao.delete(staff);
		return new SuccessResult("Veri silindi.");
	}

	@Override
	public Result update(Staff staff) {
		this.staffDao.save(staff);
		return new SuccessResult("Veri eklendi.");
	}

	@Override
	public DataResult<Staff> getById(int id) {
		return new SuccessDataResult<Staff>(this.staffDao.getOne(id), "Veri getirildi.");
				
	}

	@Override
	public DataResult<Staff> getByMail(String email) {
		return null;
	}

	@Override
	public DataResult<List<Staff>> getAll() {
		return new SuccessDataResult<List<Staff>>(this.staffDao.findAll(), "Veri getirildi.");
	}

}
