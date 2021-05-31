package br.com.bot.uncisal.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bot.uncisal.model.Pergunta;
import br.com.bot.uncisal.repositories.PerguntaRepositorio;

@RestController
public class PerguntaController {

	@Autowired
	PerguntaRepositorio repo;

	@RequestMapping("/")
	public String index() {

		return "Server online";
	}
	
	@RequestMapping(value = "/perguntas", method = RequestMethod.GET, produces = "application/json")
	@GetMapping
	public Iterable<Pergunta> findAll() {
		return repo.findAll();
	}
	

	@GetMapping("/perguntas/{id}")
	public Optional<Pergunta> gerPerguntasById(@PathVariable(value = "id") long id) {
	
		return repo.findById(id);
	}
	
	
	@RequestMapping(value = "/perguntas", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Pergunta> salvarPergunta(@RequestBody @Valid Pergunta pergunta) {
		repo.save(pergunta);
		
		return new ResponseEntity<Pergunta>(pergunta, null, HttpStatus.SC_CREATED);
	}
	
	
	
	
}
