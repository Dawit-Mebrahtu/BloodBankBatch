package edu.mum.bloodbankbatch.batch;

import edu.mum.bloodbankbatch.domain.Donation;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;



@Component
public class DonationProcessor implements ItemProcessor<Donation, Donation> {

    @Override
    public Donation process(Donation donation) throws Exception {
        long milliSecondsBloodStored = (new Date().getTime()) - donation.getDonationDate().getTime();
        long daysBloodStored = milliSecondsBloodStored / (24*60*60*1000);
        System.out.println("DAYS DONATION BEEN IN STORAGE === " + daysBloodStored);
//        System.out.println("DATE OF CURRENT RECORD: " + donation.getDonationDate().getTime());

        if (daysBloodStored >= 42) {
            donation.setViable(false);
            System.out.println(">>>>>>>>>>>>>>" + donation.getId() + " === DONATION MARKED AS NOT VIABLE ANYMORE <<<<<<<<<");
        }

        return donation;
    }
}
