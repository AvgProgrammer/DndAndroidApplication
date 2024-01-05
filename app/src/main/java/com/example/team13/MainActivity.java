package com.example.team13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.Player.Player;
import com.example.CharacterSheet.CharacterSheet;
import com.example.Session.Session;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private Button SessionsButton,CharactersButton,QuitButton;
    private Player player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();

        // Check if the Intent has the extra "Player"
        if (intent.hasExtra("Player")) {

            player = (Player) intent.getSerializableExtra("Player");}
            ArrayList<CharacterSheet> Chars=new ArrayList<>();
            ArrayList<Session> Sess=new ArrayList<>();

            initViews();
        CharactersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, CharacterListActivity.class);
                intent.putExtra("CharList", Chars);
                startActivity(intent);
            }
        });
        SessionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, SessionsListActivity.class);
                intent.putExtra("SessList", Sess);
                startActivity(intent);
            }
        });
        QuitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the action to perform on click
                finish(); // This will mimic the default back press action
            }
        });
    }
    private void initViews(){
        SessionsButton = findViewById(R.id.SessionsButton);
        CharactersButton = findViewById(R.id.CharactersButton);
        QuitButton = findViewById(R.id.QuitButton);
    }
}