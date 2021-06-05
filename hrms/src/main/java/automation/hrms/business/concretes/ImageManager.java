package automation.hrms.business.concretes;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import automation.hrms.business.abstracts.ImageService;
import automation.hrms.core.utilities.helpers.abstracts.FileHelper;
import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.ErrorDataResult;
import automation.hrms.core.utilities.results.ErrorResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.core.utilities.results.SuccessDataResult;
import automation.hrms.core.utilities.results.SuccessResult;
import automation.hrms.dataAccess.abstracts.ImageDao;
import automation.hrms.entities.concretes.Image;

@Service
public class ImageManager implements ImageService{

	private ImageDao imageDao;
	private FileHelper helper;
	
	@Autowired
	public ImageManager(ImageDao imageDao, FileHelper helper) {
		super();
		this.imageDao = imageDao;
		this.helper = helper;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Result add(Image candidateImage, MultipartFile file) throws IOException {
		Map<String,String> getImage = (Map<String,String>)helper.upload(file).getData();
		candidateImage.setUrl(getImage.get("url"));
		candidateImage.setUploadedDate(LocalDate.now());
		var result = this.imageDao.save(candidateImage);
		if(result != null) {
			return new SuccessResult("Resim yüklendi.");
		}
		return new ErrorResult("Resim yüklenemedi.");
	}

	@Override
	public DataResult<List<Image>> getAll() {
		return new SuccessDataResult<>(this.imageDao.findAll());
	}

	@Override
	public DataResult<List<Image>> getByCandidateId(int candidateId) {
		var result =  this.imageDao.getByCandidateId(candidateId);
		if (result != null) {
			return new SuccessDataResult<List<Image>>(this.imageDao.getByCandidateId(candidateId));
		}
		return new ErrorDataResult<List<Image>>("Resim bulunamadı.");
	}

}
