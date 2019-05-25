package edu.mum.bloodbankbatch.domain;


import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Donor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;

	@Min(value=16)
	private Integer age;

	@Min(value=110)
	private Double weight;

	@Email
	private String email;
	private String phoneNumber;
	private String medicalHistory;

	@OneToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="credentials_id")
	UserCredentials userCredentials;

	@OneToOne(fetch= FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Address address;

	@OneToMany(mappedBy="donor",fetch= FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Donation> donations = new HashSet<Donation>();


	public Donor() {}

	public Donor(String firstName, String lastName, int age, double weight, String email, String phoneNumber,
                 String medicalHistory) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.weight = weight;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.medicalHistory = medicalHistory;
	}

	public void addDonation(Donation donation) {
		this.donations.add(donation);
		donation.setDonor(this);
	}
}
