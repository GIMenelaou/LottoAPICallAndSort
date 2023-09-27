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
public class SaveCompare {
    
      public void saveResult(OpapJokerDraws drawId) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("3hGEPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        
    if (!compareResult(drawId.getDrawid(), em)) {
            em.persist(drawId);
            em.getTransaction().commit();
        }
       

        em.close();
        emf.close();
    }

    public boolean compareResult(int drawId, EntityManager em) {

        Query checkif = em.createNamedQuery("OpapJokerDraws.findByDrawid", OpapJokerDraws.class);
        checkif.setParameter("drawid", drawId);
        try {
            OpapJokerDraws result = (OpapJokerDraws) checkif.getSingleResult();
            return true;
        } catch (Exception e) {
            System.out.println("Δεν υπάρχει στον πίνακα." );
            return false;
        }
    }
    
}
