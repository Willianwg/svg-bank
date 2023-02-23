package com.willian.svgbank.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.willian.dto.CreateUserDto;
import com.willian.model.User;
import com.willian.repository.IUserRepository;
import com.willian.service.SignUpService;
import com.willian.svgbank.repositories.inMemoryUserRepository;

class SignUpServiceTest {

	@Test
	public void should_be_able_to_create_a_user() {
		IUserRepository userRespository = new inMemoryUserRepository();
		SignUpService signInService = new SignUpService(userRespository);

		CreateUserDto userDto = new CreateUserDto();
		userDto.setEmail("willian@gami.com");
		userDto.setName("willain");
		userDto.setPassword("12345");

		User createdUser = signInService.execute(userDto);

		assertNotNull(createdUser.getId());
	}

}
