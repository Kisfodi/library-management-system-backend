package org.ppke.itk.librarymanagementsystembackend.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ppke.itk.librarymanagementsystembackend.controller.dto.UserDto;
import org.ppke.itk.librarymanagementsystembackend.domain.User;
import org.ppke.itk.librarymanagementsystembackend.repository.interfaces.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Tag(name = "User")
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("")
    public List<UserDto> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserDto::fromUser)
                .toList();
    }

    @GetMapping("/{username}")
    public UserDto getUser(@PathVariable("username") String username) {

        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            return UserDto.fromUser(user.get());
        } else {
            throw new NoSuchElementException("User with name " + username + " not found");
        }

    }
}
