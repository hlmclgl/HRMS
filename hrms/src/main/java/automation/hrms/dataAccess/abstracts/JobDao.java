package automation.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import automation.hrms.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer>{

}
