package com.willian.utils;

public interface IPasswordEncoder {
    public String encode(String password);
    public boolean compare(String raw, String encoded);
}
