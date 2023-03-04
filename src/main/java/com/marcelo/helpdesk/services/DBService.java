package com.marcelo.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.helpdesk.model.Chamado;
import com.marcelo.helpdesk.model.Cliente;
import com.marcelo.helpdesk.model.Tecnico;
import com.marcelo.helpdesk.model.enums.Perfil;
import com.marcelo.helpdesk.model.enums.Prioridade;
import com.marcelo.helpdesk.model.enums.Status;
import com.marcelo.helpdesk.repository.ChamadoRepository;
import com.marcelo.helpdesk.repository.ClienteRepository;
import com.marcelo.helpdesk.repository.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	public void instanciaBD() {

		Tecnico tec1 = new Tecnico(null, "Valdir Cezar", "73371578275", "valdir@email.com", "123");
		tec1.addPerfil(Perfil.ADMIN);

		Tecnico te2 = new Tecnico(null, "Teste2", "58740405010", "teste2@email.com", "123");
		tec1.addPerfil(Perfil.TECNICO);

		Tecnico te3 = new Tecnico(null, "Teste3", "79498696071", "teste3@email.com", "123");
		tec1.addPerfil(Perfil.CLIENTE);
		
		Tecnico te4 = new Tecnico(null, "Teste4", "44178395734", "teste4@email.com", "123");
		tec1.addPerfil(Perfil.TECNICO);

		Cliente cli1 = new Cliente(null, "Teste5", "14586098988", "teste5@email.com", "123");

		Chamado c1 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);

		tecnicoRepository.saveAll(Arrays.asList(tec1, te2,te3,te4));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));

	}
}
