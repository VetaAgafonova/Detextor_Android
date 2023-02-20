package com.example.detextor_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class OutText extends Activity{
    private final static String FILENAME = "sample.txt"; // имя файла
    private EditText outText;
    Button btSave, btFav, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        outText = findViewById(R.id.editText);
        btSave=findViewById(R.id.bt_save);
        btFav=findViewById(R.id.bt_favourites);
        btnBack=findViewById(R.id.bt_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(OutText.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

   public void write(View view){
        String myText = outText.getText().toString();
        try{
            FileOutputStream fileOutputStream=openFileOutput("text.txt", MODE_PRIVATE);
            fileOutputStream.write(myText.getBytes());
            fileOutputStream.close();
            Toast.makeText(OutText.this,"Saved",Toast.LENGTH_SHORT).show();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }


   }
}
