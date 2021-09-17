package se.humanit.sellshells.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import se.humanit.sellshells.entities.PhoneCase;

import java.util.List;

public interface PhoneCaseRepository extends JpaRepository<PhoneCase, Integer> {
    @Query("select pc from PhoneCase pc where pc.phoneInfo.id=:phoneId")
    List<PhoneCase> findByPhoneId(Integer phoneId);
}
