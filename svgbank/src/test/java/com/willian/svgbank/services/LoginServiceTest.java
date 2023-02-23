package com.willian.svgbank.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.willian.dto.LoginDto;
import com.willian.model.User;
import com.willian.repository.IUserRepository;
import com.willian.service.LoginService;
import com.willian.svgbank.inMemoryUserRepository;
import com.willian.svgbank.services.util.PasswordEncoderTest;
import com.willian.utils.IPasswordEncoder;

public class LoginServiceTest {

    @Test
    public void should_be_able_to_login(){
        IUserRepository userRepository = new inMemoryUserRepository();
        IPasswordEncoder passwordEncoder = new PasswordEncoderTest();
        LoginService loginService = new LoginService(userRepository, passwordEncoder);

        User newUser = new User();
        newUser.setEmail("willian@willain.com");
        newUser.setName("willian");
        newUser.setPassword("12345");

        userRepository.save(newUser);

        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("willian@willain.com");
        loginDto.setPassword("12345");


        User user = loginService.execute(loginDto);

        assertNotNull(user.getId());
    }

    @Test
    public void should_not_be_able_to_login(){
        IUserRepository userRepository = new inMemoryUserRepository();
        IPasswordEncoder passwordEncoder = new PasswordEncoderTest();
        LoginService loginService = new LoginService(userRepository, passwordEncoder);

        User newUser = new User();
        newUser.setEmail("willian@willain.com");
        newUser.setName("willian");
        newUser.setPassword("123456");

        userRepository.save(newUser);

        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("willian@willain.com");
        loginDto.setPassword("12345");


        User user = loginService.execute(loginDto);

        assertNull(user);
    }
}
