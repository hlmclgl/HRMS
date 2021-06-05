package automation.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import automation.hrms.business.abstracts.JobService;
import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.entities.concretes.Job;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {

	private JobService jobService;

	@Autowired
	public JobsController(JobService jobService) {
		super();
		this.jobService = jobService;
	}
	
	@PostMapping("/add")
	public Result add(Job job) {
		return this.jobService.add(job);
	}
	
	@PostMapping("/delete")
	public Result delete(Job job) {
		return this.jobService.delete(job);
	}
	
	@PostMapping("/update")
	public Result update(Job job) {
		return this.jobService.update(job);
	} 
	
	@GetMapping("/getbyid")
	public DataResult<Job> getById(int id) {
		return this.jobService.getById(id);
	}
	
	@GetMapping("/getbyposition")
	public DataResult<Job> getByMail(String email) {
		return this.jobService.getByPosition(email);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Job>> getAll(){
		return this.jobService.getAll();
	}
}
