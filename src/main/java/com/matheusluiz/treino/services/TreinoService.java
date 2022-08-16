package com.matheusluiz.treino.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusluiz.treino.domain.Treino;
import com.matheusluiz.treino.repositories.TreinoRepository;
import com.matheusluiz.treino.services.exceptions.ObjectNotFoundException;

@Service
public class TreinoService {
	
	@Autowired
	private TreinoRepository treinorepository;
	
	public Treino findById(Integer id) {
		Optional<Treino> obj = treinorepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado" + id));
	}
	
	public List<Treino> findAll() {
		return treinorepository.findAll();
	}
	
	public Treino create(Treino obj) {
		return treinorepository.save(obj);
	}
	
	public void delete(Integer id) {
		treinorepository.deleteById(id);
	}
	
	public Treino update(Integer id, Treino obj) {
		obj.setId(id);
		Treino oldObj = obj;
		return treinorepository.save(oldObj);
	}
}
