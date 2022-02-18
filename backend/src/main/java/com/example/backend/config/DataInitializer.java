package com.example.backend.config;

import com.example.backend.model.User;
import com.example.backend.model.dto.UserDto;
import com.example.backend.model.enums.Role;
import com.example.backend.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Component
public class DataInitializer {

    private final UserService userService;

    public DataInitializer(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void initAdmins() {
        Optional<User> user1 = userService.findUserByUsername("edvin12");
        Optional<User> user2 = userService.findUserByUsername("ivana18");
        if (user1.isEmpty() && user2.isEmpty()) {
            UserDto userDto1 = new UserDto("edvin12",
                    "Edvin",
                    "Lekovic",
                    "edvin",
                    "edvin",
                    Role.ADMIN);
            UserDto userDto2 = new UserDto("ivana18",
                    "Ivana",
                    "Pecakova",
                    "ivana",
                    "ivana",
                    Role.ADMIN);
            this.userService.register(userDto1);
            this.userService.register(userDto2);
        }
    }
}
