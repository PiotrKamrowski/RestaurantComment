package restaurantcomment.place;

import restaurantcomment.service.EntityManagerProvider;

public class Test {


    public static void main(String[] args) {

        EntityManagerProvider entityManagerProvider = new EntityManagerProvider();

        PlaceDAO placeDAO = new PlaceDAO(entityManagerProvider);

        placeDAO.findById(7l);


    }


}
