package restaurantcomment.services;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reporting;
    private Long repoted_by;
    private Long reported_place;







}
