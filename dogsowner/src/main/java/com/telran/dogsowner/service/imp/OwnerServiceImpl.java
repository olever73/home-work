package com.telran.dogsowner.service.imp;

import com.telran.dogsowner.dto.OwnerDTO;

import com.telran.dogsowner.entity.Dog;
import com.telran.dogsowner.entity.Owner;
import com.telran.dogsowner.repository.DogRepository;
import com.telran.dogsowner.repository.OwnerRepository;
import com.telran.dogsowner.service.OwnerService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private DogRepository dogRepository;

    @Override
    public void createOwner(OwnerDTO ownerDTO) {
        Owner owner = Owner.builder()
                .firstName(ownerDTO.getFirstName())
                .lastName(ownerDTO.getLastName())
                .dateOfBirth(ownerDTO.getDateOfBirth())
                .build();

        //  save        +     update
        // id==null         id != null
        ownerRepository.save(owner);
//        owner1.getId(); // <-- ID from database

        // 1. ID - numeric
        // 2. ID - is incremented and assigned BY DATABASE ONLY
        // 2.1. SQL query -> ID, primary key autoincrement
    }


    @Override
    public List<OwnerDTO> getAllOwners() {

        return ownerRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

    }

    @Override
    public OwnerDTO getOwnerById(Long id) {
        return ownerRepository
                .findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void toggleDogOwner(Long ownerId /*17*/, Long dogId) {
        Owner owner = ownerRepository
                .findById(ownerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Dog dog = dogRepository // owner = 15
                .findById(dogId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        // Guard Clause
        if (dog.getOwner() != null && !dog.getOwner().getId().equals(ownerId)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

        // checks
        // --------------------------------------------------
        // all ok, working as usual

        // toggle -> 17
        // YES owner -> dog.owner = null
        // NO  owner -> dog.owner = 17

        // dog.ownerId = 15

        dog.setOwner(
                dog.getOwner() == null ? owner : null
        );

        dog.setRegistrationDate(
                dog.getOwner() == null ? LocalDate.now() : null
        );

//        if (dog.getOwner() == null) {
//            dog.setOwner(owner);
//            dog.setRegistrationDate(LocalDate.now());
//        } else {
//            dog.setOwner(null);
//            dog.setRegistrationDate(null);
//        }

        dogRepository.save(dog);

    }

    private OwnerDTO convertToDTO(Owner owner) {
        return OwnerDTO.builder()
                .id(owner.getId())
                .firstName(owner.getFirstName())
                .lastName(owner.getLastName())
                .dateOfBirth(owner.getDateOfBirth())
                .build();
    }


    private void abc(Long a, String b, Double c) {
        // Guard Clause

        // check a
        // check b
        // check a and b

        // check c
        // check b and c

        // -----------------------------------
        // we trust our data from here!!!

    }

}
