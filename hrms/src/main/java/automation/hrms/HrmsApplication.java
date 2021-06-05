package automation.hrms;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import automation.hrms.core.utilities.helpers.abstracts.FileHelper;
import automation.hrms.core.utilities.helpers.concretes.CloudinaryManager;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HrmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmsApplication.class, args);
	}
	
	 @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.basePackage("automation.hrms"))                                       
	          .build();                                           
	    }

	 @Bean
	    public ModelMapper modelMapper() {
	        ModelMapper modelMapper = new ModelMapper();
	        modelMapper.getConfiguration()
	            .setMatchingStrategy(MatchingStrategies.STRICT);
	        return modelMapper;
	    }
	 
	 @Bean
	    public FileHelper helper(){
	        return new CloudinaryManager(cloudinaryManager());
	    }
	 
	 @Bean
	    public Cloudinary cloudinaryManager(){
	        return new Cloudinary(ObjectUtils.asMap(
	                "cloud_name", "dkg2ilhbc",
	                "api_key", "433627844473625",
	                "api_secret", "oLpD_Lht55nON2catRrbzx9bpJ0"));
	    }
}
