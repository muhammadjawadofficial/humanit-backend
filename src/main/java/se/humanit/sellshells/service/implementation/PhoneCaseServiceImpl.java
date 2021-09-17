package se.humanit.sellshells.service.implementation;

import org.springframework.stereotype.Service;
import se.humanit.sellshells.entities.PhoneCase;
import se.humanit.sellshells.repository.CaseRepository;
import se.humanit.sellshells.repository.PhoneCaseRepository;
import se.humanit.sellshells.service.PhoneCaseService;

import java.util.List;

@Service
public class PhoneCaseServiceImpl implements PhoneCaseService {

    private final PhoneCaseRepository phoneCaseRepository;
    private final CaseRepository caseRepository;

    PhoneCaseServiceImpl(PhoneCaseRepository phoneCaseRepository, CaseRepository caseRepository){
        this.phoneCaseRepository = phoneCaseRepository;
        this.caseRepository = caseRepository;
    }

    @Override
    public List<PhoneCase> getPhoneCases() {
        return phoneCaseRepository.findAll();
    }

    @Override
    public List<PhoneCase> savePhoneCaseInfo(List<PhoneCase> phoneCase) {
        for (PhoneCase pc: phoneCase) {
            System.out.println(pc.getCaseId() + pc.getQuantity() + pc.getPhoneInfo().getName());
        }
        return phoneCaseRepository.saveAll(phoneCase);
    }
}
