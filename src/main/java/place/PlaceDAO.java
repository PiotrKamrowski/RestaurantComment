package place;

import restaurantcomment.services.EntityManagerProvider;
import user.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class PlaceDAO {

    private EntityManagerProvider emp = new EntityManagerProvider();

    public PlaceDAO(EntityManagerProvider entityManagerProvider){
        this.emp = entityManagerProvider;
    }






    public List<Place> getListPlacesbyCity(String city) {

        emp.startNewEm();

        EntityManager em = emp.getCurrentEm();


        List<Place> listPlace = new ArrayList<>();

        Query query = em.createQuery("SELECT p FROM Place p where p.city like :city");
        query.setParameter("city", city + "%");
        listPlace = (List<Place>) query.getResultList();

        emp.clearEm();
        return listPlace;


    }






    public List<Place> getListPlacesbyType(String type){

        emp.startNewEm();

        EntityManager em = emp.getCurrentEm();

        Type typeE = Type.valueOf(type);




        List<Place> listPlace = new ArrayList<>();

        Query query = em.createQuery("SELECT p FROM Place p where p.type =:type");
        query.setParameter("type",typeE);
        listPlace = (List<Place>)query.getResultList();

        emp.clearEm();
        return listPlace;


    }




    public List<Place> getListPlaces(){

        emp.startNewEm();

        EntityManager em = emp.getCurrentEm();




        List<Place> listPlace = new ArrayList<>();

        Query query = em.createQuery("SELECT p FROM Place p");

        listPlace = (List<Place>)query.getResultList();

        emp.clearEm();
        return listPlace;


    }

    public Place findByid(Long id){

        emp.startNewEm();

        EntityManager entityManager = emp.getCurrentEm();


        Place place = entityManager.find(Place.class,id);




        return place;
    }








    public Boolean noPlace(String ident){

emp.startNewEm();

        EntityManager em = emp.getCurrentEm();


        List<Place> listPlace = em.createQuery(
                "SELECT p FROM Place p WHERE p.ident = :ident")
                .setParameter("ident", ident)
                .getResultList();


        emp.clearEm();
        return listPlace.isEmpty();

    }



    public Place getPlaceByName (String ident){

        emp.startNewEm();

        EntityManager em = emp.getCurrentEm();


        List<Place> listUser = em.createQuery(
                "SELECT p FROM Place p WHERE p.ident = :ident")
                .setParameter("ident", ident)
                .getResultList();



        emp.clearEm();


        return listUser.get(0);


    }

public Boolean isValuesNotNull(Place place){

    Boolean returnstatment = true;
    if(place.getName().equals("") || place.getCity().equals("") || place.getStreet().equals("") || String.valueOf(place.getNumber()).equals("")){
        returnstatment = false;
    }

    return returnstatment;
}





    public void pushPlace (Place place ){

        emp.startNewEm();
        EntityManager em = emp.getCurrentEm();

                emp.startTransaction();
        em.persist(place);

        emp.commitTransaction();

        emp.clearEm();





}

    public List<Place> getListPlacesByCityType(String type, String city) {

        emp.startNewEm();

        EntityManager em = emp.getCurrentEm();


        Type typeE = Type.valueOf(type);



        List<Place> listPlace;

        Query query = em.createQuery("SELECT p FROM Place p where p.city =:city and p.type =:type");
        query.setParameter("type",typeE);
        query.setParameter("city",city);
        listPlace = (List<Place>)query.getResultList();

        emp.clearEm();
        return listPlace;





    }
}



