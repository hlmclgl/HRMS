package automation.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import automation.hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{

	List<JobAdvert> getByIsActiveTrue();
	List<JobAdvert> getByDeadlineLessThanEqual(LocalDate date);
	List<JobAdvert> getByIsActiveTrueAndDeadlineLessThanEqual(LocalDate date);
	List<JobAdvert> getByIsActiveTrueAndEmployer_CompanyName(String companyName);
	List<JobAdvert> getByEmployerId(int id);
	JobAdvert getById(int id);
}
