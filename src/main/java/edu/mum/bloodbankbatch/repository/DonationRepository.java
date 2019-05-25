package edu.mum.bloodbankbatch.repository;

import edu.mum.bloodbankbatch.domain.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query(value = "SELECT d FROM Donation d WHERE d.viable = :viableValue  AND d.donationDate < :dueDate")
    public List<Donation> expiredDonations(Boolean viableValue, Date dueDate);

    public List<Donation> findByViableTrue();
}
