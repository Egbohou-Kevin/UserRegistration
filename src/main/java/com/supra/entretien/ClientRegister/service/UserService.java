package com.supra.entretien.ClientRegister.service;

import com.supra.entretien.ClientRegister.entity.User;
import com.supra.entretien.ClientRegister.exception.RessourceNotFoundException;
import com.supra.entretien.ClientRegister.utils.DtoUtils;
import com.supra.entretien.ClientRegister.dto.UserRegistrationDto;
import com.supra.entretien.ClientRegister.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.rmi.server.UID;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Create the user in database.
     *
     * @param user The user to be created.
     * @return the user created.
     */
    public UserRegistrationDto addUser(UserRegistrationDto user) {
        return  DtoUtils.convertUserToDto(userRepository.save(DtoUtils.convertUserToEntity(user)));
    }

    /**
     * find the user in database.
     *
     * @param idUser The user id to be found.
     * @return the user founded.
     */
    public UserRegistrationDto findUser(UUID idUser) {
        Optional<User> user =  userRepository.findById(idUser);
        if(user.isEmpty())
            throw new RessourceNotFoundException(String.format("user %s does not exists", idUser));
        return  DtoUtils.convertUserToDto(user.get());
    }

}
