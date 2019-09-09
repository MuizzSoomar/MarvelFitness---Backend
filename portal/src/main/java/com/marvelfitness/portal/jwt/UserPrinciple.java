package com.marvelfitness.portal.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marvelfitness.portal.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserPrinciple implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Integer user_id;

    private String name;

    private String username;

    private short rewards_balance;

    private String street_one;

    private String street_two;

    private String city;

    private String state;

    private String zip;

    private boolean is_customer;



    @JsonIgnore
    private String password;

    private List<GrantedAuthority> authorities;

    public UserPrinciple(Integer user_id, String name, String username, short rewards_balance, String street_one,
                         String street_two, String city, String state, String zip, boolean isCustomer, String password,
                         List<GrantedAuthority> authorities) {
        this.user_id = user_id;
        this.name = name;
        this.username = username;
        this.rewards_balance = rewards_balance;
        this.street_one = street_one;
        this.street_two = street_two;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.is_customer = isCustomer;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrinciple build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());

        return new UserPrinciple(
                user.getUser_id(),
                user.getName(),
                user.getUsername(),
                user.getRewards_balance(),
                user.getStreet_one(),
                user.getStreet_two(),
                user.getCity(),
                user.getState(),
                user.getZip(),
                user.isCustomer(),
                user.getPassword(),
                authorities
        );
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public short getRewards_balance() { return rewards_balance; }

    public String getStreet_one() {
        return street_one;
    }

    public String getStreet_two() {
        return street_two;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public boolean isIs_customer() {
        return is_customer;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() { return username; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return authorities; }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(user_id, user.user_id);
    }
}
