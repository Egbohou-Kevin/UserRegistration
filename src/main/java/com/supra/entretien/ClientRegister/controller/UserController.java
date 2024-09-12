package com.supra.entretien.ClientRegister.controller;

import com.supra.entretien.ClientRegister.dto.UserRegistrationDto;
import com.supra.entretien.ClientRegister.entity.Gender;
import com.supra.entretien.ClientRegister.exception.BadRequestException;
import com.supra.entretien.ClientRegister.service.UserService;
import com.supra.entretien.ClientRegister.utils.UserUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<UserRegistrationDto> registerUser(
			@RequestBody @Valid UserRegistrationDto userDto,
			@RequestParam(name = "gender", defaultValue = "OTHER", required = false) String gender) {
		UserUtils.isUserInfoValid(userDto);
		try{
			userDto.setGender(Gender.valueOf(gender));
		}catch (IllegalArgumentException exception){
			throw new BadRequestException(String.format("gender %s does not exists", gender));
		}
		return ResponseEntity.ok(userService.addUser(userDto));
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserRegistrationDto> getUserById(@PathVariable String userId) {
		UUID id =  UUID.fromString(userId);
		UserRegistrationDto user = userService.findUser(id);
		return ResponseEntity.ok(user);
	}

}
