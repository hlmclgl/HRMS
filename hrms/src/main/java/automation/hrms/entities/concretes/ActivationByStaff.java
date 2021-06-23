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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "activation_by_staffs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivationByStaff {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "is_confirm")
    private boolean isConfirm;

    @Column(name = "confirm_date")
    private LocalDate confirmDate;
    
    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;
    
    @ManyToOne()
    @JoinColumn(name = "staff_id")
    private Staff staff;
}
