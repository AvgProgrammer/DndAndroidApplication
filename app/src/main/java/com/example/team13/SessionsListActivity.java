package com.example.team13;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.CharacterSheet.CharacterSheet;
import com.example.Session.Session;
import com.example.SessionScheduler.SessionScheduler;

import java.util.ArrayList;

public class SessionsListActivity extends AppCompatActivity {

    protected Button Return,InviteButton,PlaySession;
    private ArrayList<Session> SessList;
    private ArrayList<Session> CharList;

    /**
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessions_list);

        Intent intent = getIntent();

        if(intent.hasExtra("SessList")){
            SessList = (ArrayList) intent.getSerializableExtra("SessList");
        }
        if(intent.hasExtra("CharList")){
            CharList=(ArrayList)intent.getSerializableExtra("CharList");
        }

        initViews();
        InviteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SessionsListActivity.this, InviteActivity.class);
                mStartForResult.launch(intent);
            }
        });
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        PlaySession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SessionsListActivity.this, CharacterListActivity.class);
                intent.putExtra("CharList",CharList);
                intent.putExtra("play",true);
                startActivity(intent);
            }
        });
    }

    /**
     * Initialize Values
     */
    private void initViews(){

        Return =findViewById(R.id.Return);
        InviteButton=findViewById(R.id.InviteButton);
        PlaySession=findViewById(R.id.PlaySession);
    }

    /**
     * Gets the values of the finished activity
     */
    private ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            // Retrieve the CharacterSheet object
                            SessionScheduler sessionScheduler=(SessionScheduler) data.getSerializableExtra("newInvite");
                            if(sessionScheduler!=null){
                                Toast.makeText(SessionsListActivity.this,"Email was Sent",Toast.LENGTH_SHORT).show();
                            }

                        }
                    }
                }
            });
}