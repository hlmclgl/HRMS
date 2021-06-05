package automation.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import automation.hrms.business.abstracts.EmployerService;
import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@PostMapping("/add")
	public Result add(Employer employer) {
		return this.employerService.add(employer);
	}
	
	@PostMapping("/delete")
	public Result delete(Employer employer) {
		return this.employerService.delete(employer);
	}

	@PostMapping("/update")
	public Result update(Employer employer) {
		return this.employerService.update(employer);
	}
	
	@GetMapping("/getbyid")
	public DataResult<Employer> getById(int id) {
		return this.employerService.getById(id);
	}
	
	@GetMapping("/getbymail")
	public DataResult<Employer> getByMail(String email) {
		return this.employerService.getByMail(email);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll() {
		return this.employerService.getAll();
	}
	
}
