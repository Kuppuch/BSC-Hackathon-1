package com.kuppuch.KuppuchBot.repository;

import java.util.Optional;

import com.kuppuch.KuppuchBot.domain.entity.User;
import org.checkerframework.checker.nullness.Opt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByPostAddress(String email);
    Optional<User> findUserByTelegrammId(String tgID);

    Optional<List<User>> findUserByFirstName(String name);

    Optional<List<User>> findUserByLastName(String name);
}
