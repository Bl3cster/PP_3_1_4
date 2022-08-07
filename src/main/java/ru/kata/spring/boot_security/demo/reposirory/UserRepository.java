package ru.kata.spring.boot_security.demo.reposirory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    void deleteById(long id);

    User findUserById(long id);

    UserDetails findUserByEmail(String email);

    User findByEmail(String email);

}
