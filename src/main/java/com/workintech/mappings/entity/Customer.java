package com.workintech.mappings.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customer" , schema = "fsweb")
public class Customer {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "salary")
    @NotNull
    private double salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
    private List<Account> accountList = new ArrayList<>();

    public void addAccount(Account account){
        if(accountList == null){
            accountList = new ArrayList<>();
        }
        accountList.add(account);
    }

}
