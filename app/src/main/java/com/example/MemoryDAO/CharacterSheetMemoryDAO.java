package com.example.MemoryDAO;

import java.util.ArrayList;
import java.util.List;
import com.example.CharacterSheet.CharacterSheet;
import com.example.DAO.CharacterSheetDAO;

public class CharacterSheetMemoryDAO implements CharacterSheetDAO {

    protected static List<CharacterSheet> entities = new ArrayList<CharacterSheet>();

    public void delete(CharacterSheet entity) {
        entities.remove(entity);
    }

    public List<CharacterSheet> findAll() {
        return new ArrayList<CharacterSheet>(entities);
    }

    public void save(CharacterSheet entity) {
        if (!entities.contains(entity)) {
            entities.add(entity);
        }
    }

    public CharacterSheet find(int playerID) {
        for (CharacterSheet characterSheet : entities) {
            if (characterSheet.getID() == playerID) {
                return characterSheet;
            }
        }
        return null;
    }

}
