package automation.hrms.business.abstracts;

import java.util.List;

import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.entities.concretes.Link;

public interface LinkService {
	DataResult<List<Link>> getByCandidateId(int candidateId);
	Result add(Link link);
	Result delete(Link link);
	Result update(Link link);
    DataResult<List<Link>> getAll();
}
