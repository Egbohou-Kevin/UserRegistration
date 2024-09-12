package com.supra.entretien.ClientRegister.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.supra.entretien.ClientRegister.entity.Gender;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class UserRegistrationDto {
    @NotBlank(message = "First Name is required")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    private String LastName;

    @Email(message = "Valid email is required")
    @NotBlank(message = "Email is required")
    private String email;

    @NotNull(message = "date is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @NotNull(message = "Address is required")
    private AddressDto address;

    private Gender gender;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String firstName, String lastName, String email, LocalDate birthDate, AddressDto address, Gender gender) {
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.address = address;
        this.gender = gender;
    }

    public @NotBlank(message = "First Name is required") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "First Name is required") String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank(message = "Last Name is required") String getLastName() {
        return LastName;
    }

    public void setLastName(@NotBlank(message = "Last Name is required") String lastName) {
        LastName = lastName;
    }

    public @Email(message = "Valid email is required") @NotBlank(message = "Email is required") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Valid email is required") @NotBlank(message = "Email is required") String email) {
        this.email = email;
    }

    public @NotNull(message = "date is required") LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@NotNull(message = "date is required") LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public @NotNull(message = "Address is required") AddressDto getAddress() {
        return address;
    }

    public void setAddress(@NotNull(message = "Address is required") AddressDto address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}
