package by.nintendo.service;

import by.nintendo.Dao.UserDao;
import by.nintendo.entity.MyUser;
import by.nintendo.entity.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean findByLogin(String login) {
        List<MyUser> allUsers = userDao.findAll();
        boolean b = allUsers.stream().
                anyMatch(x -> x.getLogin().equals(login));
        return b;
    }

    public void saveUser(MyUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        userDao.save(user);
    }
}
