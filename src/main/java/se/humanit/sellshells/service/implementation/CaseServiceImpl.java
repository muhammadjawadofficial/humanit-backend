package se.humanit.sellshells.service.implementation;

import org.springframework.stereotype.Service;
import se.humanit.sellshells.entities.CaseInfo;
import se.humanit.sellshells.entities.PhoneCase;
import se.humanit.sellshells.repository.CaseRepository;
import se.humanit.sellshells.repository.PhoneCaseRepository;
import se.humanit.sellshells.service.CaseService;

import java.util.Collections;
import java.util.List;

@Service
public class CaseServiceImpl implements CaseService {

    private final CaseRepository caseRepository;
    private final PhoneCaseRepository phoneCaseRepository;

    CaseServiceImpl(CaseRepository caseRepository, PhoneCaseRepository phoneCaseRepository){
        this.caseRepository = caseRepository;
        this.phoneCaseRepository = phoneCaseRepository;
    }

    @Override
    public List<CaseInfo> getAllCases() {
        return caseRepository.findAll();
    }

    @Override
    public CaseInfo getCaseById(Integer phoneId) {
        return caseRepository.findById(phoneId).orElse(null);
    }

    @Override
    public List<CaseInfo> getPhoneCases(Integer phoneId) {
        List<PhoneCase> phoneCaseList = phoneCaseRepository.findByPhoneId(phoneId);
        if(phoneCaseList.size()>0){
            List<Integer> caseIdList = phoneCaseList.stream().map(PhoneCase::getCaseId).toList();
            return caseRepository.findAllById(caseIdList);
        }
        return Collections.emptyList();
    }

    @Override
    public CaseInfo saveCaseInfo(CaseInfo caseInfo) {
        return caseRepository.save(caseInfo);
//        return caseInfo;
    }
}
