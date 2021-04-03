package by.nintendo.Dao;

import by.nintendo.entity.MyUser;
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

    public void save(MyUser user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }

    @Transactional(readOnly = true)
    public MyUser findById(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.find(MyUser.class, id);
    }

    public void deleteUser(MyUser user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(user);
    }

    @Transactional(readOnly = true)
    public List<MyUser> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        return
                currentSession
                        .createQuery("from MyUser ", MyUser.class)
                        .getResultList();
    }

    @Transactional(readOnly = true)
    public MyUser findByLogin(String login) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession
                .createQuery("from MyUser where login = :login", MyUser.class)
                .setParameter("login", login)
                .getSingleResult();
    }
}
