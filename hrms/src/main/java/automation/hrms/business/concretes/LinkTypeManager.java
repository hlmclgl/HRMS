package automation.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import automation.hrms.business.abstracts.LinkTypeService;
import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.core.utilities.results.SuccessDataResult;
import automation.hrms.core.utilities.results.SuccessResult;
import automation.hrms.dataAccess.abstracts.LinkTypeDao;
import automation.hrms.entities.concretes.LinkType;

@Service
public class LinkTypeManager implements LinkTypeService{

	private LinkTypeDao linkTypeDao;

	@Autowired
	public LinkTypeManager(LinkTypeDao linkTypeDao) {
		super();
		this.linkTypeDao = linkTypeDao;
	}

	@Override
	public Result add(LinkType linkType) {
		this.linkTypeDao.save(linkType);
		return new SuccessResult();
	}

	@Override
	public Result delete(LinkType linkType) {
		this.linkTypeDao.delete(linkType);
		return new SuccessResult();
	}

	@Override
	public Result update(LinkType linkType) {
		this.linkTypeDao.save(linkType);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<LinkType>> getAll() {
		return new SuccessDataResult<List<LinkType>>(this.linkTypeDao.findAll());
	}


	
}
