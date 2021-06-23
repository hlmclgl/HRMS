package automation.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automation.hrms.business.abstracts.WorkingPlaceService;
import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.SuccessDataResult;
import automation.hrms.dataAccess.abstracts.WorkingPlaceDao;
import automation.hrms.entities.concretes.WorkingPlace;

@Service
public class WorkingPlaceManager implements WorkingPlaceService{

	private WorkingPlaceDao workingPlaceDao;

	@Autowired
	public WorkingPlaceManager(WorkingPlaceDao workingPlaceDao) {
		super();
		this.workingPlaceDao = workingPlaceDao;
	}

	@Override
	public DataResult<List<WorkingPlace>> getAll() {
		return new SuccessDataResult<List<WorkingPlace>>(this.workingPlaceDao.findAll(),"Veri getirildi.");
	}
}
