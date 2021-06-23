package automation.hrms.business.concretes;

import java.time.LocalDate;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automation.hrms.business.abstracts.ActivationByStaffService;
import automation.hrms.core.utilities.results.ErrorResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.core.utilities.results.SuccessResult;
import automation.hrms.dataAccess.abstracts.ActivationByStaffDao;
import automation.hrms.dataAccess.abstracts.EmployerDao;
import automation.hrms.dataAccess.abstracts.StaffDao;
import automation.hrms.entities.concretes.ActivationByStaff;
import automation.hrms.entities.concretes.Employer;

@Service
public class ActivationByStaffManager implements ActivationByStaffService{

	private ActivationByStaffDao activationByStaffDao;
	private EmployerDao employerDao;
	private StaffDao staffDao;
	
	@Autowired
	public ActivationByStaffManager(ActivationByStaffDao activationByStaffDao, EmployerDao employerDao, StaffDao staffDao) {
		super();
		this.activationByStaffDao = activationByStaffDao;
		this.employerDao = employerDao;
		this.staffDao = staffDao;
	}

	@Override
	public void createActivationByStaff(Employer employer) {
		ActivationByStaff activationByStaff = new ActivationByStaff();
		activationByStaff.setEmployer(employer);
		activationByStaff.setConfirm(false);
		activationByStaff.setStaff(null);
		activationByStaffDao.save(activationByStaff);
		
	}

	@Override
	public Result activateEmployer(int employerId, int staffId) {
		try {
			Employer employer = employerDao.getOne(employerId);
			ActivationByStaff activationByStaff = activationByStaffDao.getByEmployerId(employerId);
			
			employer.setConfirm(true);
			employerDao.save(employer);
			
			activationByStaff.setConfirm(true);
			activationByStaff.setConfirmDate(LocalDate.now());
			activationByStaff.setStaff(staffDao.getOne(staffId));
			activationByStaffDao.save(activationByStaff);
		}catch (EntityNotFoundException exception){
            return new ErrorResult("Hatalı id");
        }
		return new SuccessResult("Kullanıcı aktif hale getirildi.");
	}

}
