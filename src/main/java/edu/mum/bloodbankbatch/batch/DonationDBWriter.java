package edu.mum.bloodbankbatch.batch;

import edu.mum.bloodbankbatch.domain.Donation;
import edu.mum.bloodbankbatch.repository.DonationRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DonationDBWriter implements ItemWriter<Donation> {

    @Autowired
    private DonationRepository donationRepository;

    @Override
    public void write(List<? extends Donation> donations) throws Exception {
        for (Donation donation : donations) {
            donationRepository.save(donation);
        }
    }
}
