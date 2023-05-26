package com.kuppuch.KuppuchBot.repository;

import com.kuppuch.KuppuchBot.domain.entity.LoginUser;
import com.kuppuch.KuppuchBot.domain.entity.Role;
import com.kuppuch.KuppuchBot.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoginUserRepository extends JpaRepository<LoginUser, Long> {
    Optional<List<LoginUser>> findAllByUser(User user);
}
