package automation.hrms.core.adapters.mernis;

import java.util.Date;

public interface UserCheckService {

	boolean validate(String firstName, String lastName,String nationalityId, Date birthDate);
}
