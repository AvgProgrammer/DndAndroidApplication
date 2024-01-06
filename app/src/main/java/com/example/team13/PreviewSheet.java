package com.example.team13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.CharacterSheet.CharacterSheet;
import com.example.CharacterSheet.DnDClass;
import com.example.CharacterSheet.Race;

public class PreviewSheet extends AppCompatActivity {

    protected TextView PreviewName,PreviewGender,PreviewClass,PreviewRace, PreviewStr,PreviewDex,PreviewWis,PreviewInt,PreviewChr,PreviewCon, PreviewDesc;
    protected int CharacterID;
    private CharacterSheet prvChar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_sheet);

        Intent intent = getIntent();
        if(prvChar != null) {

        }
        initValues();
        prvChar=(CharacterSheet)intent.getSerializableExtra("Character");

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
    }
}