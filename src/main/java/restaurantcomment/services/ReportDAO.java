package restaurantcomment.services;

import javax.persistence.EntityManager;

public class ReportDAO {


    private EntityManagerProvider emp ;

    public ReportDAO(EntityManagerProvider entityManagerProvider){
        entityManagerProvider = this.emp;
    }


    public void inputReport(Report report){

        emp.startNewEm();

        EntityManager em = emp.getCurrentEm();

        emp.startTransaction();

        em.persist(report);

        emp.commitTransaction();

        emp.clearEm();



    }









}
