package com.kuppuch.KuppuchBot.repository;

import java.util.Optional;

import com.kuppuch.KuppuchBot.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByPostAddress(String email);
}
