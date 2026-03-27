package com.diogosilva.walletcore.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diogosilva.walletcore.users.entities.UserCredentials;

import java.util.Optional;

public interface UserCreadentialRepository extends JpaRepository<UserCredentials, Long> { 
    Optional<UserCredentials> findByUsername(String username);
}