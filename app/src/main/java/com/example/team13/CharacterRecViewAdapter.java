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

    public CharacterRecViewAdapter(Context mContext, ActivityResultLauncher<Intent> launcher) {
        this.mContext = mContext;
        this.launcher = launcher;
    }


    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.char_list,parent, false);
        ViewHolder1 holder=new ViewHolder1(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder1 holder, int position) {
        int currentPosition = holder.getAdapterPosition();
        holder.CharName.setText((position+1)+")"+characters.get(position).getName());
            holder.Parent1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext, PreviewSheet.class);
                    intent.putExtra("Character",characters.get(currentPosition));
                    launcher.launch(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public void setCharacters(ArrayList<CharacterSheet> characters) {
        this.characters = characters;
        notifyDataSetChanged();
    }

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
