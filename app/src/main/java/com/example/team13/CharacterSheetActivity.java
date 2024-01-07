package com.example.team13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.CharacterSheet.CharacterSheet;
import com.example.CharacterSheet.DnDClass;
import com.example.CharacterSheet.Race;
import com.example.Dice.DiceRNGImpl;


public class CharacterSheetActivity extends AppCompatActivity {

    protected Button ReturnButton,AddCharacter,DiceButton;
    protected EditText CharacterNameText,DescriptionText,StrengthText,DexterityText,IntelligenceText,WisdomText,CharismaText,ConstitutionText;
    protected CharacterSheet EditableCharacter;
    protected TextView txtNameWrn,txtStatsWrn,txtDescWrn;
    protected RadioGroup rgGender,rgRace,rgClass;
    protected RadioButton male,female,NonBinary,Bard,Fighter,Wizard,Dwarf,Elf,Human;

    /**
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_sheet);
        boolean checker=true;
        Intent intent = getIntent();
        if(intent.hasExtra("Checker")){
           checker=intent.getBooleanExtra("Checker",true);

        }
        if(intent.hasExtra("EditChar")){
            EditableCharacter=(CharacterSheet) intent.getSerializableExtra("EditChar");
            Log.d("CharacterSheetActivity","EditableCharacterId:"+EditableCharacter.getID());
        }
        initViews();
        Button addCharacter=findViewById(R.id.AddCharacter);

        RadioButton M=findViewById(R.id.male);
        RadioButton Fe=findViewById(R.id.female);
        RadioButton N=findViewById(R.id.NonBinary);

        RadioButton B=findViewById(R.id.Bard);
        RadioButton Fi=findViewById(R.id.Fighter);
        RadioButton W=findViewById(R.id.Wizard);

        RadioButton D=findViewById(R.id.Dwarf);
        RadioButton E=findViewById(R.id.Elf);
        RadioButton H=findViewById(R.id.Human);
        int number=-1;
        if(checker==false && intent.hasExtra("EditChar")){

            addCharacter.setText("Submit");
            number=EditableCharacter.getID();
            CharacterNameText.setText(EditableCharacter.getName());
            DescriptionText.setText(EditableCharacter.getDescription());
            StrengthText.setText(Integer.toString(EditableCharacter.getStrength()));
            DexterityText.setText(Integer.toString(EditableCharacter.getDexterity()));
            WisdomText.setText(Integer.toString(EditableCharacter.getWisdom()));
            IntelligenceText.setText(Integer.toString(EditableCharacter.getIntelligence()));
            CharismaText.setText(Integer.toString(EditableCharacter.getCharisma()));
            ConstitutionText.setText(Integer.toString(EditableCharacter.getConsitution()));
            int checkedId = rgGender.getCheckedRadioButtonId();
            if (EditableCharacter.getGender().equals("Male")) {
                    M.setChecked(true);
                    Fe.setChecked(false);
                    N.setChecked(false);
            } else if (EditableCharacter.getGender().equals("Female")) {
                    M.setChecked(false);
                    Fe.setChecked(true);
                    N.setChecked(false);
            } else if (EditableCharacter.getGender().equals("Non Binary")) {
                    M.setChecked(false);
                    Fe.setChecked(false);
                    N.setChecked(true);
            }
            if(DnDClass.Bard.equals(EditableCharacter.getdndClass())){
                    B.setChecked(true);
                    Fi.setChecked(false);
                    W.setChecked(false);
            } else if (DnDClass.Wizard.equals(EditableCharacter.getdndClass())) {
                    B.setChecked(false);
                    Fi.setChecked(false);
                    W.setChecked(true);
            } else if (DnDClass.Fighter.equals(EditableCharacter.getdndClass())) {
                    B.setChecked(false);
                    Fi.setChecked(true);
                    W.setChecked(false);
            }

            if(Race.Dwarf.equals(EditableCharacter.getRace())){
                    D.setChecked(true);
                    E.setChecked(false);
                    H.setChecked(false);
            } else if (Race.Elf.equals(EditableCharacter.getRace())) {
                    D.setChecked(false);
                    E.setChecked(true);
                    H.setChecked(false);
            } else if (Race.Human.equals(EditableCharacter.getRace())) {
                    D.setChecked(false);
                    E.setChecked(false);
                    H.setChecked(true);
            }
        }
        int finalnumber=number;
        boolean finalChecker = checker;
        addCharacter.setOnClickListener(new View.OnClickListener() {
            /**
             * @param v check the user input add returns the character.
             */
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
                    if (finalnumber!=-1){
                        characterSheet.setID(finalnumber);
                    }
                    if(finalChecker ==true){
                        Log.d("CharacterSheetActivity","Character Id:"+characterSheet.getID());
                        onCharacterCreated(characterSheet);
                    }else{
                        Log.d("CharacterSheetActivity","Character Id:"+characterSheet.getID());
                        onCharacterUpdated(characterSheet);
                    }
                    removeWrn();
                }
            }
        });

        Button returnButton = findViewById(R.id.ReturnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            /**
             * @param v finish the activity.
             */
            @Override
            public void onClick(View v) {
                // Define the action to perform on click
                finish(); // This will mimic the default back press action
            }
        });
        DiceButton.setOnClickListener(new View.OnClickListener() {
            /**
             * @param v Print the values of the dice
             */
            @Override
            public void onClick(View v) {
                DiceRNGImpl dice=new DiceRNGImpl();
                StrengthText.setText(Integer.toString(dice.rng()));
                DexterityText.setText(Integer.toString(dice.rng()));
                WisdomText.setText(Integer.toString(dice.rng()));
                IntelligenceText.setText(Integer.toString(dice.rng()));
                CharismaText.setText(Integer.toString(dice.rng()));
                ConstitutionText.setText(Integer.toString(dice.rng()));
            }
        });

    }

    /**
     * @param newCharacter returns the newCharacter
     */
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

    /**
     * @param newCharacter returns the updated character
     */
    public void onCharacterUpdated(CharacterSheet newCharacter) {
        // Create an Intent to send the result back
        Intent returnIntent = new Intent();

        // Assuming CharacterSheet is serializable or parcelable.
        // If not, you will need to break down the object into primitives or implement Serializable or Parcelable in the CharacterSheet class.
        returnIntent.putExtra("Nothing1", newCharacter);

        // Set the result with the Intent
        setResult(RESULT_OK, returnIntent);

        // Finish the activity
        finish();
    }

    /**
     * remove the Warnings
     */
    private void removeWrn(){
        txtNameWrn.setVisibility(View.GONE);
        txtDescWrn.setVisibility(View.GONE);
        txtStatsWrn.setVisibility(View.GONE);
    }

    /**
     * Checks the user Input
     */
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

    /**
     * Initialize Values
     */
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

        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        NonBinary=findViewById(R.id.NonBinary);

        Bard=findViewById(R.id.Bard);
        Fighter=findViewById(R.id.Fighter);
        Wizard=findViewById(R.id.Wizard);

        Dwarf=findViewById(R.id.Dwarf);
        Elf=findViewById(R.id.Elf);
        Human=findViewById(R.id.Human);

        txtNameWrn=findViewById(R.id.txtNameWrn);
        txtStatsWrn=findViewById(R.id.txtStatsWrn);
        txtDescWrn=findViewById(R.id.txtDescWrn);
        DiceButton=findViewById(R.id.DiceButton);
    }


}