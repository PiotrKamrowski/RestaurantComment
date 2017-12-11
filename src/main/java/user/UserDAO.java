package user;

import restaurantcomment.services.EntityManagerProvider;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.EntityManager;
import java.security.Key;
import java.util.Base64;
import java.util.List;

public class UserDAO {


    private EntityManagerProvider emp;

    public UserDAO(EntityManagerProvider entityManagerProvider) {
        this.emp = entityManagerProvider;
    }


    public void pushUser(User user) {

        emp.startNewEm();
        EntityManager em = emp.getCurrentEm();

        emp.startTransaction();

        em.persist(user);

        emp.commitTransaction();

        emp.clearEm();

        emp.closeJpa();

    }


    public List<User> getAll(){


        emp.startNewEm();
        EntityManager em = emp.getCurrentEm();

      List<User> listOfUsers = em.createQuery("select u from User u").getResultList();

        return listOfUsers;
    }


    public User getUserById(long id) {

        emp.startNewEm();
        EntityManager em = emp.getCurrentEm();

        User user = em.find(User.class, id);

        em.clear();

        em.close();

        return user;
    }


    public String encrypt(String password) {

        String encryptedPassword = "";
        try {

            String key = "770A8A65EE253014";

            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");


            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(password.getBytes());
            encryptedPassword = (new String(encrypted));


            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encVal = cipher.doFinal(password.getBytes());
            encryptedPassword = new BASE64Encoder().encode(encVal);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedPassword;
    }


    public String decrypt(String password) {

        String decrypted = "";

        try {

            String key = "770A8A65EE253014";

            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");


            cipher.init(Cipher.DECRYPT_MODE, aesKey);

            byte[] decordedValue = new BASE64Decoder().decodeBuffer(password);
            byte[] decValue = cipher.doFinal(decordedValue);
            decrypted = new String(decValue);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return decrypted;
    }


    public Boolean isValuesNotNull(User user) {

        Boolean returnstatment = true;
        if (user.getName().equals("") || user.getLastname().equals("") || user.getCity().equals("") || user.getPassword().equals("")
                || user.getNick().equals("")) {
            returnstatment = false;
        }

        return returnstatment;

    }


    public Boolean noUser(String nick) {


        emp.startNewEm();

        EntityManager em = emp.getCurrentEm();


        List<User> listUser = em.createQuery(
                "SELECT u FROM User u WHERE u.nick = :nick")
                .setParameter("nick", nick)
                .getResultList();


        emp.clearEm();
        return listUser.isEmpty();


    }

    public User userByNick(String nick) {

        emp.startNewEm();

        EntityManager em = emp.getCurrentEm();


        List<User> listUser = em.createQuery(
                "SELECT u FROM User u WHERE u.nick = :nick")
                .setParameter("nick", nick)
                .getResultList();


        emp.clearEm();


        return listUser.get(0);
    }


    public void deleteUserByNick(String nick) {

        emp.startNewEm();

        EntityManager em = emp.getCurrentEm();
        emp.startTransaction();

        em.createQuery(
                "DELETE  FROM User u WHERE u.nick = :nick")
                .setParameter("nick", nick).executeUpdate();

        emp.commitTransaction();

        emp.clearEm();

        emp.closeJpa();

    }


}
