package automation.hrms.api.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import automation.hrms.business.abstracts.ImageService;
import automation.hrms.entities.concretes.Candidate;
import automation.hrms.entities.concretes.Image;

@RestController 
@RequestMapping("/api/images")
@CrossOrigin
public class ImageController {

	private ImageService imageService;

	@Autowired
	public ImageController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	@PostMapping(value="/upload")
	public ResponseEntity<?> add(@RequestBody MultipartFile file,@RequestParam int candidateId) throws IOException {
		Image image = new Image();
		Candidate candidate = new Candidate();
		candidate.setId(candidateId);
		image.setCandidate(candidate);
		
		return ResponseEntity.ok(this.imageService.add(image, file));
	}
	
	@GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.imageService.getAll());
    }
	
	@GetMapping("/getbyid")
    public ResponseEntity<?> getByCandidateId(int id){
        return ResponseEntity.ok(this.imageService.getByCandidateId(id));
    }
}
