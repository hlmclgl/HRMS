package automation.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_adverts")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private int id;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@Column(name="min_salary", nullable=false)
	private int minSalary;
	
	@Column(name="max_salary", nullable=false)
	private int maxSalary;
	
	@Column(name="open_positions", nullable=false)
	private int openPosition;
	
	@Column(name="deadline", nullable=false)
	private LocalDate deadline;
	
	@Column(name="is_active", nullable=false)
	private boolean isActive;
	
	@Column (name = "releaseDate", nullable = false)
	private LocalDate releaseDate;
	
	@JsonIgnoreProperties({"user_id","web_address","company_name","telephone","email","password"})
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@JsonIgnoreProperties({"id"})
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@JsonIgnoreProperties({"id"})
	@ManyToOne()
	@JoinColumn(name="job_id")
	private Job job; 
}
