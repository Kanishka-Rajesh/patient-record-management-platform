package com.karthick.patientrecordmanagement.config;

import com.karthick.patientrecordmanagement.entity.Role;
import com.karthick.patientrecordmanagement.entity.User;
import com.karthick.patientrecordmanagement.repository.RoleRepository;
import com.karthick.patientrecordmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        Role adminRole = roleRepository.findByName("ADMIN")
                .orElseGet(() -> {
                    Role role = new Role();
                    role.setName("ADMIN");
                    return roleRepository.save(role);
                });

        if (!userRepository.existsByUsername("admin")) {

            User admin = new User();

            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(adminRole);

            userRepository.save(admin);

            System.out.println("==================================");
            System.out.println("Admin User Created");
            System.out.println("Username : admin");
            System.out.println("Password : admin123");
            System.out.println("==================================");
        }
    }
}