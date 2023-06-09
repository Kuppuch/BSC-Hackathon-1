package com.kuppuch.KuppuchBot.repository;

import com.kuppuch.KuppuchBot.domain.entity.Chat;
import com.kuppuch.KuppuchBot.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    Optional<List<Chat>> findChatsByRole(Role role);
}
