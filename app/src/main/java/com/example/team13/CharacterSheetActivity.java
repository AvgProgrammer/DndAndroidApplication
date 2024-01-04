package com.example.team13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CharacterSheetActivity extends AppCompatActivity {

    protected Button ReturnButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_sheet);

        initViews();

        Button returnButton = findViewById(R.id.ReturnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the action to perform on click
                finish(); // This will mimic the default back press action
            }
        });

    }
    private void initViews(){
        ReturnButton = findViewById(R.id.ReturnButton);
    }
}