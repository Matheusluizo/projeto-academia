package com.matheusluiz.treino.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusluiz.treino.services.exceptions.DataIntegrityViolationException;
import com.matheusluiz.treino.domain.Pessoa;
import com.matheusluiz.treino.repositories.PessoaRepository;
import com.matheusluiz.treino.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoarepository;
	
	public Pessoa findById(Integer id) {
		Optional<Pessoa> obj = pessoarepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado" + id));
	}
	
	public List<Pessoa> findAll() {
		return pessoarepository.findAll();
	}
	
	public Pessoa create(Pessoa obj) {
		return pessoarepository.save(obj);
	}
	
	public void delete(Integer id) {
		Pessoa obj = findById(id);
		if (obj.getTreinos().size() > 0) {
			throw new DataIntegrityViolationException("Cliente possui um treino e não pode ser deletado");
		}
		pessoarepository.deleteById(id);
	}
	
	public Pessoa update(Integer id, Pessoa obj) {
		obj.setId(id);
		Pessoa oldObj = obj;
		return pessoarepository.save(oldObj);
	}
}


