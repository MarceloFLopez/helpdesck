package com.marcelo.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.helpdesk.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
