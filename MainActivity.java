package com.info.loginsharep;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText,editText2;
    Button button3,button4;
    String file,s,s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharepref = getSharedPreferences(file, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharepref.edit();
                s = editText.getText().toString();
                s1 = editText2.getText().toString();
                editor.putString("name", s);
                editor.putString("name", s1);
                Toast.makeText(MainActivity.this, "Save", Toast.LENGTH_SHORT).show();

                editor.commit();

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String defaultstr = "default text";
                SharedPreferences sharep = getSharedPreferences(file, Context.MODE_PRIVATE);
                String n = sharep.getString("name", defaultstr);


                if (editText.getText().toString().equals(s) && editText2.getText().toString().equals(s1)) {
                    Toast.makeText(MainActivity.this, "rigt user n pwd", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), second.class);
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "wrong user n pasword", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
