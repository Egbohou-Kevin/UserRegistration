package com.supra.entretien.ClientRegister.utils;

import com.supra.entretien.ClientRegister.dto.UserRegistrationDto;
import com.supra.entretien.ClientRegister.exception.BadRequestException;

import java.time.LocalDate;
import java.time.Period;

public class UserUtils {
    public static void isUserInfoValid(UserRegistrationDto userDto){
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(userDto.getBirthDate(), currentDate);
        int age = period.getYears();
        if (age < 18)
            throw new BadRequestException(String.format("age %s must be greater than 18", age));
        if(!userDto.getAddress().getCountryCode().equals("fr"))
            throw new BadRequestException(String.format("your country %s is not allowed",userDto.getAddress().getCountryCode()));
    }
}
