package com.diogosilva.walletcore.users.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_employer", nullable = false)
    private Employer employer;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "password_hash", nullable = false)
    private String password;

    @Column(name = "last_login")
    private java.time.LocalDateTime lastLogin;

    // Default constructor
    public Admin() {}

    // Constructor with all fields except ID and lastLogin
    public Admin(Employer employer, String username, String password) {
        this.employer = employer;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public Long getEmployerId() {
        return employer.getId();
    }

    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }

    public java.time.LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setLastLogin(java.time.LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
