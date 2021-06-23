package automation.hrms.business.abstracts;

import java.util.List;

import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.entities.concretes.Candidate;
import automation.hrms.entities.dtos.CvDto;

public interface CandidateService {

	DataResult<List<Candidate>> getAll();
	Result add(Candidate candidate);
	Result delete(Candidate candidate);
	Result update(Candidate candidate);
	DataResult<Candidate> getById(int id);
	DataResult<Candidate> getByMail(String email);
	DataResult<Candidate> findByNationalityId(String nationalityId);
	DataResult<CvDto> getCvById(int candidateId);
}
