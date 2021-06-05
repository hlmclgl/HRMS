package automation.hrms.business.abstracts;

import java.util.List;

import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.entities.concretes.LinkType;

public interface LinkTypeService {
	Result add(LinkType linkType);
	Result delete(LinkType linkType);
	Result update(LinkType linkType);
    DataResult<List<LinkType>> getAll();
}
