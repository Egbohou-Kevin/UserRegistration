package com.supra.entretien.ClientRegister.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class AddressDto implements Serializable {
    @NotBlank(message = "Street NUmber is required")
    private String streetNumber;

    @NotBlank(message = "Street NUmber is required")
    private String streetName;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "Postal code is required")
    private String postalCode;

    @NotBlank(message = "Country code is required")
    private String countryCode;

    private String other;

    public AddressDto(String streetNumber, String streetName, String city, String postalCode, String countryCode, String other) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
        this.countryCode = countryCode;
        this.other = other;
    }

    public AddressDto() {
    }

    public @NotBlank(message = "Street NUmber is required") String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(@NotBlank(message = "Street NUmber is required") String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public @NotBlank(message = "Street NUmber is required") String getStreetName() {
        return streetName;
    }

    public void setStreetName(@NotBlank(message = "Street NUmber is required") String streetName) {
        this.streetName = streetName;
    }

    public @NotBlank(message = "City is required") String getCity() {
        return city;
    }

    public void setCity(@NotBlank(message = "City is required") String city) {
        this.city = city;
    }

    public @NotBlank(message = "Postal code is required") String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(@NotBlank(message = "Postal code is required") String postalCode) {
        this.postalCode = postalCode;
    }

    public @NotBlank(message = "Country code is required") String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(@NotBlank(message = "Country code is required") String countryCode) {
        this.countryCode = countryCode;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
