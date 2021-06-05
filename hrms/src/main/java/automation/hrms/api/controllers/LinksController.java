package automation.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import automation.hrms.business.abstracts.LinkService;
import automation.hrms.entities.concretes.Link;

@RestController
@RequestMapping("/api/links")
public class LinksController {

	private LinkService linkService;

	@Autowired
	public LinksController(LinkService linkService) {
		super();
		this.linkService = linkService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Link link){
	     return ResponseEntity.ok(this.linkService.add(link));
	}

	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody Link link){
	     return ResponseEntity.ok(this.linkService.update(link));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody Link link){
	     return ResponseEntity.ok(this.linkService.delete(link));
	}

	@GetMapping("/getall")
    public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.linkService.getAll());
    }
	
	@GetMapping("/getbyid")
	public ResponseEntity<?> getByCandidateId(@RequestParam int candidateId){
		return ResponseEntity.ok(this.linkService.getByCandidateId(candidateId));
	}
}
