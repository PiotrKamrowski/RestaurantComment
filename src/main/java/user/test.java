package user;

import com.sun.org.apache.regexp.internal.RE;
import place.Place;
import place.PlaceDAO;
import place.Type;
import restaurantcomment.services.EntityManagerProvider;
import review.Review;
import review.ReviewDAO;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;

public class test {


    public static void main(String[] args) {

        EntityManagerProvider entityManagerProvider = new EntityManagerProvider();
        UserDAO userDAO = new UserDAO(entityManagerProvider);
        PlaceDAO placeDAO = new PlaceDAO(entityManagerProvider);
        ReviewDAO reviewDAO = new ReviewDAO(entityManagerProvider);

            User user = userDAO.getUserById(10l);


        Review review = reviewDAO.GetReview(12l);


        Place place = placeDAO.findByid(review.getPlace_id());

        System.out.println(place.getName());

        }


      /*      List<Place> a = user.getListAdded();

       *//* Set<Review> g = user.getReviewsAdded();
*//*
        for(Place v : a){
            System.out.println(v.getName());
        }

        for(Review r :g){
            System.out.println(r.getReview());
        }*/

    /* User user = userDAO.userByNick("franio");

        System.out.println(user.getAge());
        System.out.println(user.getPassword());*/

/*
        user.setCity("gdansk");
        user.setBirth("1998-8-05");
        user.setGender(Gender.FEMALE);
        user.setNick("blabla");
        user.setLastname("lolek");
        user.setName("bolek");


        userDAO.pushUser(user);*/


    }


