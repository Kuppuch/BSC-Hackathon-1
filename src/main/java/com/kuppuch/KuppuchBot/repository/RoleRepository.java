package com.kuppuch.KuppuchBot.repository;

import com.kuppuch.KuppuchBot.domain.entity.Role;
import com.kuppuch.KuppuchBot.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findRoleById(long id);
    Optional<Role> findRoleByUserId(long id);
}
