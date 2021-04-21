package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private final SessionFactory sessionFactory;

    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {

        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> listUsers() {
        Query<User> query = sessionFactory.getCurrentSession().createQuery("select u from User u");
        return query.getResultList();
    }

    @Override
    public User getUser(String model, int seriesCar) {
        Query<User> user = null;

        try {
            user = sessionFactory.getCurrentSession()
                    .createQuery("SELECT u from User u WHERE u.car.series = :ser and u.car.model = :mod")
                    .setParameter("ser", seriesCar)
                    .setParameter("mod", model);
            return user.getSingleResult();
        }catch (NoResultException e){
            System.out.println("Не найден элемент");
            return null;
        }
    }

}
