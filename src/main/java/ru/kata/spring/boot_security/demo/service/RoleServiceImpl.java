package ru.kata.spring.boot_security.demo.service;
//

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.reposirory.RoleRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findBiId(int id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public Role findByRole(String role) {
        return roleRepository.findByRole(role);
    }

    @Override
    public Set<Role> findAllRoles() {
        return new HashSet<>(roleRepository.findAll(Sort.by(Sort.Direction.ASC, "role")));
    }

    @Transactional
    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Transactional
    @Override
    public void saveAll(Set<Role> roles) {
        roleRepository.saveAll(roles);
    }


}
