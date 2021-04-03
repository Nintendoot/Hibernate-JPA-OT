package by.nintendo.service;

import by.nintendo.Dao.UserDao;
import by.nintendo.entity.MyUser;
import by.nintendo.entity.Role;
import by.nintendo.exception.NotAllDataEnteredException;
import by.nintendo.exception.UserAlreadyExistsException;
import by.nintendo.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;

    private final UserDao userDao;

    public UserService(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(MyUser user) {
            List<MyUser> allUsers = userDao.findAll();
            boolean b = allUsers.stream().
                    anyMatch(x -> x.getLogin().equals(user.getLogin()));
            if (b) {
                throw new UserAlreadyExistsException("User already exists");
            } else {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                user.setRole(Role.USER);
                userDao.save(user);
            }

    }

    public MyUser findById(long id) {
        List<MyUser> allUsers = userDao.findAll();
        boolean b = allUsers.stream().
                anyMatch(x -> x.getId() == id);
        if (b) {
            return userDao.findById(id);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    public void deleteUser(MyUser user) {
        List<MyUser> allUsers = userDao.findAll();
        boolean b = allUsers.stream().
                anyMatch(x -> x.getLogin().equals(user.getLogin()));
        if (b) {
            userDao.deleteUser(userDao.findByLogin(user.getLogin()));
        } else {
            throw new UserNotFoundException("There is no such user.");
        }
    }

    public List<MyUser> findAll() {
        return userDao.findAll();
    }

    public MyUser findByLogin(String login) {
        if (!login.isEmpty()) {
            List<MyUser> allUsers = userDao.findAll();
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
