package automation.hrms.entities.dtos;

import java.util.List;

import automation.hrms.entities.concretes.Candidate;
import automation.hrms.entities.concretes.Education;
import automation.hrms.entities.concretes.Image;
import automation.hrms.entities.concretes.Link;
import automation.hrms.entities.concretes.Skill;
import automation.hrms.entities.concretes.UserLanguage;
import automation.hrms.entities.concretes.WorkExperience;

public class CvDto {

	public Candidate candidate;
	
	public List<Education> education;
	
	public List<Skill> skills;
	
	public List<UserLanguage> languages;
	
	public List<WorkExperience> workExperiences;
	
	public List<Link> links;
	
	public Image image;
	
	
}
