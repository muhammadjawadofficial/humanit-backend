package se.humanit.sellshells.controller;

import org.springframework.web.bind.annotation.*;
import se.humanit.sellshells.entities.Phone;
import se.humanit.sellshells.service.PhoneService;

import java.util.List;

@RestController
@RequestMapping(value = "/phone")
public class PhoneController {

    private final PhoneService phoneService;

    PhoneController(PhoneService phoneService){
        this.phoneService = phoneService;
    }

    @GetMapping(value = "/get/{id}")
    public List<Phone> getAllPhoneByBrandId(@PathVariable(value = "id") Integer id){
        return phoneService.getAllPhone(id);
    }
}
