package com.example.team13;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.CharacterSheet.CharacterSheet;

import java.util.ArrayList;

public class CharacterRecViewAdapter extends RecyclerView.Adapter<CharacterRecViewAdapter.ViewHolder1>{

    private ArrayList<CharacterSheet> characters=new ArrayList<CharacterSheet>();
    public CharacterRecViewAdapter(){

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
            holder.CharName.setText(characters.get(position).getName());
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

        private TextView CharName;
        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            CharName= itemView.findViewById(R.id.CharName);
        }
    }
}
