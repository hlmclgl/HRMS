package automation.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import automation.hrms.business.abstracts.LinkTypeService;
import automation.hrms.entities.concretes.LinkType;

@RestController
@RequestMapping("/api/linktypes")
public class LinkTypesController {

	private LinkTypeService linkTypeService;

	@Autowired
	public LinkTypesController(LinkTypeService linkTypeService) {
		super();
		this.linkTypeService = linkTypeService;
	}
	
	@PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody LinkType linkType){
        return ResponseEntity.ok(this.linkTypeService.add(linkType));
    }	    

	@PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody LinkType linkType){
        return ResponseEntity.ok(this.linkTypeService.update(linkType));
    }
	
	@PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LinkType linkType){
        return ResponseEntity.ok(this.linkTypeService.delete(linkType));
    }
	
    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.linkTypeService.getAll());
    }
}
