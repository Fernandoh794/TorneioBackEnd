package com.example.demo.repository;

import com.example.demo.entity.Torneio;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TorneioRepository extends JpaRepository<Torneio, Long> {




}

