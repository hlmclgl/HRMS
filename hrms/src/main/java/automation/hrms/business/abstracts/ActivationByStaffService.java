package automation.hrms.business.abstracts;

import automation.hrms.core.utilities.results.Result;
import automation.hrms.entities.concretes.Employer;

public interface ActivationByStaffService {

	void createActivationByStaff(Employer employer);
    Result activateEmployer(int employerId,int staffId);
}
