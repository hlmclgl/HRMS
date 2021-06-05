package automation.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import automation.hrms.core.entities.concrete.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@Data
@Entity
@Table(name="candidates")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Candidate extends User{
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="national_identity")
	private String nationalIdentity;
	
	@Column(name="birthdate")
	private Date birthdate;
	
	@Column(name="regarding")
	private String regarding;
	
	@OneToMany(mappedBy = "candidate")
	private List<Education> userEducations;
	
	@OneToMany(mappedBy = "candidate")
	private List<UserLanguage> userLanguages;
	
	@OneToMany(mappedBy = "candidate")
	private List<WorkExperience> userExperience;
	
	@OneToMany(mappedBy = "candidate")
	private List<Link> userLinks;
	
	@OneToMany(mappedBy = "candidate")
	private List<Skill> userSkills;
	
	@OneToMany(mappedBy = "candidate")
	private List<Image> userImages;
	
	public Candidate(String email, String password, String firstName, String lastName, String nationalIdentity, Date birthDate) {
		super(email,password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalIdentity = nationalIdentity;
		this.birthdate = birthDate;
	}
}
