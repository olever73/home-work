package com.telran.dogsowner.dto;


import com.telran.dogsowner.entity.Owner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@AllArgsConstructor
@Data
@Builder
public class DogDTO {
    private Long id;
    private String breed;
    private String nickname;
    private Owner owner;
    private LocalDate registrationDate;


    private LocalDate dateOfBirth;


 ;}
