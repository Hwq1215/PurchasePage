package com.example.purchasepage.component;

import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}

