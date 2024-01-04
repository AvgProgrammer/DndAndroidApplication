package com.example.team13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.Player.Player;

public class LoginActivity extends AppCompatActivity {

    protected Button SingIn,SingUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
        SingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Player player = new Player("PlayerName", "email@example.com", "password123");
                Intent intent=new Intent(LoginActivity.this, SingUpActivity.class);
                intent.putExtra("Player", player);
                startActivity(intent);
            }
        });
    }
    private void initViews(){
        SingIn = findViewById(R.id.SingIn);
        SingUp = findViewById(R.id.SingUp);
    }
}