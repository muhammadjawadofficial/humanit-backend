package se.humanit.sellshells.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.humanit.sellshells.entities.CaseImages;

import java.util.stream.Stream;

public interface CaseImagesRepository extends JpaRepository<CaseImages, Integer> {
    Stream<CaseImages> findAllByTypeIdAndTypeName(Integer typeId, String typeName);
}
