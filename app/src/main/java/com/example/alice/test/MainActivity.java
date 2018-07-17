package com.example.alice.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.alice.test.service.LoginService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void readFile(View view){
        File file = new File("data/data/com.example.alice.test/private.txt");
        try{
            FileInputStream  fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String result = br.readLine();
            br.close();
            String[] result1 = result.split("##");
            boolean flag = LoginService.saveUserInfo(this,result1[0],result1[1]);
            if (flag){
                Toast.makeText(this,"转存信息成功...",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"转存信息失败...",Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this,"读取文件失败...",Toast.LENGTH_SHORT).show();
        }
    }
    public void writeFile(View view){
        File file = new File("data/data/com.example.alice.test/private.txt");
        try{
            FileOutputStream fos = new FileOutputStream(file);
            fos.write("qqq##123".getBytes());
            fos.flush();
            fos.close();
            Toast.makeText(this,"写私有文件成功...",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this,"写私有文件失败...",Toast.LENGTH_SHORT).show();
        }
    }
}
