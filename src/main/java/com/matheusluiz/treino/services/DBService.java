package com.matheusluiz.treino.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusluiz.treino.domain.Pessoa;
import com.matheusluiz.treino.domain.Treino;
import com.matheusluiz.treino.repositories.PessoaRepository;
import com.matheusluiz.treino.repositories.TreinoRepository;

@Service
public class DBService {

	@Autowired
	private TreinoRepository treinoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public void instanciaDB() {

		Pessoa p1 = new Pessoa(null, "064.482.150-95", "Matheus Luiz", "matheus@hotmail.com", null);
		Pessoa p2 = new Pessoa(null, "560.482.150-95", "Rodrigo Alves", "rodrigo@hotmail.com", null);
		
		Treino t1 = new Treino(null, "Peito", 3 , "S/N", "Crucifixo", "Até a falha", p1);
		Treino t3 = new Treino(null, "Peito", 4 , "10 a 15", "Supino Reto", "Com Halter", p1);
		Treino t4 = new Treino(null, "Peito", 4 , "10 a 15", "Paralelas", "Sem observações", p1);
		Treino t5 = new Treino(null, "Peito", 3 , "10 a 15", "Supino Reto", "Com barra", p1);
		Treino t2 = new Treino(null, "Abdome", 4 , "20 a 25", "Abdominais", "Sem observações", p1);
		Treino t6 = new Treino(null, "Biceps", 4 , "10 a 15", "Rosca", "Barra ondulada", p1);
		Treino t7 = new Treino(null, "Biceps", 4 , "10 a 15", "Barra fixa supinada", "Sem observações", p1);
		
		Treino t8 = new Treino(null, "Perna", 3 , "10 a 15", "Leg press", "Sem observações",p2);
		Treino t9 = new Treino(null, "Perna", 4 , "10 a 15", "Agachamento", "Com Halter", p2);
		Treino t10 = new Treino(null, "Perna", 4 , "10 a 15", "Panturrilha", "Sem observações", p2);
		Treino t11 = new Treino(null, "Perna", 4 , "10 a 15", "Stiff", "Até a falha", p2);

		pessoaRepository.saveAll(Arrays.asList(p1,p2));
		treinoRepository.saveAll(Arrays.asList(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11));
	}
}
