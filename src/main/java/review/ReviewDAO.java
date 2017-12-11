package review;

import com.sun.org.apache.regexp.internal.RE;
import place.Place;
import restaurantcomment.services.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {

    EntityManagerProvider emp ;

    public ReviewDAO(EntityManagerProvider emp) {
        this.emp = emp;
    }



    public Review GetReview(Long id){


        emp.startNewEm();

        EntityManager em = emp.getCurrentEm();


       Review review = em.find(Review.class,id);

       emp.clearEm();
     return  review;
    }





    public void pushReview(Review review) {

        emp.startNewEm();
        EntityManager em = emp.getCurrentEm();

        emp.startTransaction();
        em.persist(review);

        emp.commitTransaction();

        emp.clearEm();


    }


    public List<Review> GetAllReview(Long id) {

        emp.startNewEm();

        EntityManager em = emp.getCurrentEm();


        List<Review> listReview = new ArrayList<>();

        Query query = em.createQuery("SELECT r FROM Review r where r.place_id =:id");
        query.setParameter("id", id);
        listReview = (List<Review>) query.getResultList();

        emp.clearEm();
        return listReview;


    }

    public void deleteReview(Long id){

        emp.startNewEm();

       EntityManager em = emp.getCurrentEm();

       emp.startTransaction();


        Query query = em.createQuery("delete from Review r where r.id =:id");
        query.setParameter("id", id).executeUpdate();






       emp.commitTransaction();

       emp.clearEm();









    }

}
