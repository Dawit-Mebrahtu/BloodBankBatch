package edu.mum.bloodbankbatch.service.impl;

import edu.mum.bloodbankbatch.domain.Donation;
import edu.mum.bloodbankbatch.repository.DonationRepository;
import edu.mum.bloodbankbatch.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
//@Transactional
 public class DonationServiceImpl implements DonationService {
	
 	@Autowired
	private DonationRepository donationRepository;

	@Override
	public void save(Donation donation) {
		try {
			this.donationRepository.save(donation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Donation> expiredDonations(Boolean viableValue, Date date) {
		return donationRepository.expiredDonations(viableValue, date);
	}

	public List<Donation> findByViableTrue(){
		return donationRepository.findByViableTrue();
	}
}
