package se.humanit.sellshells.service;

import se.humanit.sellshells.entities.CaseInfo;

import java.util.List;

public interface CaseService {
    List<CaseInfo> getAllCases();

    CaseInfo getCaseById(Integer phoneId);

    List<CaseInfo> getPhoneCases(Integer phoneId);

    CaseInfo saveCaseInfo(CaseInfo caseInfo);
}
