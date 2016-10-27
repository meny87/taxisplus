package com.menulabs.taxisplus.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.menulabs.taxisplus.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByEmail(String email);
}
