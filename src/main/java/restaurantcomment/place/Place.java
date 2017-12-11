package restaurantcomment.place;

import lombok.Data;
import restaurantcomment.review.Review;

import javax.persistence.*;


import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;


@Data
@Entity
@Table(name = "places")
public class Place {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;
    private String city;
    private String street;
    private String number;
    private boolean delivery;
    private String www;

    @Enumerated(EnumType.STRING)
    private Type type;

    private Long created_by;

    @Transient
    private String date;

    private String datestamp;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "place_id", cascade = CascadeType.ALL)
    private List<Review> reviewList;

    private String ident;

    public String getDate() {

        String date = this.datestamp.substring(0, 10);

        return date;
    }

}

