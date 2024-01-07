package com.example.team13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.Player.Player;

public class LoginActivity extends AppCompatActivity {

    protected Button SingIn,SingUp;
    protected EditText FindEmail,FindPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
        String email=FindEmail.getText().toString();
        String pass=FindPassword.getText().toString();
        SingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, SingUpActivity.class);
                startActivity(intent);
            }
        });
        SingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Player player = new Player("PlayerName", "email@example.com", "password123");
                Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("Player", player);
                startActivity(intent);
            }
        });
    }

    /**
     * Initialize Values
     */
    private void initViews(){
        SingIn = findViewById(R.id.SingIn);
        SingUp = findViewById(R.id.SingUp);
        FindEmail= findViewById(R.id.RegisterName);
        FindPassword= findViewById(R.id.RegisterPassword);
    }
}