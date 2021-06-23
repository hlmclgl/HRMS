package automation.hrms.business.abstracts;

import java.util.List;

import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.entities.concretes.WorkingPlace;

public interface WorkingPlaceService {

	public DataResult<List<WorkingPlace>> getAll();
}
