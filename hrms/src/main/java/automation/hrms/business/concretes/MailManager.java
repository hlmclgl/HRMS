package automation.hrms.business.concretes;

import org.springframework.stereotype.Service;

import automation.hrms.business.abstracts.MailService;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.core.utilities.results.SuccessResult;

@Service
public class MailManager implements MailService{

	@Override
	public Result confirm(String email) {
		System.out.println("Mail doğrulaması yapıldı");
		return new SuccessResult();
	}

}
