package com.example.Player;

import java.io.Serializable;
import java.util.ArrayList;

import com.example.CharacterSheet.CharacterSheet;
import com.example.Session.Session;
import com.example.SessionScheduler.SessionScheduler;

public class Player implements Serializable {

    private String name, email, password;
    private int ID;
    private ArrayList<CharacterSheet> characters;
    private ArrayList<Session> sessions;

    public Player(String name, String email, String password) {
        this.ID = this.hashCode();
        this.name = name;
        this.email = email;
        this.password = password;
        this.characters = new ArrayList<CharacterSheet>();
        this.sessions = new ArrayList<Session>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String GetName() {
        return name;
    }

    public String GetEmail() {
        return email;
    }

    public String GetPassword() {
        return password;
    }

    public int getID() {
        return ID;
    }

    public ArrayList<CharacterSheet> getCharacters() {
        return characters;
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    }

    public void AddCharacter(CharacterSheet x) {
        characters.add(x);
    }

    public void AddSession(Session x) {
        sessions.add(x);
    }
}
