package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.reposirory.RoleRepository;
import ru.kata.spring.boot_security.demo.reposirory.UserRepository;
import ru.kata.spring.boot_security.demo.security.Encoder;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final RoleRepository roleRepository;

    private final UserRepository userRepository;
    private final Encoder encoder;

    @Autowired
    public UserServiceImpl(RoleRepository roleRepository, UserRepository userRepository, Encoder encoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userRepository.save(encoder.passwordCoder(user));
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        if (user.getPassword() == null ||
                user.getPassword().equals("") ||
                user.getPassword().equals(findUserById(user.getId()).getPassword())) {
            user.setPassword(findUserById(user.getId()).getPassword());
        } else {
            encoder.passwordCoder(user);
        }
        userRepository.save(user);
    }

    @Override
    public Set<User> findAllUsers() {
        return new HashSet<>(userRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
    }

    @Transactional
    @Override
    public void removeUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id).get();
    }
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        user.setRoles(roleRepository.findAllByUsersId(user.getId()));
        return user;
    }
}
