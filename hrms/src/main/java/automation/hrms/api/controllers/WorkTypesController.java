package automation.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import automation.hrms.business.abstracts.WorkTypeService;
import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.entities.concretes.WorkType;

@RestController
@RequestMapping("/worktypes")
@CrossOrigin
public class WorkTypesController {

	private WorkTypeService workTypeService;

	@Autowired
	public WorkTypesController(WorkTypeService workTypeService) {
		super();
		this.workTypeService = workTypeService;
	}
	
	@GetMapping("/getall")
    public DataResult<List<WorkType>> getAll(){
        return this.workTypeService.getAll();
    }
}
