package com.example.team13;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.CharacterSheet.CharacterSheet;
import com.example.CharacterSheet.DnDClass;
import com.example.CharacterSheet.Race;

public class PreviewSheet extends AppCompatActivity {

    protected TextView PreviewName,PreviewGender,PreviewClass,PreviewRace, PreviewStr,PreviewDex,PreviewWis,PreviewInt,PreviewChr,PreviewCon, PreviewDesc;

    protected Button EditButton,EndButton;
    protected int CharacterID;
    private CharacterSheet prvChar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_sheet);

        Intent intent = getIntent();
        initValues();

        Button editButton=findViewById(R.id.EditButton);
       editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PreviewSheet.this, CharacterSheetActivity.class);
                intent.putExtra("Checker",false);
                intent.putExtra("EditChar",prvChar);
                mStartForResult.launch(intent);
            }
        });
        prvChar=(CharacterSheet)intent.getSerializableExtra("Character");
        updated();
        Button enDButton=findViewById(R.id.EndButton);
        enDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCharacterCreated(prvChar);
                finish();
            }
        });


    }
    private void initValues(){
        PreviewName=findViewById(R.id.PreviewName);

        PreviewGender=findViewById(R.id.PreviewGender);
        PreviewClass=findViewById(R.id.PreviewClass);
        PreviewRace=findViewById(R.id.PreviewRace);

        PreviewStr=findViewById(R.id.PreviewStr);
        PreviewDex=findViewById(R.id.PreviewDex);
        PreviewWis=findViewById(R.id.PreviewWis);
        PreviewInt=findViewById(R.id.PreviewInt);
        PreviewChr=findViewById(R.id.PreviewChr);
        PreviewCon=findViewById(R.id.PreviewCon);

        PreviewDesc=findViewById(R.id.PreviewDesc);

        EditButton=findViewById(R.id.EditButton);
        EndButton=findViewById(R.id.EndButton);
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
                            prvChar = (CharacterSheet) data.getSerializableExtra("Nothing1");
                            Log.d("PreviewSheet","Character Id:"+prvChar.getID());
                            // Add the new character to the ArrayList
                            updated();
                        }
                    }
                }
            });
    private void updated(){
        PreviewName.setText(prvChar.getName());

        PreviewGender.setText(prvChar.getGender());

        if(DnDClass.Bard.equals(prvChar.getdndClass())){
            PreviewClass.setText("Bard");
        } else if (DnDClass.Wizard.equals(prvChar.getdndClass())) {
            PreviewClass.setText("Wizard");
        } else if (DnDClass.Fighter.equals(prvChar.getdndClass())) {
            PreviewClass.setText("Fighter");
        }

        if(Race.Dwarf.equals(prvChar.getRace())){
            PreviewRace.setText("Dwarf");
        } else if (Race.Elf.equals(prvChar.getRace())) {
            PreviewRace.setText("Elf");
        } else if (Race.Human.equals(prvChar.getRace())) {
            PreviewRace.setText("Human");
        }

        PreviewStr.setText(Integer.toString(prvChar.getStrength()));
        PreviewDex.setText(Integer.toString(prvChar.getDexterity()));
        PreviewWis.setText(Integer.toString(prvChar.getWisdom()));
        PreviewInt.setText(Integer.toString(prvChar.getIntelligence()));
        PreviewChr.setText(Integer.toString(prvChar.getCharisma()));
        PreviewCon.setText(Integer.toString(prvChar.getConsitution()));

        PreviewDesc.setText(prvChar.getDescription());
    }
    public void onCharacterCreated(CharacterSheet newCharacter) {
        // Create an Intent to send the result back
        Intent returnIntent = new Intent();

        // Assuming CharacterSheet is serializable or parcelable.
        // If not, you will need to break down the object into primitives or implement Serializable or Parcelable in the CharacterSheet class.
        returnIntent.putExtra("updatedCharacter", newCharacter);
        Log.d("PreviewSheet", "Putting character to intent: " + newCharacter.getName());
        // Set the result with the Intent
        setResult(RESULT_OK, returnIntent);

        // Finish the activity
        finish();
    }

}