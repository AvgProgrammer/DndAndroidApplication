package com.example.team13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.CharacterSheet.CharacterSheet;


public class CharacterSheetActivity extends AppCompatActivity {

    protected Button ReturnButton,AddCharacter;
    protected EditText CharacterNameText,DescriptionText,StrengthText,DexterityText,IntelligenceText,WisdomText,CharismaText,ConstitutionText;
    protected RadioButton male,female,NonBinary,Bard,Fighter,Wizard,Dwarf,Elf,Human;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_sheet);

        CharacterSheet characterSheet=new CharacterSheet();

        initViews();

        Button addCharacter=findViewById(R.id.AddCharacter);
        addCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                characterSheet.setName(CharacterNameText.getText().toString());
                characterSheet.setDescription(DescriptionText.getText().toString());
                characterSheet.setStrength(Integer.parseInt(StrengthText.getText().toString()));
                characterSheet.setDexterity(Integer.parseInt(DexterityText.getText().toString()));
                characterSheet.setWisdom(Integer.parseInt(WisdomText.getText().toString()));
                characterSheet.setIntelligence(Integer.parseInt(IntelligenceText.getText().toString()));
                characterSheet.setCharisma(Integer.parseInt(CharismaText.getText().toString()));
                characterSheet.setConstitution(Integer.parseInt(ConstitutionText.getText().toString()));


            }
        });

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
        AddCharacter=findViewById(R.id.AddCharacter);

        CharacterNameText=findViewById(R.id.CharacterNameText);
        DescriptionText=findViewById(R.id.DescriptionText);
        StrengthText=findViewById(R.id.StrengthText);
        DexterityText=findViewById(R.id.DexterityText);
        IntelligenceText=findViewById(R.id.IntelligenceText);
        WisdomText=findViewById(R.id.WisdomText);
        CharismaText=findViewById(R.id.CharismaText);
        ConstitutionText=findViewById(R.id.ConstitutionText);

        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        NonBinary=findViewById(R.id.NonBinary);

        Bard=findViewById(R.id.Bard);
        Fighter=findViewById(R.id.Fighter);
        Wizard=findViewById(R.id.Wizard);

        Dwarf=findViewById(R.id.Dwarf);
        Elf=findViewById(R.id.Elf);
        Human=findViewById(R.id.Human);
    }
}