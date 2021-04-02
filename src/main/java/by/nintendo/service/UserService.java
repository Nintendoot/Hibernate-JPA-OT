package by.nintendo.service;

import by.nintendo.Dao.UserDao;
import by.nintendo.entity.User;
import by.nintendo.exception.NotAllDataEnteredException;
import by.nintendo.exception.UserAlreadyExistsException;
import by.nintendo.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(User user) {
        if (!user.getLogin().equals("") && !user.getPassword().equals("")) {
            List<User> allUsers = userDao.findAll();
            boolean b = allUsers.stream().
                    anyMatch(x -> x.getLogin().equals(user.getLogin()));
            if (b) {
                throw new UserAlreadyExistsException("User already exists");
            } else {
                userDao.save(user);
            }
        } else {
            throw new NotAllDataEnteredException("Not all data entered");
        }
    }

    public User findById(long id) {
        List<User> allUsers = userDao.findAll();
        boolean b = allUsers.stream().
                anyMatch(x -> x.getId() == id);
        if (b) {
            return userDao.findById(id);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    public void deleteUser(User user) {
        List<User> allUsers = userDao.findAll();
        boolean b = allUsers.stream().
                anyMatch(x -> x.getLogin().equals(user.getLogin()));
        if (b) {
            userDao.deleteUser(userDao.findByLogin(user.getLogin()));
        } else {
            throw new UserNotFoundException("There is no such user.");
        }
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findByLogin(String login) {
        if (!login.isEmpty()) {
            List<User> allUsers = userDao.findAll();
            boolean b = allUsers.stream().
                    anyMatch(x -> x.getLogin().equals(login));
            if (b) {
                return userDao.findByLogin(login);
            } else {
                throw new UserNotFoundException("User not found");
            }
        } else {
            throw new NotAllDataEnteredException("Not data entered");
        }
    }
}
