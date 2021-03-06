package automation.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automation.hrms.business.abstracts.WorkTypeService;
import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.SuccessDataResult;
import automation.hrms.dataAccess.abstracts.WorkTypeDao;
import automation.hrms.entities.concretes.WorkType;

@Service
public class WorkTypeManager implements WorkTypeService{

	private WorkTypeDao workTypeDao;

	@Autowired
	public WorkTypeManager(WorkTypeDao workTypeDao) {
		super();
		this.workTypeDao = workTypeDao;
	}

	@Override
	public DataResult<List<WorkType>> getAll() {
		return new SuccessDataResult<List<WorkType>>(this.workTypeDao.findAll(),"Veri getirildi.");
	}
	
	
}
