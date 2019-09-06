//package com.marvelfitness.portal.jwt;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.marvelfitness.portal.user.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class JwtUserDetails implements UserDetails {
//
//    private static final long serialVersionUID = 5155720064139820502L;
//
//    private final Integer user_id;
//    private final String username;
//    private final String password;
//    private final Collection<? extends GrantedAuthority> authorities;
//
//    public JwtUserDetails(Integer user_id, String username, String password, String role) {
//        this.user_id = user_id;
//        this.username = username;
//        this.password = password;
//
//        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
//                new SimpleGrantedAuthority(role.getName().name())
//        ).collect(Collectors.toList());
//
//        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
//        authorities.add(new SimpleGrantedAuthority(role));
//
//        this.authorities = authorities;
//    }
//
//    @JsonIgnore
//    public Integer getUser_id() {
//        return user_id;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @JsonIgnore
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @JsonIgnore
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @JsonIgnore
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @JsonIgnore
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//}