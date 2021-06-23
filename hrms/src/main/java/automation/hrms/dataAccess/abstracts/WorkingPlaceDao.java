package automation.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import automation.hrms.entities.concretes.WorkingPlace;

public interface WorkingPlaceDao extends JpaRepository<WorkingPlace, Integer>{

}
