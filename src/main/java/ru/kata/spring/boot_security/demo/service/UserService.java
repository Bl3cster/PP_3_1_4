package ru.kata.spring.boot_security.demo.service;
//
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Set;

public interface UserService extends UserDetailsService {

    void addUser(User user);

    void updateUser(User user);

    Set<User> findAllUsers();

    void removeUserById(long id);

    User findUserById(long id);

    User findByEmail (String email);

    UserDetails loadUserByUsername(String email);
}
