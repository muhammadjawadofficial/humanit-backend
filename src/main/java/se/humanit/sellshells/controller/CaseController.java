package se.humanit.sellshells.controller;

import org.springframework.web.bind.annotation.*;
import se.humanit.sellshells.entities.CaseInfo;
import se.humanit.sellshells.entities.PhoneCase;
import se.humanit.sellshells.service.CaseService;
import se.humanit.sellshells.service.PhoneCaseService;

import java.util.List;

@RestController
@RequestMapping(value = "case")
public class CaseController {

    private final CaseService caseService;
    private final PhoneCaseService phoneCaseService;

    CaseController(CaseService caseService, PhoneCaseService phoneCaseService){
        this.caseService = caseService;
        this.phoneCaseService = phoneCaseService;
    }

    @GetMapping(value = "/get/all")
    public List<CaseInfo> getAllCases(){
        return caseService.getAllCases();
    }

    @GetMapping(value = "/get/{caseId}")
    public CaseInfo getCasesById(@PathVariable(value = "caseId") Integer caseId){
        return caseService.getCaseById(caseId);
    }

    @GetMapping(value = "/get/by-phone-id/{phoneId}")
    public List<CaseInfo> getCasesByPhoneId(@PathVariable(value = "phoneId") Integer phoneId){
        return caseService.getPhoneCases(phoneId);
    }

    @PostMapping(value = "/save")
    public CaseInfo saveCase(@RequestBody CaseInfo caseInfo){
        List<PhoneCase> phoneCaseList = caseInfo.getPhoneCases();
        caseInfo.setPhoneCases(null);
        CaseInfo savedInfo = caseService.saveCaseInfo(caseInfo);

        for (PhoneCase pc: phoneCaseList) {
            pc.setCaseId(savedInfo.getId());
        }
        phoneCaseService.savePhoneCaseInfo(phoneCaseList);
        savedInfo.setPhoneCases(phoneCaseList);
        return savedInfo;
    }
}
