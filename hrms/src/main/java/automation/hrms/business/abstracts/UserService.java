package automation.hrms.business.abstracts;

import java.util.List;

import automation.hrms.core.entities.concrete.User;
import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;

public interface UserService {
	DataResult<List<User>> getAll();
	DataResult<User> findByMail(String email);
	DataResult<User> getById(int id);
	Result add(User user);
	Result delete(User user);
	Result update(User user);
}
