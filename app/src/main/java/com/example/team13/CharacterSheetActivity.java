package com.example.team13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.CharacterSheet.CharacterSheet;
import com.example.CharacterSheet.DnDClass;
import com.example.CharacterSheet.Race;


public class CharacterSheetActivity extends AppCompatActivity {

    protected Button ReturnButton,AddCharacter;
    protected EditText CharacterNameText,DescriptionText,StrengthText,DexterityText,IntelligenceText,WisdomText,CharismaText,ConstitutionText;
    protected RadioGroup rgGender,rgRace,rgClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_sheet);

        initViews();

        Button addCharacter=findViewById(R.id.AddCharacter);
        addCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CharacterSheet characterSheet=new CharacterSheet();

                characterSheet.setName(CharacterNameText.getText().toString());
                characterSheet.setDescription(DescriptionText.getText().toString());

                characterSheet.setStrength(Integer.parseInt(StrengthText.getText().toString()));
                characterSheet.setDexterity(Integer.parseInt(DexterityText.getText().toString()));
                characterSheet.setWisdom(Integer.parseInt(WisdomText.getText().toString()));
                characterSheet.setIntelligence(Integer.parseInt(IntelligenceText.getText().toString()));
                characterSheet.setCharisma(Integer.parseInt(CharismaText.getText().toString()));
                characterSheet.setConstitution(Integer.parseInt(ConstitutionText.getText().toString()));

                int checkedId = rgGender.getCheckedRadioButtonId();
                if(checkedId==R.id.male){
                    characterSheet.setGender("Male");
                }else if(checkedId==R.id.female){
                    characterSheet.setGender("Female");
                }
                else if(checkedId==R.id.NonBinary){
                    characterSheet.setGender("Non Binary");
                }
               checkedId = rgClass.getCheckedRadioButtonId();
                if(checkedId==R.id.Bard){
                    characterSheet.setdndClass(DnDClass.Bard);
                }else if(checkedId==R.id.Fighter){
                    characterSheet.setdndClass(DnDClass.Fighter);
                }
                else if(checkedId==R.id.Wizard){
                    characterSheet.setdndClass(DnDClass.Wizard);
                }
                checkedId = rgRace.getCheckedRadioButtonId();
                if(checkedId==R.id.Dwarf){
                    characterSheet.setRace(Race.Dwarf);
                }else if(checkedId==R.id.Elf){
                    characterSheet.setRace(Race.Elf);
                }
                else if(checkedId==R.id.Human){
                    characterSheet.setRace(Race.Human);
                }

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
    private int validInput(){
        int x=0;

        if(CharacterNameText.getText().toString()==""){
            x=1;
        }
        if(DescriptionText.getText().toString()==""){
            x=1;
        }


        if(Integer.parseInt(StrengthText.getText().toString())<=0 && Integer.parseInt(StrengthText.getText().toString())>=31){

        }
        if(Integer.parseInt(DexterityText.getText().toString())<=0 && Integer.parseInt(DexterityText.getText().toString())>=31){

        }
        if(Integer.parseInt(WisdomText.getText().toString())<=0 && Integer.parseInt(WisdomText.getText().toString())>=31){

        }
        if(Integer.parseInt(IntelligenceText.getText().toString())<=0 && Integer.parseInt(IntelligenceText.getText().toString())>=31){

        }
        if(Integer.parseInt(CharismaText.getText().toString())<=0 && Integer.parseInt(CharismaText.getText().toString())>=31){

        }
        if(Integer.parseInt(ConstitutionText.getText().toString())<=0 && Integer.parseInt(ConstitutionText.getText().toString())>=31){

        }


        return x;
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

        rgGender=findViewById(R.id.rgGender);
        rgClass=findViewById(R.id.rgClass);
        rgRace=findViewById(R.id.rgRace);

    }
}