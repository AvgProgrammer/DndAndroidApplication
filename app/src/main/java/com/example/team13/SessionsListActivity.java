package com.example.team13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.CharacterSheet.CharacterSheet;
import com.example.Session.Session;

import java.util.ArrayList;

public class SessionsListActivity extends AppCompatActivity {

    protected Button Return;
    private ArrayList<Session> SessList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessions_list);

        Intent intent = getIntent();

        if(intent.hasExtra("SessList")){
            SessList = (ArrayList) intent.getSerializableExtra("SessList");
        }

        initViews();

        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void initViews(){
        Return =findViewById(R.id.Return);
    }
}