package se.humanit.sellshells.service;

import se.humanit.sellshells.entities.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> getAllBrands();

    Brand getBrand(Integer id);
}
