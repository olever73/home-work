package com.telran.dogsowner.service.imp;

import com.telran.dogsowner.dto.DogDTO;
import com.telran.dogsowner.entity.Dog;
import com.telran.dogsowner.repository.DogRepository;
import com.telran.dogsowner.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    private DogRepository dogRepository;

    @Override
    public void createDog(DogDTO dogDTO) {
        Dog dog = Dog.builder()
                .nickname(dogDTO.getNickname())
                .breed(dogDTO.getBreed())
                .registrationDate(null)
                .build();

        dogRepository.save(dog);
    }

    @Override
    public void edit(DogDTO dogDTO) {
        Dog dog = dogRepository.findById(dogDTO.getId()).orElseThrow();

        dog.setBreed(dogDTO.getBreed());
        dog.setNickname(dogDTO.getNickname());
        dog.setOwner(dogDTO.getOwner());
        dog.setRegistrationDate(dogDTO.getRegistrationDate());

        dogRepository.save(dog);
    }

    @Override
    public DogDTO getDogById(Long id) {
        Dog dog = dogRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return DogDTO.builder()
                .id(dog.getId())
                .breed(dog.getBreed())
                .nickname(dog.getNickname())
                .owner(dog.getOwner())
                .dateOfBirth(dog.getDateOfBirth())
                .build();


    }


}



