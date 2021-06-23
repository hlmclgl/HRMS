package automation.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import automation.hrms.entities.concretes.ActivationByStaff;

public interface ActivationByStaffDao extends JpaRepository<ActivationByStaff, Integer>{

	ActivationByStaff getByEmployerId(int id);
}
