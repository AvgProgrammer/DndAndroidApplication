package com.example.team13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CharacterListActivity extends AppCompatActivity {

    private Button AddButton,BackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_list);

        initViews();
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CharacterListActivity.this, CharacterSheetActivity.class);
                startActivity(intent);
            }
        });
        Button BackButton = findViewById(R.id.BackButton);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the action to perform on click
                finish(); // This will mimic the default back press action
            }
        });
    }

    private void initViews(){
        AddButton =findViewById(R.id.AddButton);
        BackButton=findViewById(R.id.BackButton);
    }
}