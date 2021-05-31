package br.com.bot.uncisal.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.bot.uncisal.model.Pergunta;

@Repository
public interface PerguntaRepositorio extends CrudRepository<Pergunta, Long> {
    Optional<Pergunta> findById(long id);
    
}