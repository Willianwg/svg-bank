package com.willian.svgbank.services.util;

import com.willian.utils.IPasswordEncoder;

public class PasswordEncoderTest implements IPasswordEncoder {

    @Override
    public String encode(String password) {
        return password;
    }

    @Override
    public boolean compare(String raw, String encoded) {
        if(raw == encoded){
            return true;
        }

        return false;
    }
    
}
