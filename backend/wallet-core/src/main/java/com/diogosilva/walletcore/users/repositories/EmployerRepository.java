package com.diogosilva.walletcore.users.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.diogosilva.walletcore.users.entities.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
    Optional<Employer> findByNif(String nif);
}