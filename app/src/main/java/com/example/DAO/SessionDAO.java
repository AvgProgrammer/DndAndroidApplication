package com.example.DAO;

import com.example.Session.Session;

import java.util.List;

public interface SessionDAO {

    /**
     * Η αναζήτηση μιας συνεδρίας με βάση το μοναδικό κωδικό της.
     * 
     * @param sessionID Ο μοναδικός κωδικός της συνεδρίας.
     * @return Ο παίκτης ή {@code null} εάν αυτό δεν βρεθεί.
     */
    Session find(int sessionID);

    /**
     * Αποθηκεύει ένα αντικείμενο στην εξωτερική πηγή
     * δεδομένων. Το αντικείμενο μπορεί να είναι κάποιο
     * νέο αντικείμενο που δεν υπάρχει στην πηγή δεδομένων
     * ή κάποιο το οποίο ήδη υπάρχει και ενημερώνεται η
     * κατάστασή του.
     * 
     * @param entity Το αντικείμενο του οποίου η κατάσταση
     *               αποθηκεύεται στην εξωτερική πηγή δεδομένων.
     */
    void save(Session entity);

    /**
     * Διαγράφει το αντικείμενο από την εξωτερική πηγή δεδομένων.
     * 
     * @param entity Το αντικείμενο προς διαγραφή.
     */
    void delete(Session entity);

    /**
     * Επιστρέφει όλα τα αντικείμενα από την εξωτερική πηγή δεδομένων.
     * 
     * @return Ο κατάλογος των αντικειμένων
     */
    List<Session> findAll();

}