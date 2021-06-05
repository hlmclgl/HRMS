package automation.hrms.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import automation.hrms.business.abstracts.StaffService;
import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.entities.concretes.Staff;

@RestController
@RequestMapping("/api/staffs")
public class StaffsController {

	private StaffService staffService;

	@Autowired
	public StaffsController(StaffService staffService) {
		super();
		this.staffService = staffService;
	}
	
	@PostMapping("/add")
	public Result add(Staff staff) {
		return this.staffService.add(staff);
	}
	
	@PostMapping("/delete")
	public Result delete(Staff staff) {
		return this.staffService.delete(staff);
	}
	
	@PostMapping("/update")
	public Result update(Staff staff) {
		return this.staffService.update(staff);
	}
	
	@GetMapping("/getbyid")
	public DataResult<Staff> getById(int id) {
		return this.staffService.getById(id);
	}
	
	@GetMapping("/getbymail")
	public DataResult<Staff> getByMail(String email) {
		return this.staffService.getByMail(email);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Staff>> getAll(){
		return this.staffService.getAll();
	}
	
}
