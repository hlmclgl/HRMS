package automation.hrms.core.utilities.helpers.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import automation.hrms.core.utilities.results.DataResult;
import automation.hrms.core.utilities.results.Result;

public interface FileHelper {

	DataResult<?> upload(MultipartFile file) throws IOException;
	Result delete(String id) throws IOException;
}
