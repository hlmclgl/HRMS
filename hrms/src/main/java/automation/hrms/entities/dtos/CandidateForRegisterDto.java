package automation.hrms.entities.dtos;

import java.time.LocalDate;


import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateForRegisterDto {

	@NotBlank
    private String firstName;
    
	@NotBlank
	private String lastName;
    
	@NotBlank
	private String nationalIdentity;
    
	@NotBlank
	private LocalDate birthDate;
    
	@NotBlank
	@Email
	private String email;
    
	@NotBlank
	@Min(6)
	private String password;
    
	@NotBlank
	@Min(6)
	private String repassword;
}
