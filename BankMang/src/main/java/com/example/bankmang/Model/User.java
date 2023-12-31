package com.example.bankmang.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public  class User implements UserDetails  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(255)")
    private String userName;
    @Column(columnDefinition = "varchar(255)")
    private String password;
    @Column(columnDefinition = "varchar(255)")
    private String name;
@Column(columnDefinition = "varchar(255)")
    private String email;
    @Column(columnDefinition = "varchar(12) check(role='Customer' or role='employee' or role='admin')")
    private String role;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
    private Employee employee;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "users")
    private Customer customer;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.role));
    }

    @Override
    public String getUsername() {
        return userName;
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
