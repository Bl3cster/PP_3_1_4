package ru.kata.spring.boot_security.demo.reposirory;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.Set;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByRole(String role);
    Set<Role> findAllByUsersId(long id);
}
