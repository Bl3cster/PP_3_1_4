package ru.kata.spring.boot_security.demo.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kata.spring.boot_security.demo.model.User;

public interface Encoder {
    User passwordCoder(User user);
    PasswordEncoder passwordEncoder();
}
