package com.projMusica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projMusica.model.Musica;
import com.projMusica.repository.MusicaRepository;

@RestController
public class MusicaController {

	@Autowired//
   MusicaRepository repository;//interface para persistir n db
	
	
	@PostMapping("api/save")//post chama o metodo para slavar 
	public Musica save(@RequestBody Musica musica){
		return repository.save(musica);
		}
	
	//http://localhost:8080/api/all
	
	
	@GetMapping("api/all")// get - para pegar as informações
	public List<Musica> all(){
		return (List<Musica>) repository.findAll();
	}
	
	//http://localhost:8080/api/delete/2
	@GetMapping("api/delete/{id}")
	public boolean delete(@PathVariable("id") Long id) {
		try {
			repository.deleteById(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
