package com.drAppointments.Final.Project.service;

import com.drAppointments.Final.Project.model.dao.UserSec;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserDetailsService implements UserDetails {

    private UserSec userSec;

    public UserDetailsService(UserSec userSec) {
        this.userSec = userSec;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(userSec.getRole().getDisplayValue()));
    }

    @Override
    public String getPassword() {
        return userSec.getPassword();
    }

    @Override
    public String getUsername() {
        return userSec.getLogin();
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
        return userSec.isEnabled();
    }
}
