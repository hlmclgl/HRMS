package automation.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import automation.hrms.entities.concretes.Link;

public interface LinkDao extends JpaRepository<Link, Integer>{
	List<Link> getByCandidateId(int candidateId);
}
