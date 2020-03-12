package com.example.spring_first.service;

import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class HashService {
    public String calculateHash(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        try {
            md.update(password.getBytes());
            byte[] digestUser = md.digest();
            return DatatypeConverter.printHexBinary(digestUser).toUpperCase();
        }
        catch (NullPointerException e){
            System.out.println("Password has not calculated " + e);
            return "";
        }
    }
}
