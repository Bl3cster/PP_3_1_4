package ru.kata.spring.boot_security.demo.service;
//
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void updateUser(User user);

    List<User> findAllUsers();

    void removeUserById(long id);

    User findUserById(long id);

    User findByEmail (String email);
}
