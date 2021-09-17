package se.humanit.sellshells.service;

import se.humanit.sellshells.entities.PhoneCase;

import java.util.List;

public interface PhoneCaseService {
    List<PhoneCase> getPhoneCases();

    List<PhoneCase> savePhoneCaseInfo(List<PhoneCase> phoneCase);
}
