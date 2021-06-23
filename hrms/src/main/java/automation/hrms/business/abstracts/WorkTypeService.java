package automation.hrms.business.abstracts;

import java.util.List;

import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.entities.concretes.WorkType;

public interface WorkTypeService {

	public DataResult<List<WorkType>> getAll();
}
