package com.willian.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.willian.dto.CreateUserDto;
import com.willian.model.User;
import com.willian.service.FindUserService;
import com.willian.service.ListAllUsersService;
import com.willian.service.SignInService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class UserController {
    private SignInService signInService;
    private ListAllUsersService listAllUsersService;
    private FindUserService findUserService;
    
    @GetMapping
    public List<User> list(){
        return listAllUsersService.execute();
    }

    @GetMapping("/{id}")
    public User findUser(@PathVariable("id") Long id){
        return findUserService.execute(id);
    }

    @PostMapping(path = "create")
    public void signIn(@RequestBody CreateUserDto user){
        signInService.execute(user);
    }

}
