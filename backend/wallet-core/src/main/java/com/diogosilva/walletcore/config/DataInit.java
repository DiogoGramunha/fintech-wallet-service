package com.diogosilva.walletcore.config;

import com.diogosilva.walletcore.users.entities.Admin;
import com.diogosilva.walletcore.users.entities.Employer;
import com.diogosilva.walletcore.users.entities.options.Roles;
import com.diogosilva.walletcore.users.repositories.AdminRepository;
import com.diogosilva.walletcore.users.repositories.EmployerRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInit {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner initDatabase(AdminRepository adminRepo, 
                                    EmployerRepository employerRepo, 
                                    PasswordEncoder passwordEncoder) {
        return args -> {
            if (adminRepo.count() == 0) {
                
                Employer boss = new Employer();
                boss.setName("Admin Master");
                boss.setNif("000000000");
                boss.setRole(Roles.SUPER_ADMIN);
                employerRepo.save(boss);

                Admin admin = new Admin();
                admin.setEmployer(boss);
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123"));
                adminRepo.save(admin);
                
                System.out.println("-----------------------------------------");
                System.out.println(">>> ADMIN INICIAL CRIADO: user: admin / pass: admin123");
                System.out.println("-----------------------------------------");
            }
        };
    }
}