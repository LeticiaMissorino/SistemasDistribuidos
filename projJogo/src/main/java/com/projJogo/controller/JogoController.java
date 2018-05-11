package com.projJogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projJogo.model.Jogo;
import com.projJogo.repository.JogoRepository;

@RestController
public class JogoController {


	@Autowired//
   JogoRepository repository;//interface para persistir n db
	
	
	@PostMapping("api/save")//post chama o metodo para slavar 
	public Jogo save(@RequestBody Jogo jogo){
		return repository.save(jogo);
		}
	
	//http://localhost:8080/api/all
	
	
	@GetMapping("api/all")// get - para pegar as informações
	public List<Jogo> all(){
		return (List<Jogo>) repository.findAll();
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
