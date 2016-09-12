package com.example.androidstudio.gawaranl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnlogin;
        final EditText etUser, etPass;


        etUser = (EditText)findViewById(R.id.txtUser);
        etPass = (EditText)findViewById(R.id.txtPass);
        btnlogin = (Button)findViewById(R.id.btnlogin);
        final String user = etUser.getText().toString(); final String pass = etPass.getText().toString();


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Pattern.compile("admin").matcher(etUser.getText().toString()).matches() && Pattern.compile("test").matcher(etPass.getText().toString()).matches()){
                    Intent intent = new Intent(MainActivity.this,activity.class );
                    startActivity(intent);
                    //for disposing
                    finish();
                }else Toast.makeText(getBaseContext(),"Wrong Username or Password", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
