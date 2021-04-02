package by.nintendo.Dao;

import by.nintendo.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDao {
    private final SessionFactory sessionFactory;

    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save (User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }
    @Transactional(readOnly = true)
    public User findById (long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.find(User.class, id);
    }

    public void deleteUser (User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(user);
    }

    @Transactional(readOnly = true)
    public List<User> findAll () {
        Session currentSession = sessionFactory.getCurrentSession();
        return
                currentSession
                        .createQuery("from User", User.class)
                        .getResultList();
    }
    @Transactional(readOnly = true)
    public User findByLogin (String login) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession
                .createQuery("from User where login = :login", User.class)
                .setParameter("login", login)
                .getSingleResult();
    }
}
