package se.humanit.sellshells.service;

import se.humanit.sellshells.entities.Phone;

import java.util.List;

public interface PhoneService {
    List<Phone> getAllPhone(Integer brandId);
}
