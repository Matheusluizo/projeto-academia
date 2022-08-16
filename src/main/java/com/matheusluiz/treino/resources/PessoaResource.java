package com.matheusluiz.treino.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheusluiz.treino.domain.Pessoa;
import com.matheusluiz.treino.services.PessoaService;

@RequestMapping(value = "/pessoas")
@RestController
public class PessoaResource {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable Integer id){
		Pessoa obj = pessoaService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll(){
		List<Pessoa> list = pessoaService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> created(@RequestBody Pessoa obj){
		Pessoa newObj = pessoaService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		pessoaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable Integer id, @RequestBody Pessoa obj){
		Pessoa oldObj = pessoaService.update(id, obj);
		return ResponseEntity.ok().body(oldObj);
	}
}
