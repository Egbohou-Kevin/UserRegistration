package com.supra.entretien.ClientRegister;

import com.supra.entretien.ClientRegister.dto.AddressDto;
import com.supra.entretien.ClientRegister.exception.BadRequestException;
import com.supra.entretien.ClientRegister.utils.DtoUtils;
import com.supra.entretien.ClientRegister.dto.UserRegistrationDto;
import com.supra.entretien.ClientRegister.entity.Gender;
import com.supra.entretien.ClientRegister.entity.User;
import com.supra.entretien.ClientRegister.repository.UserRepository;
import com.supra.entretien.ClientRegister.service.UserService;
import com.supra.entretien.ClientRegister.utils.UserUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUser_Success() {
        // Arrange
        UserRegistrationDto userDTO = new UserRegistrationDto("Kevin","Egbohou","kev@gmail.com", LocalDate.of(1999,06,03),  new AddressDto("73","avenue simone","nice","06200","fr",null),Gender.MAN);
        User user = DtoUtils.convertUserToEntity(userDTO);
        when(userRepository.save(any(User.class))).thenReturn(user);

        // Act
        UserRegistrationDto result = userService.addUser(userDTO);

        // Assert
        assertNotNull(result);
        assertEquals("Kevin", result.getFirstName());
        assertEquals("Egbohou", result.getLastName());
        assertEquals("kev@gmail.com", result.getEmail());
        assertEquals(LocalDate.of(1999,06,03),result.getBirthDate());
        assertEquals(new AddressDto("73","avenue simone","nice","06200","fr",null), result.getAddress());
        assertEquals(Gender.MAN,result.getGender());
        verify(userRepository, times(1)).save(any(User.class));
    }

}