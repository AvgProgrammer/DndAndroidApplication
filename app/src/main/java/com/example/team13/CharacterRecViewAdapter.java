package com.example.team13;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.CharacterSheet.CharacterSheet;

import java.util.ArrayList;

public class CharacterRecViewAdapter extends RecyclerView.Adapter<CharacterRecViewAdapter.ViewHolder1>{

    private ArrayList<CharacterSheet> characters=new ArrayList<CharacterSheet>();
    private Context mContext;
    private ActivityResultLauncher<Intent> launcher;
    private boolean play;

    /**
     * @param mContext  Constuctor of the adapter
     * @param launcher
     * @param play
     */
    public CharacterRecViewAdapter(Context mContext, ActivityResultLauncher<Intent> launcher,boolean play) {
        this.mContext = mContext;
        this.launcher = launcher;
        this.play=play;
    }


    /**
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return
     */
    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.char_list,parent, false);
        ViewHolder1 holder=new ViewHolder1(view);
        return holder;
    }

    /**
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     *                 Calls different activty depending on the play value
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder1 holder, int position) {
        int currentPosition = holder.getAdapterPosition();
        holder.CharName.setText((position+1)+")"+characters.get(position).getName());
        if(play!=true){
            holder.Parent1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext, PreviewSheet.class);
                    intent.putExtra("Character",characters.get(currentPosition));
                    launcher.launch(intent);
                }
            });
        }else{
            holder.Parent1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext, PlaySession.class);
                    intent.putExtra("Character",characters.get(currentPosition));
                    launcher.launch(intent);
                }
            });
        }

    }

    /**
     * @return the list size
     */
    @Override
    public int getItemCount() {
        return characters.size();
    }

    /**
     * @param characters  updates the adapter
     */
    public void setCharacters(ArrayList<CharacterSheet> characters) {
        this.characters = characters;
        notifyDataSetChanged();
    }

    /**
     * Initialize Values
     */
    public class ViewHolder1 extends RecyclerView.ViewHolder{

        private CardView Parent1;
        private TextView CharName;
        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            CharName= itemView.findViewById(R.id.CharName);
            Parent1= itemView.findViewById(R.id.Parent1);
        }
    }
}
