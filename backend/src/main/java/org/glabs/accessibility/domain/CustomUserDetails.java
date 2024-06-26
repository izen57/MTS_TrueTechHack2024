package org.glabs.accessibility.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class CustomUserDetails implements UserDetails {
    private UUID id;
    private String login;
    private String password;
    private UserIn userIn;
    private boolean accountIsNotExpired;
    private boolean accountIsNotLocked;
    private boolean credentialsAreNotExpired;
    private boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Returns user name
     */
    @Override
    public String getUsername() {
        return login;
    }

    public UserIn getUserIn() {
        return userIn;
    }

    public void setUserIn(UserIn userIn) {
        this.userIn = userIn;
    }

    /**
     * Returns account expiration status
     */
    @Override
    public boolean isAccountNonExpired() {
        return accountIsNotExpired;
    }

    /**
     * Returns account lock status
     */
    @Override
    public boolean isAccountNonLocked() {
        return accountIsNotLocked;
    }

    /**
     * Returns credentials expiration status
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsAreNotExpired;
    }

    /**
     * Returns account enabled status
     */
    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
