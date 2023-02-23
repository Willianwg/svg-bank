package com.willian.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.willian.dto.CreateUserDto;
import com.willian.dto.LoginDto;
import com.willian.model.User;
import com.willian.repository.UserRepository;
import com.willian.service.FindUserService;
import com.willian.service.ListAllUsersService;
import com.willian.service.LoginService;
import com.willian.service.SignUpService;
import com.willian.utils.PasswordEncoder;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class UserController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    
    @GetMapping
    public List<User> list(){
        ListAllUsersService listAllUsersService = new ListAllUsersService(userRepository);
        return listAllUsersService.execute();
    }

    @GetMapping("/{id}")
    public User findUser(@PathVariable("id") Long id){
        FindUserService findUserService = new FindUserService(userRepository);
        return findUserService.execute(id);
    }

    @PostMapping(path = "create")
    public void signUp(@RequestBody CreateUserDto user){
        SignUpService signUpService = new SignUpService(userRepository);
        signUpService.execute(user);
    }

    @PostMapping(path = "login")
    public User login(@RequestBody LoginDto loginData ){
        LoginService loginService = new LoginService(userRepository, passwordEncoder);
        User user = loginService.execute(loginData);
        user.setPassword(null);

        return user;
    }

}
