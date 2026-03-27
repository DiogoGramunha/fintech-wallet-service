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
@Table(name = "user_credentials")
public class UserCredentials {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_credential")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "password_hash", nullable = false)
    private String password;

    @Column(name = "last_login")
    private java.time.LocalDateTime lastLogin;

    // Default constructor
    public UserCredentials() {}

    // Constructor with all fields except ID and lastLogin
    public UserCredentials(User user, String username, String password) {
        this.user = user;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return user.getId();
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

    public User getUser() {
        return user;
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

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
