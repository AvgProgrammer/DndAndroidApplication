package com.example.MemoryDAO;

import com.example.Player.Player;
import com.example.DAO.PlayerDAO;

import java.util.ArrayList;
import java.util.List;

public class PlayerMemoryDAO implements PlayerDAO {

    protected static List<Player> entities = new ArrayList<Player>();
    
    public void delete(Player entity) {
        entities.remove(entity);    
    }

    public List<Player> findAll() {
        return new ArrayList<Player>(entities);
    }

    public void save(Player entity) {
        if (!entities.contains(entity)) {
            entities.add(entity);    
        }        
    }
    
    public Player find(int playerID) {
        for(Player player : entities) {
            if (player.getID() == playerID) {
                return player;
            }
        }
        return null;
    }

}
