package automation.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automation.hrms.business.abstracts.LinkService;
import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.core.utilities.results.SuccessDataResult;
import automation.hrms.core.utilities.results.SuccessResult;
import automation.hrms.dataAccess.abstracts.LinkDao;
import automation.hrms.entities.concretes.Link;

@Service
public class LinkManager implements LinkService{

	private LinkDao linkDao;

	@Autowired
	public LinkManager(LinkDao linkDao) {
		super();
		this.linkDao = linkDao;
	}

	@Override
	public DataResult<List<Link>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Link>>(this.linkDao.getByCandidateId(candidateId));
	}

	@Override
	public Result add(Link link) {
		this.linkDao.save(link);
		return new SuccessResult();
	}

	@Override
	public Result delete(Link link) {
		this.linkDao.delete(link);
		return new SuccessResult();
	}

	@Override
	public Result update(Link link) {
		this.linkDao.save(link);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Link>> getAll() {
		return new SuccessDataResult<List<Link>>(this.linkDao.findAll());
	}
}
