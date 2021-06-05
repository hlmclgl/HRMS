package automation.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import automation.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer>{

	 List<Education> getByCandidateIdOrderByGraduationYear(int candidateId);
}
