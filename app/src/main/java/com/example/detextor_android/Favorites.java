package com.example.detextor_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Favorites extends AppCompatActivity {
    int n = 3, num;
    TextView tv1, tv2, tv3;
    String favString, nameString;
    //String[] favStorage =new String[n];
    TextView[] tv = new TextView[n];
    SharedPreferences[] sp = new SharedPreferences[n];
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        tv[0]= findViewById(R.id.textview1);
        tv[1]= findViewById(R.id.textview2);
        tv[2]= findViewById(R.id.textview3);
        SharedPreferences preferences = getSharedPreferences("fav", MODE_PRIVATE);
        favString = preferences.getString("text","");
        num = preferences.getInt("n", 0);
        nameString = "fav"+num%3;
        sp[num%3] = getSharedPreferences(nameString, MODE_PRIVATE);
        editor = sp[num%3].edit();
        editor.putString("text",favString).apply();
        for(int i = 0; i<n;i++){
            nameString = "fav"+i;
            sp[i] = getSharedPreferences(nameString, MODE_PRIVATE);
            if(sp[i].getString("text","")==null) continue;
            tv[i].setText(sp[i].getString("text",""));}


        //System.out.println(num);

        findViewById(R.id.bt_back_fav).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Favorites.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}