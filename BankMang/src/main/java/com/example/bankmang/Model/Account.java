package com.example.bankmang.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertFalse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "int")
    private Integer accountNumber;
    private double balance;
    @AssertFalse
    @Column(columnDefinition = "Boolean")
    private  Boolean asActive;
    @ManyToOne
    @JoinColumn(name = "cus_id",referencedColumnName = "id")
    @JsonIgnore
    private Customer customer;

}
