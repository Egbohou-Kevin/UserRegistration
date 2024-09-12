package com.supra.entretien.ClientRegister.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * Represent the user in our System.
 * Contains User information.
 */

@Document(collection = "users")
public class User {
	@Id
	private UUID id;
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate birthDate;
	private Address address;
	private Gender gender;

	public void setId(UUID id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	public UUID getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public Address getAddress() {
		return address;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(birthDate, user.birthDate) && Objects.equals(address, user.address) && gender == user.gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, email, birthDate, address, gender);
	}
}
