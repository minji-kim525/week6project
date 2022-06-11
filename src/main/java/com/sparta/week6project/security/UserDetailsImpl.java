package com.sparta.week6project.security;

import com.sparta.week6project.model.User;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl  {

    private final User user;

    public UserDetailsImpl(User user) {

        this.user = user;
    }

    public User getUser() {

        return user;
    }

//    @Override
//    public String getUsername() {
//
//        return user.getUsername();
//    }
//
//    @Override
//    public String getPassword() {
//
//        return user.getPassword();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//
//        return true;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//
//        return Collections.emptyList();
//    }

}

