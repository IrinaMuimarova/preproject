package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.DbConnectorHibernate;

import java.util.List;

public class UserHibernateDaoImpl implements UserDAO {


    @Override
    public List<User> getAll() {
        Session session = DbConnectorHibernate.getSessionFactory().openSession();
        return (List<User>) session.createQuery("from User u").list();
    }

    @Override
    public void add(User user) {
        Session session = DbConnectorHibernate.getSessionFactory().openSession();
        session.save(user);
        session.close();
    }

    @Override
    public void delete(long id) {
        Session session = DbConnectorHibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(getUserById(id));
        transaction.commit();
        session.close();
    }

    @Override
    public User getUserById(Long id) {
        Session session = DbConnectorHibernate.getSessionFactory().openSession();
        return session.get(User.class, id);
    }

    @Override
    public void update(User user) {
        Session session = DbConnectorHibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }
}
