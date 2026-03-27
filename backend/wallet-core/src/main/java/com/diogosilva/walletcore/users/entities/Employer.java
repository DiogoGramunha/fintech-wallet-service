package com.diogosilva.walletcore.users.entities;

import com.diogosilva.walletcore.users.entities.options.Roles;
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
@Table(name = "employers")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employer")
    private Long id;

    @Column(name = "complete_name", nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String nif;

    @Enumerated(EnumType.STRING)
    @Column(name = "employer_role", nullable = false)
    private Roles role;

    // Bi-directional relationship with Admin, so i can search for a password related to a nif.
    @OneToOne(mappedBy = "employer", cascade = CascadeType.ALL)
    private Admin admin;

    // Default constructor
    public Employer() {
    }

    // Constructor with validation
    public Employer(String name, String nif, Roles role) {
        this.name = name;
        if (Utils.validateNif(nif)) {
            this.nif = nif;
        } else {
            throw new IllegalArgumentException("NIF inválido. Deve conter exatamente 9 dígitos numéricos.");
        }
        this.role = role;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNif() {
        return nif;
    }

    public Roles getRole() {
        return role;
    }
    
    public Admin getAdmin() {
        return admin;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNif(String nif) {
        if (Utils.validateNif(nif)) {
            this.nif = nif;
        } else {
            throw new IllegalArgumentException("NIF inválido. Deve conter exatamente 9 dígitos numéricos.");
        }
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

}
