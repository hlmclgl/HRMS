package automation.hrms.business.abstracts;

import java.util.List;

import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.entities.concretes.Staff;

public interface StaffService {

	Result add(Staff staff);
	Result delete(Staff staff);
	Result update(Staff staff);
	DataResult<Staff> getById(int id);
	DataResult<Staff> getByMail(String email);
	DataResult<List<Staff>> getAll();
}
