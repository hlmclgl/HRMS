package automation.hrms.business.abstracts;

import automation.hrms.core.utilities.results.Result;

public interface MailService {

	Result confirm(String email);
}
