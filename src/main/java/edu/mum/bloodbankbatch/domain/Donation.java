package edu.mum.bloodbankbatch.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
//@Data
public class Donation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean viable = true;
	private int quantity;


	private Date donationDate;

	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="blood_drive_id")
	private BloodDrive bloodDrive;

	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="donor_id")
	private Donor donor;

	public Donation() {
	}
	public Donation(Long id, Boolean viable, int quantity, Date donationDate, Donor donor) {
		this.id = id;
		this.viable = viable;
		this.quantity = quantity;
		this.donationDate = donationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isViable() {
		return viable;
	}

	public void setViable(boolean viable) {
		this.viable = viable;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}

	public BloodDrive getBloodDrive() {
		return bloodDrive;
	}

	public void setBloodDrive(BloodDrive bloodDrive) {
		this.bloodDrive = bloodDrive;
	}

	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}
}
