package by.nintendo.service;

import by.nintendo.Dao.UserDao;
import by.nintendo.entity.MyUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DetailsService implements UserDetailsService {
    private final UserDao userDao;

    public DetailsService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        MyUser us = userDao.findByLogin(login);

        if (us == null) {
            throw new UsernameNotFoundException("User not found");
        } else {
            UserDetails uss = User.builder()
                    .username(us.getLogin())
                    .password(us.getPassword())
                    .roles(us.getRole().getItem())
                    .build();
            return uss;
        }
    }
}
