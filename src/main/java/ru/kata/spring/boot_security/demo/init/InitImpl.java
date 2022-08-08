package ru.kata.spring.boot_security.demo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitImpl implements Init {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public InitImpl(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

//    Загружаю в базу дефолтный набор юзеров
    @PostConstruct
    public void InitUserAndRole() {
        Set<User> users = userService.findAllUsers();

        if (users.isEmpty()) {
            Role admin = new Role("ROLE_ADMIN");
            Role user = new Role("ROLE_USER");
            Set<Role> adminRole = new HashSet<>();
            Set<Role> userRole = new HashSet<>();
            Set<Role> anyRole = new HashSet<>();
            adminRole.add(admin);
            userRole.add(user);
            anyRole.add(admin);
            anyRole.add(user);
            roleService.saveRole(admin);
            roleService.saveRole(user);
            userService.addUser(new User("Maha", "Smirnova", 33, "admin@mail.ru", "admin@mail.ru", adminRole));
            userService.addUser(new User("Misha", "Krokodilov", 24, "user@mail.ru", "user@mail.ru", userRole));
            userService.addUser(new User("Dima", "Borisov", 18, "dimab@mail.ru", "dimab@mail.ru", userRole));
            userService.addUser(new User("Vasya", "Pupkin", 16, "vasyap@mail.ru", "vasyap@mail.ru", userRole));
            userService.addUser(new User("Kostya", "Gradov", 52, "kostyag@mail.ru", "kostyag@mail.ru", anyRole));
        }
    }
}
