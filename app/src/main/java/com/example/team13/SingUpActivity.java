package com.example.team13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.Player.Player;

public class SingUpActivity extends AppCompatActivity {

    protected Button SingUpBut,Login;
    protected EditText RegisterName,RegisterEmail,RegisterPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        initViews();

        SingUpBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Player player = new Player(RegisterName.getText().toString(), RegisterEmail.getText().toString(), RegisterPassword.getText().toString());
                Intent intent=new Intent(SingUpActivity.this, MainActivity.class);
                intent.putExtra("Player", player);
                startActivity(intent);
            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void initViews(){

        SingUpBut = findViewById(R.id.SingUpBut);
        Login = findViewById(R.id.Login);
        RegisterName=findViewById(R.id.RegisterName);
        RegisterEmail=findViewById(R.id.RegisterEmail);
        RegisterPassword=findViewById(R.id.RegisterPassword);
    }
}