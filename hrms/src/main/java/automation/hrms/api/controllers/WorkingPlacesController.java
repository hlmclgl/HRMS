package automation.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import automation.hrms.business.abstracts.WorkingPlaceService;
import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.entities.concretes.WorkingPlace;

@RestController
@RequestMapping("/workingplaces")
@CrossOrigin
public class WorkingPlacesController {

	private WorkingPlaceService workingPlaceService;

	@Autowired
	public WorkingPlacesController(WorkingPlaceService workingPlaceService) {
		super();
		this.workingPlaceService = workingPlaceService;
	}
	
	@GetMapping("/getall")
    public DataResult<List<WorkingPlace>> getAll(){
        return this.workingPlaceService.getAll();
    }
}
