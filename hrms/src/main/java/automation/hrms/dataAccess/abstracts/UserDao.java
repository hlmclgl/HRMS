package automation.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import automation.hrms.core.entities.concrete.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User findByEmail(String email);
}
