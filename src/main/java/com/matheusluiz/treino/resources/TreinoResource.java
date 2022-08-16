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

import com.matheusluiz.treino.domain.Treino;
import com.matheusluiz.treino.services.TreinoService;

@RestController
@RequestMapping(value = "/treinos")
public class TreinoResource {
	
	@Autowired
	private TreinoService treinoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Treino> findById(@PathVariable Integer id){
		Treino obj = treinoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Treino>> findAll(){
		List<Treino> list = treinoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Treino> created(@RequestBody Treino obj){
		Treino newObj = treinoService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		treinoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Treino> update(@PathVariable Integer id, @RequestBody Treino obj){
		Treino oldObj = treinoService.update(id, obj);
		return ResponseEntity.ok().body(oldObj);
	}
}
