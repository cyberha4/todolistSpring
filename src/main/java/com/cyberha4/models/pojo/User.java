package com.cyberha4.models.pojo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name="users")
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "login")
    private String login;
    @Column
    private String name;

    @Transient
    private String username;

    @Column(name = "password")
    private String password;
    @Column
    private String role;

    @Transient
    private List<GrantedAuthority> roleList;

    @Column
    private String email;
    @Column
    private Boolean enabled;

    public User(int id, String login, String password, List<GrantedAuthority> roleList) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.roleList = roleList;
    }

    public List<GrantedAuthority> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<GrantedAuthority> roleList) {
        this.roleList = roleList;
    }

    public User(int id, String login, String password, String role, String email) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    public User(int id, String login, String password, String name, String role, String email, Boolean enabled) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.name = name;
        this.email = email;
        this.enabled = enabled;
    }

    public User(String login, String password, String name, String role, String email, Boolean enabled) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.name = name;
        this.email = email;
        this.enabled = enabled;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return roleList;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
