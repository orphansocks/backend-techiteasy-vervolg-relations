package nl.novi.techiteasy1121.services;



import nl.novi.techiteasy1121.dtos.user.UserDto;
import nl.novi.techiteasy1121.models.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


// VOEG DE JUISTE ANNOTATIE TOE IN DIT GEVAL SERVICE
@Service
public class CustomUserDetailsService implements UserDetailsService {

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    private final UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) {
        UserDto userDto = userService.getUser(username);


        String password = userDto.getPassword();

        Set<Authority> authorities = userDto.getAuthorities();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority: authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }

        return new org.springframework.security.core.userdetails.User(username, password, grantedAuthorities);
    }

}