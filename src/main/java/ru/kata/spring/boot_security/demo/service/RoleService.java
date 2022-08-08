package ru.kata.spring.boot_security.demo.service;
//
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.Set;
import java.util.List;

public interface RoleService {
    Role findBiId(int id);

    Role findByRole(String role);

    Set<Role> findAllRoles();

    void saveRole(Role role);

    void saveAll(Set<Role> roles);
}
