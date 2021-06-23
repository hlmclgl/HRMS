package automation.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automation.hrms.business.abstracts.CandidateService;
import automation.hrms.business.abstracts.EducationService;
import automation.hrms.business.abstracts.ImageService;
import automation.hrms.business.abstracts.LinkService;
import automation.hrms.business.abstracts.SkillService;
import automation.hrms.business.abstracts.UserLanguageService;
import automation.hrms.business.abstracts.WorkExperienceService;
import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.core.utilities.results.SuccessDataResult;
import automation.hrms.core.utilities.results.SuccessResult;
import automation.hrms.dataAccess.abstracts.CandidateDao;
import automation.hrms.entities.concretes.Candidate;
import automation.hrms.entities.dtos.CvDto;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private WorkExperienceService workExperienceService;
	private LinkService linkService;
	private UserLanguageService userLanguageService;
	private SkillService skillService;
	private EducationService educationService;
	private ImageService imageService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, WorkExperienceService workExperienceService,
			LinkService linkService, UserLanguageService userLanguageService, SkillService skillService,
			EducationService educationService, ImageService imageService) {
		super();
		this.candidateDao = candidateDao;
		this.workExperienceService = workExperienceService;
		this.linkService = linkService;
		this.userLanguageService = userLanguageService;
		this.skillService = skillService;
		this.educationService = educationService;
		this.imageService = imageService;
	}


	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Veri getirildi.");
				
	}

	@Override
	public Result add(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult();
	}

	@Override
	public Result delete(Candidate candidate) {
		this.candidateDao.delete(candidate);
		return new SuccessResult();
	}

	@Override
	public Result update(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult();
	}

	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getOne(id), "Veri getirildi.");
				
	}

	@Override
	public DataResult<Candidate> getByMail(String email) {
		return null;
	}

	@Override
	public DataResult<Candidate> findByNationalityId(String nationalityId) {
		return new SuccessDataResult<Candidate>(candidateDao.findByNationalIdentity(nationalityId));
	}

	@Override
	public DataResult<CvDto> getCvById(int candidateId) {
		CvDto cvDto = new CvDto();
		cvDto.education = this.educationService.getByCandidateIdOrderByGraduationYear(candidateId).getData();
		cvDto.languages = this.userLanguageService.getByCandidateId(candidateId).getData();
		cvDto.links = this.linkService.getByCandidateId(candidateId).getData();
		cvDto.skills = this.skillService.getByCandidateId(candidateId).getData();
		cvDto.workExperiences = this.workExperienceService.getByCandidateIdOrderByFinishDate(candidateId).getData();
		cvDto.image = this.imageService.getByCandidateId(candidateId).getData();
		
		return new SuccessDataResult<CvDto>(cvDto);
	}

}
