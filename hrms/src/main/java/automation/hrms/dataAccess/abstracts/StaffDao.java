package automation.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import automation.hrms.entities.concretes.Staff;

public interface StaffDao extends JpaRepository<Staff, Integer>{

}
