package com.example.MemoryDAO;

import com.example.Session.Session;
import com.example.DAO.SessionDAO;

import java.util.ArrayList;
import java.util.List;

public class SessionMemoryDAO implements SessionDAO {

    protected static List<Session> entities = new ArrayList<Session>();

    public void delete(Session entity) {
        entities.remove(entity);
    }

    public List<Session> findAll() {
        return new ArrayList<Session>(entities);
    }

    public void save(Session entity) {
        if (!entities.contains(entity)) {
            entities.add(entity);
        }
    }

    public Session find(int sessionID) {
        for (Session session : entities) {
            if (session.getID() == sessionID) {
                return session;
            }
        }
        return null;
    }

}
