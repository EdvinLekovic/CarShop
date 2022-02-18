package com.example.backend.service.impl;

import com.example.backend.model.User;
import com.example.backend.model.dto.UserDto;
import com.example.backend.model.enums.Role;
import com.example.backend.model.exceptions.InvalidPasswordException;
import com.example.backend.model.exceptions.InvalidUsernameException;
import com.example.backend.model.exceptions.PasswordsDoNotMatchException;
import com.example.backend.model.exceptions.UsernameAlreadyExistsException;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.UserService;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> register(UserDto userDto) {

        if (userDto.getUsername() == null || userDto.getUsername().isEmpty())
            throw new InvalidUsernameException();

        if (userDto.getPassword() == null || userDto.getPassword().isEmpty())
            throw new InvalidPasswordException();

        if (this.userRepository.findById(userDto.getUsername()).isPresent()) {
            throw new UsernameAlreadyExistsException(userDto.getUsername());
        }

        if (!userDto.getPassword().equals(userDto.getRepeatPassword())) {
            throw new PasswordsDoNotMatchException();
        }

        return Optional.of(userRepository.save(new User(userDto.getUsername(),
                userDto.getName(),
                userDto.getLastName(),
                passwordEncoder.encode(userDto.getPassword()),
                userDto.getRole())));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return this.userRepository.findById(s).orElseThrow(() -> new UsernameNotFoundException(s));
    }

    public Optional<User> findUserByUsername(String username) {
        return this.userRepository.findById(username);
    }

    @Override
    public Optional<User> editUserInformation(UserDto userDto) {
        User user = userRepository.findById(userDto.getUsername()).orElseThrow();
        if (!userDto.getName().isEmpty()) {
            user.setName(userDto.getName());
        }
        if (!userDto.getLastName().isEmpty()) {
            user.setLastName(userDto.getLastName());
        }

        if (!userDto.getPassword().isEmpty() &&
                userDto.getPassword().equals(userDto.getRepeatPassword())) {
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }
        return Optional.of(userRepository.save(user));
    }
}
