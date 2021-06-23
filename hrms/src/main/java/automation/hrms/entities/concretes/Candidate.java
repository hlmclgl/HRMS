package automation.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(name="birth_date")
	private LocalDate birthDate;
	
	@Column(name="regarding")
	private String regarding;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Education> userEducations;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<UserLanguage> userLanguages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<WorkExperience> userExperience;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Link> userLinks;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Skill> userSkills;
	
	@JsonIgnore
	@OneToOne(mappedBy = "candidate",optional=true, fetch=FetchType.LAZY)
	private Image userImages;
	
	
}
