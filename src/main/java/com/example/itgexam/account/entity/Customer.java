package com.example.itgexam.account.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(length = 50, nullable = false)
    private String customerName;

    @NotNull
    @Size(max = 20)
    @Column(length = 20, nullable = false)
    private String customerMobile;

    @Email(message = "Email is required field")
    @Size(max = 50)
    @Column(length = 50)
    private String customerEmail;

    @Size(max = 100)
    @Column(length = 100)
    private String address1;

    @Size(max = 100)
    @Column(length = 100)
    private String address2;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "customer_id")
    private List<Account> accounts;
}
