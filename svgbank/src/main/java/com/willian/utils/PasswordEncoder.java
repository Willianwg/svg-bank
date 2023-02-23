package com.willian.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoder implements IPasswordEncoder {

    BCryptPasswordEncoder bcrypt;

    public PasswordEncoder(){
        this.bcrypt = new BCryptPasswordEncoder();
    }

    @Override
    public String encode(String password) {
       return bcrypt.encode(password);
    }

    @Override
    public boolean compare(String raw, String encoded) {
        return bcrypt.matches(raw, encoded);
    }
    
}
