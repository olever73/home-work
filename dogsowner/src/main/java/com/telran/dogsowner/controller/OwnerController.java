package com.telran.dogsowner.controller;

import com.telran.dogsowner.dto.OwnerDTO;
import com.telran.dogsowner.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping("/owners")
    public void createOwner(@RequestBody OwnerDTO ownerDTO) {
        ownerService.createOwner(ownerDTO);
    }


    @GetMapping("/owners")
    public List<OwnerDTO> getAllOwners() {
        return ownerService.getAllOwners();
    }

    @GetMapping("/owners/{id}")
    public OwnerDTO getOwnerById(@PathVariable("id") Long id) {
        return ownerService.getOwnerById(id);
    }


    @PutMapping("/owners/{ownerId}/dogs/{dogId}")
    public void toggleDogOwner(@PathVariable("ownerId") Long ownerId,
                               @PathVariable("dogId") Long dogId) {
        ownerService.toggleDogOwner(ownerId, dogId);
    }

}
