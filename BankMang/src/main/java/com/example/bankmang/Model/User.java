package com.example.bankmang.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userName;

    private String password;

    private String name;

    private String email;
    @Column(columnDefinition = "varchar(12) check(role='Customer' or role='employee')")
    private String role;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
    @PrimaryKeyJoinColumn
    private Employee employee;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "users")
    @PrimaryKeyJoinColumn
    private Customer customer;
}
