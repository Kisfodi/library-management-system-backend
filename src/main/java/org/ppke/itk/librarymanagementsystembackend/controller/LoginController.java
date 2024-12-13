package org.ppke.itk.librarymanagementsystembackend.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.ppke.itk.librarymanagementsystembackend.controller.dto.UserDataDto;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name = "Login")
@RestController
@RequestMapping("api/auth")
public class LoginController {

    @GetMapping(path = "/get-user-data")
    public UserDataDto getUserData() {
        return getCurrentUser()
                .map(UserDataDto::new)
                .orElseThrow(() -> new AuthenticationCredentialsNotFoundException(null));
    }

    public static Optional<UserDetails> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return Optional.of(((UserDetails) authentication.getPrincipal()));
        }
        return Optional.empty();
    }

    @GetMapping(path = "/logout")
    public void logout() {
        SecurityContextHolder.clearContext();
    }
}
