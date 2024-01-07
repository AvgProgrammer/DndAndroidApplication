package com.example.team13;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    private boolean play;

    private static final int REQUEST_CODE_PREVIEW = 1001;

    @Override
    /**
     * @param savedInstanceState Creates the Activity>
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_list);

        Intent intent = getIntent();

        if(intent.hasExtra("CharList")){
            CharList = (ArrayList) intent.getSerializableExtra("CharList");
        }
        if(intent.hasExtra("play")){
            play= intent.getBooleanExtra("play",true);
        }
        initViews();
        adapter = new CharacterRecViewAdapter(this,mStartForResult,play);
        adapter.setCharacters(CharList);

        CharactersList.setAdapter(adapter);
        CharactersList.setLayoutManager(new LinearLayoutManager(this));
        if(play==true){
            AddButton.setVisibility(View.GONE);
        }else{
            AddButton.setVisibility(View.VISIBLE);
        }
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * @param v Creates the Activity when the button is pressed>
             */
            public void onClick(View v) {
                Intent intent=new Intent(CharacterListActivity.this, CharacterSheetActivity.class);
                intent.putExtra("Checker",true);
                mStartForResult.launch(intent);
            }
        });
        Button BackButton = findViewById(R.id.BackButton);
        if(play==true){
            BackButton.setOnClickListener(new View.OnClickListener() {
                /**
                 * @param v Finish the Activity when the button is pressed>
                 */
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }else{
            BackButton.setOnClickListener(new View.OnClickListener() {
                /**
                 * @paramv v finish the activity and returns the list>
                 */
                @Override
                public void onClick(View v) {
                    Intent returnIntent = new Intent();

                    // Assuming CharacterSheet is serializable or parcelable.
                    // If not, you will need to break down the object into primitives or implement Serializable or Parcelable in the CharacterSheet class.
                    returnIntent.putExtra("Characters", CharList);

                    // Set the result with the Intent
                    setResult(RESULT_OK, returnIntent);

                    // Define the action to perform on click
                    finish(); // This will mimic the default back press action
                }
            });
        }

    }

    /**
     * Initialize Values
     */
    private void initViews(){
        AddButton =findViewById(R.id.AddButton);
        BackButton=findViewById(R.id.BackButton);
        CharactersList=findViewById(R.id.CharactersList);
    }

    /**
     * Overrides the onActivityResult methods and change the adapter according to the returned value
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

                            CharacterSheet newCharacter = (CharacterSheet) data.getSerializableExtra("newCharacter");
                            if(newCharacter!=null){
                                Log.d("CharacterListActivity", "Received new character: " + newCharacter.getName()+"/"+CharList.size());
                                newCharacter.setID(CharList.size());
                                Log.d("CharacterListActivity","New character Id:"+newCharacter.getID());
                                CharList.add(newCharacter);
                            }
                            // Add the new character to the ArrayList
                            CharacterSheet updatedCharacter = (CharacterSheet) data.getSerializableExtra("updatedCharacter");
                            if (updatedCharacter != null) {
                                Log.d("CharacterListActivity", "Received updated character: " + updatedCharacter.getName());
                                for(int i = 0; i < CharList.size(); i++){
                                    Log.d("CharacterListActivity", "Edw eimai"+updatedCharacter.getID());
                                    if (CharList.get(i).getID() == updatedCharacter.getID()) {
                                        CharList.set(i, updatedCharacter);
                                        Log.d("CharacterListActivity", "Add character to list: "+ updatedCharacter.getName()+","+CharList.get(i).getName());
                                        break;
                                    }
                                }
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            });


}
