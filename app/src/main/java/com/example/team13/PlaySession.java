package com.example.team13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.CharacterSheet.CharacterSheet;
import com.example.Dice.DiceRoll;

/**
 *
 */
public class PlaySession extends AppCompatActivity {

    protected Button ReturnPlay,DiceModif,AddExp;
    protected EditText Modifier,Exp;
    protected CharacterSheet playChar;

    /**
     * @param savedInstanceState Creates the Activity>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_session);

        Intent intent = getIntent();
        if(intent.hasExtra("Character")){
            playChar=(CharacterSheet)intent.getSerializableExtra("Character");
        }
        initValues();
        ReturnPlay.setOnClickListener(new View.OnClickListener() {
            /**
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        DiceModif.setOnClickListener(new View.OnClickListener() {
            /**
             * @param v Calculates the Modifier and prints on a toast message.
             */
            @Override
            public void onClick(View v) {
                if(Modifier.getText().toString().equals("Str")){
                    int str=playChar.getStrengthModifier();
                    DiceRoll dice=new DiceRoll(str);
                    Toast.makeText(PlaySession.this,dice.getDescription(),Toast.LENGTH_SHORT).show();
                }else if(Modifier.getText().toString().equals("Dex")){
                    int str=playChar.getDexterityModifier();
                    DiceRoll dice=new DiceRoll(str);
                    Toast.makeText(PlaySession.this,dice.getDescription(),Toast.LENGTH_SHORT).show();
                }
                else if(Modifier.getText().toString().equals("Wis")){
                    int str=playChar.getWisdomModifier();
                    DiceRoll dice=new DiceRoll(str);
                    Toast.makeText(PlaySession.this,dice.getDescription(),Toast.LENGTH_SHORT).show();
                }
                else if(Modifier.getText().toString().equals("Int")){
                    int str=playChar.getIntelligenceModifier();
                    DiceRoll dice=new DiceRoll(str);
                    Toast.makeText(PlaySession.this,dice.getDescription(),Toast.LENGTH_SHORT).show();
                }
                else if(Modifier.getText().toString().equals("Chr")){
                    int str=playChar.getCharismaModifier();
                    DiceRoll dice=new DiceRoll(str);
                    Toast.makeText(PlaySession.this,dice.getDescription(),Toast.LENGTH_SHORT).show();
                }
                else if(Modifier.getText().toString().equals("Con")){
                    int str=playChar.getConsitutionModifier();
                    DiceRoll dice=new DiceRoll(str);
                    Toast.makeText(PlaySession.this,dice.getDescription(),Toast.LENGTH_SHORT).show();
                }
                Modifier.setText("");
            }
        });
        AddExp.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * @param v Adds the exp and prints the new level on a toast message.
             */
            public void onClick(View v) {
                playChar.addExp(Integer.parseInt(Exp.getText().toString()));
                Toast.makeText(PlaySession.this,"Current Level:"+playChar.getlevel(),Toast.LENGTH_SHORT).show();
                Exp.setText("");
            }
        });
    }

    /**
     * Initialize Values
     */
    private void initValues(){
        ReturnPlay=findViewById(R.id.ReturnPay);
        DiceModif=findViewById(R.id.DiceModif);
        AddExp=findViewById(R.id.AddExp);

        Modifier=findViewById(R.id.Modifier);
        Exp=findViewById(R.id.Exp);

    }
}