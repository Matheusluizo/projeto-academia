package com.matheusluiz.treino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.matheusluiz.treino.domain.Treino;

public interface TreinoRepository extends JpaRepository<Treino, Integer>{

}
