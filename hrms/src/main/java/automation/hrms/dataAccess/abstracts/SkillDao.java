package automation.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import automation.hrms.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill, Integer>{
	List<Skill> getByCandidateId(int candidateId);
}
