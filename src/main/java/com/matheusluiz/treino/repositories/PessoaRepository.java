package com.matheusluiz.treino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusluiz.treino.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
