package automation.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import automation.hrms.business.abstracts.CandidateService;
import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {

	private CandidateService candidateService;
	
	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}

	@PostMapping("/add")
	public Result add(Candidate candidate) {
		return this.candidateService.add(candidate);
	}
	
	@PostMapping("/delete")
	public Result delete(Candidate candidate) {
		return this.candidateService.delete(candidate);
	}
	
	@PostMapping("/update")
	public Result update(Candidate candidate) {
		return this.candidateService.update(candidate);
	}
	
	@GetMapping("/getbyid")
	public DataResult<Candidate> getById(int id) {
		return this.candidateService.getById(id);
	}
	
	@GetMapping("/getbymail")
	public DataResult<Candidate> getByMail(String email) {
		return this.candidateService.getByMail(email);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll() {
		return this.candidateService.getAll();
	}
}
