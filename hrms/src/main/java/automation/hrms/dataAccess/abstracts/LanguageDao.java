package automation.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import automation.hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer>{

}
