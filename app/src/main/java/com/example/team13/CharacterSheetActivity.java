package com.example.team13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.CharacterSheet.CharacterSheet;
import com.example.CharacterSheet.DnDClass;
import com.example.CharacterSheet.Race;


public class CharacterSheetActivity extends AppCompatActivity {

    protected Button ReturnButton,AddCharacter;
    protected EditText CharacterNameText,DescriptionText,StrengthText,DexterityText,IntelligenceText,WisdomText,CharismaText,ConstitutionText;

    protected TextView txtNameWrn,txtStatsWrn,txtDescWrn;
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
                if(validInput()==true) {


                    CharacterSheet characterSheet = new CharacterSheet();

                    characterSheet.setName(CharacterNameText.getText().toString());
                    characterSheet.setDescription(DescriptionText.getText().toString());

                    characterSheet.setStrength(Integer.parseInt(StrengthText.getText().toString()));
                    characterSheet.setDexterity(Integer.parseInt(DexterityText.getText().toString()));
                    characterSheet.setWisdom(Integer.parseInt(WisdomText.getText().toString()));
                    characterSheet.setIntelligence(Integer.parseInt(IntelligenceText.getText().toString()));
                    characterSheet.setCharisma(Integer.parseInt(CharismaText.getText().toString()));
                    characterSheet.setConstitution(Integer.parseInt(ConstitutionText.getText().toString()));

                    int checkedId = rgGender.getCheckedRadioButtonId();
                    if (checkedId == R.id.male) {
                        characterSheet.setGender("Male");
                    } else if (checkedId == R.id.female) {
                        characterSheet.setGender("Female");
                    } else if (checkedId == R.id.NonBinary) {
                        characterSheet.setGender("Non Binary");
                    }
                    checkedId = rgClass.getCheckedRadioButtonId();
                    if (checkedId == R.id.Bard) {
                        characterSheet.setdndClass(DnDClass.Bard);
                    } else if (checkedId == R.id.Fighter) {
                        characterSheet.setdndClass(DnDClass.Fighter);
                    } else if (checkedId == R.id.Wizard) {
                        characterSheet.setdndClass(DnDClass.Wizard);
                    }
                    checkedId = rgRace.getCheckedRadioButtonId();
                    if (checkedId == R.id.Dwarf) {
                        characterSheet.setRace(Race.Dwarf);
                    } else if (checkedId == R.id.Elf) {
                        characterSheet.setRace(Race.Elf);
                    } else if (checkedId == R.id.Human) {
                        characterSheet.setRace(Race.Human);
                    }
                    onCharacterCreated(characterSheet);
                    removeWrn();
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
    public void onCharacterCreated(CharacterSheet newCharacter) {
        // Create an Intent to send the result back
        Intent returnIntent = new Intent();

        // Assuming CharacterSheet is serializable or parcelable.
        // If not, you will need to break down the object into primitives or implement Serializable or Parcelable in the CharacterSheet class.
        returnIntent.putExtra("newCharacter", newCharacter);

        // Set the result with the Intent
        setResult(RESULT_OK, returnIntent);

        // Finish the activity
        finish();
    }
    private void removeWrn(){
        txtNameWrn.setVisibility(View.GONE);
        txtDescWrn.setVisibility(View.GONE);
        txtStatsWrn.setVisibility(View.GONE);
    }
    private boolean validInput(){
            boolean returner=true;
        if(CharacterNameText.getText().toString().equals("")){
                txtNameWrn.setVisibility(View.VISIBLE);
                txtNameWrn.setText("Enter Name");
                returner=false;
        }
        if(DescriptionText.getText().toString().equals("")){
            txtDescWrn.setVisibility(View.VISIBLE);
            txtDescWrn.setText("Enter Description");
            returner=false;
        }


        if(StrengthText.getText().toString().equals("") ||
            DexterityText.getText().toString().equals("") ||
            WisdomText.getText().toString().equals("") ||
            IntelligenceText.getText().toString().equals("") ||
            CharismaText.getText().toString().equals("") ||
            ConstitutionText.getText().toString().equals("")
        ){
            txtStatsWrn.setVisibility(View.VISIBLE);
            txtStatsWrn.setText("Stats missing");
            returner=false;
        }

        if(!StrengthText.getText().toString().equals("") &&
            !DexterityText.getText().toString().equals("") &&
            !WisdomText.getText().toString().equals("") &&
            !IntelligenceText.getText().toString().equals("") &&
            !CharismaText.getText().toString().equals("") &&
            !ConstitutionText.getText().toString().equals("")

        ){
            if( (Integer.parseInt(StrengthText.getText().toString())<=0 || Integer.parseInt(StrengthText.getText().toString())>=31) ||
                (Integer.parseInt(DexterityText.getText().toString())<=0 || Integer.parseInt(DexterityText.getText().toString())>=31) ||
                (Integer.parseInt(WisdomText.getText().toString())<=0 || Integer.parseInt(WisdomText.getText().toString())>=31) ||
                (Integer.parseInt(IntelligenceText.getText().toString())<=0 || Integer.parseInt(IntelligenceText.getText().toString())>=31) ||
                (Integer.parseInt(CharismaText.getText().toString())<=0 || Integer.parseInt(CharismaText.getText().toString())>=31) ||
                (Integer.parseInt(ConstitutionText.getText().toString())<=0 || Integer.parseInt(ConstitutionText.getText().toString())>=31)
            ){
                txtStatsWrn.setVisibility(View.VISIBLE);
                txtStatsWrn.setText("Incorrect Values");
                returner=false;
        }
        }


        return  returner;
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

        txtNameWrn=findViewById(R.id.txtNameWrn);
        txtStatsWrn=findViewById(R.id.txtStatsWrn);
        txtDescWrn=findViewById(R.id.txtDescWrn);
    }


}