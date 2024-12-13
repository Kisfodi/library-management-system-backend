package org.ppke.itk.librarymanagementsystembackend.controller.dto;

import lombok.Data;
import org.ppke.itk.librarymanagementsystembackend.repository.implementations.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;
import java.util.stream.Collectors;

@Data
public class UserDataDto {

    private String username;
//    private String email;
    private Set<Role> roles;

    public UserDataDto(UserDetails userDetails) {
        this.username = userDetails.getUsername();
        this.roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .map(Role::valueOf)
                .collect(Collectors.toSet());
    }


}
