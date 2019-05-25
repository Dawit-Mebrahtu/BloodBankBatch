package edu.mum.bloodbankbatch.batch;


import edu.mum.bloodbankbatch.domain.Donation;
import edu.mum.bloodbankbatch.service.DonationService;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DonationItemReader  implements ItemReader<Donation> {

    @Autowired
    DonationService donationService;

    private int nextRow;
    private List<Donation> donations;


    @PostConstruct
    private void initialize() {
        donations = new ArrayList<Donation>();

        for (Donation donation : donationService.findByViableTrue()){
            donations.add(donation);
        }
        nextRow = 0;
    }

    @Override
    public Donation read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        Donation nextDonation = null;

        if (nextRow < donations.size()) {
            nextDonation = donations.get(nextRow);
            nextRow++;
        }

        return nextDonation;
    }
}
