package com.supra.entretien.ClientRegister.utils;

import com.supra.entretien.ClientRegister.dto.AddressDto;
import com.supra.entretien.ClientRegister.dto.UserRegistrationDto;
import com.supra.entretien.ClientRegister.entity.Address;
import com.supra.entretien.ClientRegister.entity.User;

public abstract class DtoUtils {
    /**
     * Convert user entity to user dto.
     *
     * @param user  user entity to be converted.
     * @return the user dto.
     */
    public static UserRegistrationDto convertUserToDto(User user){
        UserRegistrationDto userDto = new UserRegistrationDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setBirthDate(user.getBirthDate());
        userDto.setGender(user.getGender());
        userDto.setAddress(convertAddressToDto(user.getAddress()));
        return userDto;
    }

    /**
     * Convert user dto to user entity.
     *
     * @param userDto  user dto to be converted.
     * @return the user entity.
     */
    public static User convertUserToEntity(UserRegistrationDto userDto){
        User userEntity = new User();
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setBirthDate(userDto.getBirthDate());
        userEntity.setGender(userDto.getGender());
        userEntity.setAddress(convertAddressToEntity(userDto.getAddress()));
        return userEntity;
    }

    /**
     * Convert address dto to address entity.
     *
     * @param addressDto  address dto to be converted.
     * @return the address entity.
     */
    private static Address convertAddressToEntity(AddressDto addressDto){
        Address address = new Address();
        address.setCity(addressDto.getCity());
        address.setOther(addressDto.getOther());
        address.setCountryCode(addressDto.getCountryCode());
        address.setPostalCode(addressDto.getPostalCode());
        address.setStreetNumber(addressDto.getStreetNumber());
        address.setStreetName(addressDto.getStreetName());
        return  address;
    }

    /**
     * Convert address entity to address dto.
     *
     * @param address  address entity to be converted.
     * @return the address dto.
     */
    private static AddressDto convertAddressToDto(Address address){
        AddressDto addressDto = new AddressDto();
        addressDto.setCity(address.getCity());
        addressDto.setOther(address.getOther());
        addressDto.setCountryCode(address.getCountryCode());
        addressDto.setPostalCode(address.getPostalCode());
        addressDto.setStreetNumber(address.getStreetNumber());
        addressDto.setStreetName(address.getStreetName());
        return addressDto;
    }
}
