package se.humanit.sellshells.controller;

import org.springframework.web.bind.annotation.*;
import se.humanit.sellshells.entities.Brand;
import se.humanit.sellshells.service.BrandService;

import java.util.List;

@RestController
@RequestMapping(value = "/brand")
public class BrandController {

    private final BrandService brandService;

    BrandController(BrandService brandService){
        this.brandService = brandService;
    }

    @GetMapping(value = "/get/all")
    public List<Brand> getAllBrands(){
        return brandService.getAllBrands();
    }

    @GetMapping(value = "/get/{id}")
    public Brand getBrand(@PathVariable(value = "id") Integer id){
        return brandService.getBrand(id);
    }
}
