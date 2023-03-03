package com.marcelo.helpdesk.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.helpdesk.enums.Perfil;
import com.marcelo.helpdesk.enums.Prioridade;
import com.marcelo.helpdesk.enums.Status;
import com.marcelo.helpdesk.model.Chamado;
import com.marcelo.helpdesk.model.Cliente;
import com.marcelo.helpdesk.model.Tecnico;
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
		
		Tecnico tec2 = new Tecnico(null, "Teste ", "38727734293", "test@email.com", "123");
		tec1.addPerfil(Perfil.TECNICO);

		Cliente cli1 = new Cliente(null, "Linus Torval", "74281936300", "torval@email.com", "123");
		Cliente cli2 = new Cliente(null, "Steve Jobs", "41492112720", "steve@email.com", "123");
		Cliente cli3 = new Cliente(null, "Bill Gates", "48113410155", "bill@email.com", "123");


		Chamado c1 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.MEDIA, Status.ABERTO, "Chamado 02", "Segundo chamado", tec2, cli2);
		Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 02", "Terceiro chamado", tec2, cli3);

		tecnicoRepository.saveAll(Arrays.asList(tec1,tec2));
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3));
		chamadoRepository.saveAll(Arrays.asList(c1,c2,c3));

	}
}
