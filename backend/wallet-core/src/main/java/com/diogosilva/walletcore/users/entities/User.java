package com.diogosilva.walletcore.users.entities;

import com.diogosilva.walletcore.users.entities.options.AccountTypes;
import com.diogosilva.walletcore.utils.Utils;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int age;
    
    @Column(nullable = false, unique = true)
    private String nif;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountTypes accountType;

    @Column(name = "afiliation_date", nullable = false)
    private java.time.LocalDateTime afiliationDate;

    // Bi-directional relationship with UserCredentials, so i can search for a password related to a nif.
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserCredentials credentials;

    // Default constructor
    public User() {}

    // Constructor with all fields except ID and afiliationDate
    public User(String name, int age, String nif, AccountTypes accountType) {
        this.name = name;
        this.age = age;
        if (Utils.validateNif(nif)){
            this.nif = nif;
        } else {
            throw new IllegalArgumentException("Invalid NIF format");
        }
        this.accountType = accountType;
        this.afiliationDate = java.time.LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNif() {
        return nif;
    }

    public AccountTypes getAccountType() {
        return accountType;
    }

    public java.time.LocalDateTime getAfiliationDate() {
        return afiliationDate;
    }

    public UserCredentials getCredentials() {
        return credentials;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNif(String nif) {
        if (Utils.validateNif(nif)){
            this.nif = nif;
        } else {
            throw new IllegalArgumentException("Invalid NIF format");
        }
    }

    public void setAccountType(AccountTypes accountType) {
        this.accountType = accountType;
    }
    
    public void setAfiliationDate(java.time.LocalDateTime afiliationDate) {
        this.afiliationDate = afiliationDate;
    }

    public void setCredentials(UserCredentials credentials) {
        this.credentials = credentials;
    }
}
