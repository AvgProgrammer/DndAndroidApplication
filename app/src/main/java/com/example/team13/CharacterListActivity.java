package com.example.team13;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResult;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.CharacterSheet.CharacterSheet;
import com.example.Player.Player;

import java.util.ArrayList;

public class CharacterListActivity extends AppCompatActivity {
    private Button AddButton,BackButton;
    protected RecyclerView CharactersList;
    private ArrayList<CharacterSheet> CharList;

    private CharacterRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_list);

        Intent intent = getIntent();

        if(intent.hasExtra("CharList")){
            CharList = (ArrayList) intent.getSerializableExtra("CharList");
        }
        initViews();


        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CharacterListActivity.this, CharacterSheetActivity.class);
                mStartForResult.launch(intent);
            }
        });
        adapter = new CharacterRecViewAdapter();
        adapter.setCharacters(CharList);

        CharactersList.setAdapter(adapter);
        CharactersList.setLayoutManager(new LinearLayoutManager(this));
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
        CharactersList=findViewById(R.id.CharactersList);
    }
    private ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            // Retrieve the CharacterSheet object
                            CharacterSheet newCharacter = (CharacterSheet) data.getSerializableExtra("newCharacter");

                            CharList.add(newCharacter);
                            adapter.notifyDataSetChanged();
                            // Add the new character to the ArrayList
                        }
                    }
                }
            });
}