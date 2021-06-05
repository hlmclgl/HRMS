package automation.hrms.business.abstracts;

import java.util.List;

import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.entities.concretes.City;

public interface CityService {

	DataResult<List<City>> getAll();
	Result add(City city);
	Result update(City city);
	Result delete(City city);
}
