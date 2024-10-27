package com.projeto_DIO.api_demoDIO.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto_DIO.api_demoDIO.model.User;

public interface UserRepository extends JpaRepository<User, Long> {}
