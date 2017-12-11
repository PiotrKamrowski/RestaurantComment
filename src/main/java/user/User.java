package user;


import lombok.Data;
import place.Place;
import review.Review;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long userId;

    private String nick;

    private String name;

    private String lastname;

    @Column(name = "user_pas")
    private String password;

    private String city;

    private String birth;


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "posted_by",cascade = CascadeType.ALL)
    protected List<Review> reviewsAdded;




    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Transient
    private Long  age;

    public int getReviewsAdd() {
       int buffor = reviewsAdded.size();

       this.reviewsAdd  = buffor;

        return reviewsAdd;
    }

    public void setReviewsAdd(int reviewsAdd) {
        this.reviewsAdd = reviewsAdd;
    }

    @Transient
    private int   reviewsAdd;

    public Long getAge() {

        String[] buffor = birth.split("-");


        LocalDate start = LocalDate.of(Integer.valueOf(buffor[0]),Integer.valueOf(buffor[1]),Integer.valueOf(buffor[2]));
        LocalDate end = LocalDate.now();
        Long age = ChronoUnit.YEARS.between(start, end);



        return age;
    }
}
