package restaurantcomment.service;


import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String reporting;
    private Long reported_by;
    private Long reported_place;


}
