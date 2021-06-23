package automation.hrms.business.abstracts;

import automation.hrms.core.entities.concrete.User;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.entities.concretes.ActivationCode;

public interface ActivationCodeService {

	ActivationCode getByActivationCode(String activationCode);
	String createActivationCode(User user);
    Result activateUser(String code);
}
