package automation.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import automation.hrms.business.abstracts.SkillService;
import automation.hrms.entities.concretes.Skill;

@RestController
@RequestMapping("/api/skills")
public class SkillsController {

	private SkillService skillService;

	@Autowired
	public SkillsController(SkillService skillService) {
		super();
		this.skillService = skillService;
	};
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.skillService.getAll());
	}
	
	@GetMapping("/getbyid")
	public ResponseEntity<?> getByCandidateId(@RequestParam int candidateId){
		return ResponseEntity.ok(this.skillService.getByCandidateId(candidateId));
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Skill skill){
		return ResponseEntity.ok(this.skillService.add(skill));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody Skill skill){
		return ResponseEntity.ok(this.skillService.delete(skill));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody Skill skill){
		return ResponseEntity.ok(this.skillService.update(skill));
	}
}
