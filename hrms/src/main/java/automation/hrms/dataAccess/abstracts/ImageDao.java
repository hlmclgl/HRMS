package automation.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import automation.hrms.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer>{

	Image getByCandidateId(int candidateId);
}
