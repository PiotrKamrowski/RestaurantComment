package review;


import lombok.Data;
import place.Place;
import place.PlaceDAO;
import restaurantcomment.services.EntityManagerProvider;
import user.User;
import user.UserDAO;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private Long place_id;

    private Long posted_by;

    private String review;

    private Boolean delivery;

    private String delivery_time;

    private String datestamp;
    @Transient
    private String date;

    @Transient
    private String username;

    @Transient
    private String namePlace;

    @Enumerated(EnumType.STRING)
    private Mark overal_mark;


    public String getDate() {

        String date = this.datestamp.substring(0, 10);

        return date;
    }

    public String getUsername() {

        EntityManagerProvider entityManagerProvider = new EntityManagerProvider();

        UserDAO userDAO = new UserDAO(entityManagerProvider);

        User user = userDAO.getUserById(this.posted_by);


        return user.getNick();
    }

    public String getNamePlace() {
        EntityManagerProvider entityManagerProvider = new EntityManagerProvider();

        PlaceDAO placeDAO = new PlaceDAO(entityManagerProvider);

        Place place = placeDAO.findByid(this.place_id);

        this.namePlace = place.getName();


        return namePlace;
    }

}


