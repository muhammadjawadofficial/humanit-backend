package se.humanit.sellshells.service.implementation;

import org.springframework.stereotype.Service;
import se.humanit.sellshells.entities.Phone;
import se.humanit.sellshells.repository.PhoneRepository;
import se.humanit.sellshells.service.PhoneService;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;

    PhoneServiceImpl(PhoneRepository phoneRepository){
        this.phoneRepository = phoneRepository;
    }
    @Override
    public List<Phone> getAllPhone(Integer brandId) {
        return phoneRepository.findByBrandId(brandId);
    }
}
