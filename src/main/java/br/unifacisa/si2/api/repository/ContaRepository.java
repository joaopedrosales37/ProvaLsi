package com.danielabella.rest.exemplo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielabella.rest.exemplo3.domain.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
