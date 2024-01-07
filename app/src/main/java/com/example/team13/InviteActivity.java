package com.example.team13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.SessionScheduler.SessionScheduler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;


public class InviteActivity extends AppCompatActivity {
    protected EditText InviteSender,InviteReceivers,InviteLocation,InviteDate,InviteDesc;
    protected TextView SendersWrn,ReceiversWrn,DescWrn,DateWrn;
    protected Button InviteSend,InviteReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite);
        initValues();
        InviteReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        InviteSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ValidData()){
                    SessionScheduler sessionScheduler=new SessionScheduler();
                    sessionScheduler.setSender(InviteSender.getText().toString());
                    sessionScheduler.setDescription(InviteDesc.getText().toString());
                    sessionScheduler.setLocation(InviteLocation.getText().toString());
                    String[] parts = InviteReceivers.getText().toString().split(",");

                    // Creating a list to hold the parts
                    ArrayList<String> list = new ArrayList<>();

                    // Adding each part to the list
                    for(String part : parts) {
                        list.add(part);
                    }
                    sessionScheduler.setRecipents(list);
                    LocalDate dt1 = LocalDate.parse(InviteDate.getText().toString());
                    sessionScheduler.setDate(dt1);

                    onClickSent(sessionScheduler);
                }
                WrnOff();
            }
        });
    }
    private void initValues(){
        InviteSender=findViewById(R.id.InviteSender);
        InviteReceivers=findViewById(R.id.InviteReceivers);
        InviteLocation=findViewById(R.id.InviteLocation);
        InviteDate=findViewById(R.id.InviteDate);
        InviteDesc=findViewById(R.id.InviteDesc);

        SendersWrn=findViewById(R.id.SendersWrn);
        ReceiversWrn=findViewById(R.id.ReceiversWrn);
        DescWrn=findViewById(R.id.DescWrn);
        DateWrn=findViewById(R.id.DateWrn);

        InviteSend=findViewById(R.id.InviteSend);
        InviteReturn=findViewById(R.id.InviteReturn);
    }
    private boolean ValidData(){
        if(InviteSender.getText().toString().equals("")){
            SendersWrn.setText("Sender Missing");
            SendersWrn.setVisibility(View.VISIBLE);
            return false;
        }
        if(InviteReceivers.getText().toString().equals("")){
            ReceiversWrn.setText("Receivers Missing");
            ReceiversWrn.setVisibility(View.VISIBLE);
            return false;
        }
        if(InviteDesc.getText().toString().equals("")){
            DescWrn.setText("Description Missing");
            DescWrn.setVisibility(View.VISIBLE);
            return false;
        }
        if(InviteDate.getText().toString().equals("")){
            DateWrn.setText("Date Missing");
            DateWrn.setVisibility(View.VISIBLE);
            return false;
        }
        return true;
    }
    private void WrnOff(){
        SendersWrn.setVisibility(View.GONE);
        ReceiversWrn.setVisibility(View.GONE);
        DescWrn.setVisibility(View.GONE);
        DateWrn.setVisibility(View.GONE);
    }
    private void onClickSent(SessionScheduler sessionScheduler){
        Intent returnIntent = new Intent();

        // Assuming CharacterSheet is serializable or parcelable.
        // If not, you will need to break down the object into primitives or implement Serializable or Parcelable in the CharacterSheet class.
        returnIntent.putExtra("newInvite", sessionScheduler);

        // Set the result with the Intent
        setResult(RESULT_OK, returnIntent);
        finish();
    }

}