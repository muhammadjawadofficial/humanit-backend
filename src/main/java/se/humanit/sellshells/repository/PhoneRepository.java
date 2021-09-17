package se.humanit.sellshells.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.humanit.sellshells.entities.Phone;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {
    List<Phone> findByBrandId(Integer brandId);
}
