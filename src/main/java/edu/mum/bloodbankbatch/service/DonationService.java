package edu.mum.bloodbankbatch.service;

import edu.mum.bloodbankbatch.domain.Donation;

import java.util.Date;
import java.util.List;

public interface DonationService {

	public void save(Donation donation);
	public List<Donation> expiredDonations(Boolean viableValue, Date date);
	public List<Donation> findByViableTrue();
}
