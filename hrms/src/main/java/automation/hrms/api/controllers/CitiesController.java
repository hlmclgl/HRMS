package automation.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import automation.hrms.business.abstracts.CityService;
import automation.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesController {

	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.cityService.getAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody City city){
		return ResponseEntity.ok(this.cityService.add(city));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody City city){
		return ResponseEntity.ok(this.cityService.delete(city));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody City city){
		return ResponseEntity.ok(this.cityService.update(city));
	}
}
