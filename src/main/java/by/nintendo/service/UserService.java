package by.nintendo.service;

import by.nintendo.Dao.UserDao;
import by.nintendo.entity.User;
import by.nintendo.exception.NotAllDataEnteredException;
import by.nintendo.exception.UserAlreadyExistsException;
import by.nintendo.exception.UserNotFoundException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(User user) {
        if (user.getLogin() != null && user.getPassword() != null) {
            List<User> allUsers = userDao.findAll();
            boolean b = allUsers.stream().
                    anyMatch(x -> x.getLogin().equals(user.getLogin()));
            if (b) {
                throw new UserAlreadyExistsException("User already exists");
            } else {
                userDao.save(user);
            }
        } else{
            throw new NotAllDataEnteredException("Not all data entered");
        }


    }

    public User findById(long id) {
        User byId = userDao.findById(id);
        if (byId != null) {
            return byId;
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    public void deleteUser(User user) {
        List<User> allUsers = userDao.findAll();
        boolean b = allUsers.stream().
                anyMatch(x -> x.equals(user));
        if (b) {
            userDao.deleteUser(user);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findByLogin(String login) {
        User byLogin = userDao.findByLogin(login);
        if (byLogin != null) {
            return byLogin;
        } else {
            throw new UserNotFoundException("User not found");
        }
    }
}
