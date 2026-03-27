package com.diogosilva.walletcore.users.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diogosilva.walletcore.users.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNif(String nif);
}