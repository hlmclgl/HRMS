package automation.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;
import automation.hrms.entities.concretes.Image;

public interface ImageService {

    Result add(Image candidateImage, MultipartFile file) throws IOException;
    DataResult<List<Image>> getAll();
    DataResult<Image> getByCandidateId(int candidateId);
}
