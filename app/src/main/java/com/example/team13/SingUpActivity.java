package com.example.team13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.Player.Player;

public class SingUpActivity extends AppCompatActivity {

    protected Button SingUpBut,Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        initViews();

        SingUpBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Player player = new Player("PlayerName", "email@example.com", "password123");
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
    }
}