package se.humanit.sellshells.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import se.humanit.sellshells.entities.CaseInfo;

import java.util.List;

public interface CaseRepository extends JpaRepository<CaseInfo, Integer> {
    @Query("select caseInfo, caseImages from CaseInfo caseInfo, CaseImages caseImages ")
    List<CaseInfo> findAllByIdWithImages(List<Integer> caseIdList);
}