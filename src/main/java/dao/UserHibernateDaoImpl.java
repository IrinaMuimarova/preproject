package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.DBHelper;

import java.sql.ResultSet;
import java.util.List;

public class UserHibernateDaoImpl implements UserDAO {
    private Session session;

    private void openSession() {
        session = DBHelper.getInstance().getConfiguration().buildSessionFactory().openSession();
    }

    private void closeSession() {
        session.close();
    }


    @Override
    public List<User> getAll() {
        openSession();
        return (List<User>) session.createQuery("from User u").list();
    }

    @Override
    public void add(User user) {
        openSession();
        session.save(user);
        closeSession();
    }

    @Override
    public void delete(long id) {
        openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(getUserById(id));
        transaction.commit();
        closeSession();
    }

    @Override
    public User getUserById(Long id) {
        openSession();
        return session.get(User.class, id);
    }

    @Override
    public void update(User user) {
        openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        closeSession();
    }

    @Override
    public User getUserByLogin(String login) {
        openSession();
        Long id = (Long) session.createQuery("select id from User u where login = '" + login + "'").uniqueResult();
        if (id != null) {
            return session.get(User.class, id);
        }
        return null;
    }
}
