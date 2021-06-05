package automation.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import automation.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{

	Candidate findByNationalIdentity(String nationalId);
}
