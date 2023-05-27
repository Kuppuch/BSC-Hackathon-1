package com.kuppuch.KuppuchBot.repository;

import com.kuppuch.KuppuchBot.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SearchRepository extends JpaRepository<User, Long> {

}
