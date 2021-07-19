package com.icia.mjcinema.security;

import com.icia.mjcinema.domain.Authority;
import com.icia.mjcinema.domain.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
public class CustomerUserDetails implements UserDetails {
        private final Long id;
        private final String username;
        private final String password;
        private final String email;
        private final String name;
        private final List<GrantedAuthority> authorities = new ArrayList<>();

    public CustomerUserDetails(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.name =  user.getName();

        for (Authority authority : user.getAuthorities()) {
            this.authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
