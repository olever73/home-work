package de.telran.persons_rest.service;


import de.telran.persons_rest.dto.AddressDto;
import de.telran.persons_rest.model.Address;
import de.telran.persons_rest.model.Person;
import de.telran.persons_rest.dto.PhoneNumberDto;

import de.telran.persons_rest.model.PhoneNumber;
import de.telran.persons_rest.repo.PersonRepo;
import de.telran.persons_rest.repo.PhoneNumberRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PhoneNumberService {
    private final PhoneNumberRepo phoneNumberRepo;
    private final PersonRepo personRepo;

    public PhoneNumberService(PhoneNumberRepo phoneNumberRepo, PersonRepo personRepo) {
        this.phoneNumberRepo = phoneNumberRepo;
        this.personRepo = personRepo;
    }
    public PhoneNumberDto get(Integer id) {
        return phoneNumberRepo.findById(id)
                .map(this::mapPhoneNumberToDto)
                .orElseThrow();
    }



    private PhoneNumberDto mapPhoneNumberToDto(PhoneNumber phoneNumber) {
        return new PhoneNumberDto(
                phoneNumber.getId(),
                phoneNumber.getNumber(),
                phoneNumber.getCountryCode(),
                phoneNumber.getPerson().getId()
        );
    }

    public PhoneNumberDto create(PhoneNumberDto phoneNumberDto) {
        Person person = personRepo.findById(phoneNumberDto.getPersonId()).orElseThrow();

        PhoneNumber phone = new PhoneNumber(

                phoneNumberDto.number,
                phoneNumberDto.countryCode,
                person
        );
        return mapPhoneNumberToDto(phoneNumberRepo.save(phone));
    }

    public void edit(PhoneNumberDto phoneNumberDto) {
        PhoneNumber phoneNumber = phoneNumberRepo.findById(phoneNumberDto.id).orElseThrow();

        phoneNumber.setNumber(phoneNumberDto.number);
        phoneNumber.setCountryCode(phoneNumberDto.countryCode);

        phoneNumberRepo.save(phoneNumber);
    }

    public void remove(int id) {
        phoneNumberRepo.deleteById(id);
    }



    public List<PhoneNumberDto> getAllByPersonId(Optional<Integer> personId) {
        List<PhoneNumber> phoneNumbers;
        if (personId.isPresent())
            phoneNumbers = phoneNumberRepo.returnAllByPersonId(personId.get());
        else
            phoneNumbers = phoneNumberRepo.findAll();

        return phoneNumbers.stream()
                .map(this::mapPhoneNumberToDto)
                .collect(Collectors.toList());
    }



}
