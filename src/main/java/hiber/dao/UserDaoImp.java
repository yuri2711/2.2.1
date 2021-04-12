package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

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
    public User getUser(int series_car) {
        Query<User> user = sessionFactory.getCurrentSession().createQuery("SELECT u from User u WHERE u.car.series = :ser").setParameter("ser", series_car);
//        user.setParameter("series_n", series_car);

        System.out.println(user.getSingleResult().getCar().getModel());

        return null;
    }

}
