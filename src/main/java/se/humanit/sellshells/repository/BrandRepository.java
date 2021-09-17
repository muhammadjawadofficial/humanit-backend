package se.humanit.sellshells.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.humanit.sellshells.entities.Brand;

public interface  BrandRepository extends JpaRepository<Brand, Integer> {
}
