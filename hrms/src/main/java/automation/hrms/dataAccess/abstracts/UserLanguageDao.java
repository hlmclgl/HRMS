package automation.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import automation.hrms.entities.concretes.UserLanguage;

public interface UserLanguageDao extends JpaRepository<UserLanguage, Integer>{
	List<UserLanguage> getByCandidateId(int candidateId);
}
