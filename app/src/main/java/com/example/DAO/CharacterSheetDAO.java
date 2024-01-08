package com.example.DAO;

import com.example.CharacterSheet.CharacterSheet;

import java.util.List;

public interface CharacterSheetDAO {

    /**
     * Η αναζήτηση ενός φύλλου χαρακτήρα με βάση το μοναδικού κωδικού του.
     * 
     * @param characterSheetID Ο μοναδικός κωδικός του φύλλου χαρακτήρα.
     * @return Το φύλλο χαρακτήρα ή {@code null} εάν αυτό δεν βρεθεί.
     */
    CharacterSheet find(int characterSheetID);

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
    void save(CharacterSheet entity);

    /**
     * Διαγράφει το αντικείμενο από την εξωτερική πηγή δεδομένων.
     * 
     * @param entity Το αντικείμενο προς διαγραφή.
     */
    void delete(CharacterSheet entity);

    /**
     * Επιστρέφει όλα τα αντικείμενα από την εξωτερική πηγή δεδομένων.
     * 
     * @return Ο κατάλογος των αντικειμένων
     */
    List<CharacterSheet> findAll();

}
