/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3hge;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modular.OpapJokerDraws;

/**
 *
 * @author Giorg
 */
public class DeleteDraw {
    
    public boolean deleteDrawID(int drawId) {
 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("3hGEPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query q = em.createNamedQuery("OpapJokerDraws.findByDrawid", OpapJokerDraws.class);
        q.setParameter("drawid", drawId);
        try {
            OpapJokerDraws result = (OpapJokerDraws) q.getSingleResult();
            em.remove(result);
            em.getTransaction().commit();
            em.close();
            emf.close();
            System.out.println("Η καταχώρηση με ID " + drawId + " έχει διαγραφεί.");
            return true;
        } catch (Exception e) {
            System.out.println("Σφάλμα!" + e);
            return false;
        }
    }
    
}
