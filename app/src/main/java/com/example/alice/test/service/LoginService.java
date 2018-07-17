package com.example.alice.test.service;

import android.annotation.SuppressLint;
import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;

public class LoginService {
    public static boolean saveUserInfo(Context context, String username, String password){
        try{
            @SuppressLint("SdCardPath") File file = new File("/sdcard/info.txt");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write((username + "##" + password).getBytes());
            fos.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
