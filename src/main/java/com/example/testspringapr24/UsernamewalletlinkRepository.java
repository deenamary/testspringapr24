package com.example.testspringapr24;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsernamewalletlinkRepository extends JpaRepository<Usernamewalletlink, String> {
    Usernamewalletlink findByUsername(String username);
}
