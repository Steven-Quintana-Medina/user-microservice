package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class PrincipalUser implements UserDetails {

    private String mail;
    private String rol;

    public PrincipalUser(String email, String rol ){
        this.mail = email;
        this.rol = rol;
    }

    public static PrincipalUser build(UserEntity user, String rol) {
        return new PrincipalUser(user.getMail(), rol);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(rol));
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
