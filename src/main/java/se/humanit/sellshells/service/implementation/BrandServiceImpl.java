package se.humanit.sellshells.service.implementation;

import org.springframework.stereotype.Service;
import se.humanit.sellshells.entities.Brand;
import se.humanit.sellshells.repository.BrandRepository;
import se.humanit.sellshells.service.BrandService;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    BrandServiceImpl(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getBrand(Integer id) {
        return brandRepository.findById(id).orElse(null);
    }
}
