package services;


import entities.Artist;
import entities.Cd;

import javax.persistence.*;

@PersistenceContext
public class EntityMan {

    private static final EntityManagerFactory emFactory;
    private static final String PERSISTENCE_UNIT_NAME = "artist";

    static{
        emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }



    public void create(Artist artist){
        EntityManager entityMgr = getEntityManager();
        entityMgr.getTransaction().begin();

        entityMgr.persist(artist);

        entityMgr.getTransaction().commit();
        entityMgr.clear();
    }


    public Artist findById(Integer id){
        return getEntityManager().find(Artist.class, id);
    }


    public void delete(Artist artist){
        EntityManager entityMgr = getEntityManager();
        entityMgr.getTransaction().begin();

        entityMgr.remove(entityMgr.contains(artist) ? artist:entityMgr.merge(artist));

        entityMgr.getTransaction().commit();
        entityMgr.clear();
    }


    public void update(Artist artist){

        EntityManager entityMgr = getEntityManager();
        entityMgr.getTransaction().begin();

        entityMgr.merge(artist);

        entityMgr.getTransaction().commit();

    }


    public void create(Cd cd){
        EntityManager entityMgr = getEntityManager();
        entityMgr.getTransaction().begin();

        entityMgr.persist(cd);

        entityMgr.getTransaction().commit();
        entityMgr.clear();
    }

    public Cd findByIdCd(Integer id){
        return getEntityManager().find(Cd.class, id);
    }


    public void delete(Cd cd){
        EntityManager entityMgr = getEntityManager();
        entityMgr.getTransaction().begin();

        entityMgr.remove(entityMgr.contains(cd) ? cd:entityMgr.merge(cd));

        entityMgr.getTransaction().commit();
        entityMgr.clear();
    }


    public void update(Cd cd){

        EntityManager entityMgr = getEntityManager();
        entityMgr.getTransaction().begin();

        entityMgr.merge(cd);

        entityMgr.getTransaction().commit();

    }




}
