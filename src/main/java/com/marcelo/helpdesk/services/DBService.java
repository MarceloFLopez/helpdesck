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

		Tecnico te1 = new Tecnico(null, "Valdir Cezar", "73371578275", "valdir@email.com", "123");
		te1.addPerfil(Perfil.TECNICO);

		Tecnico te2 = new Tecnico(null, "Tecnico1", "58740405010", "teste2@email.com", "123");
		te2.addPerfil(Perfil.TECNICO);

		Tecnico te3 = new Tecnico(null, "Tecnico2", "79498696071", "teste3@email.com", "123");
		te3.addPerfil(Perfil.TECNICO);
		
		Tecnico te4 = new Tecnico(null, "Tecnico3", "44178395734", "teste4@email.com", "123");
		te4.addPerfil(Perfil.ADMIN);

		Cliente cli1 = new Cliente(null, "Cliente1", "14586098988", "cliente1@email.com", "123");
		Cliente cli2 = new Cliente(null, "Cliente2", "59598865371", "cliente2@email.com", "123");
		Cliente cli3 = new Cliente(null, "Cliente3", "05565368278", "cliente3@email.com", "123");
		Cliente cli4 = new Cliente(null, "Cliente4", "42806323401", "cliente4@email.com", "123");
		Cliente cli5 = new Cliente(null, "Cliente5", "43122627566", "cliente5@email.com", "123");
		Cliente cli6 = new Cliente(null, "Cliente6", "31680075608", "cliente6@email.com", "123");
		Cliente cli7 = new Cliente(null, "Cliente7", "61432697854", "cliente7@email.com", "123");
		Cliente cli8 = new Cliente(null, "Cliente8", "39174719572", "cliente8@email.com", "123");
		Cliente cli9 = new Cliente(null, "Cliente9", "35588772768", "cliente9@email.com", "123");
		Cliente cli10 = new Cliente(null, "Cliente10", "21627531548", "cliente10@email.com", "123");

		Chamado c1 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", te1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 01", "Segundo chamado", te2, cli2);
		Chamado c3 = new Chamado(null, Prioridade.ALTA, Status.ENCERRADO, "Chamado 01", "Teceiro chamado", te3, cli3);
		Chamado c4 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 01", "Quarto chamado", te4, cli4);
		Chamado c5 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 01", "Quinto chamado", te1, cli5);
		Chamado c6 = new Chamado(null, Prioridade.ALTA, Status.ENCERRADO, "Chamado 01", "Sexto chamado", te2, cli6);
		Chamado c7 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 01", "Setimo chamado", te3, cli7);
		Chamado c8 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 01", "Oitavo chamado", te4, cli8);
		Chamado c9 = new Chamado(null, Prioridade.ALTA, Status.ENCERRADO, "Chamado 01", "Nono chamado", te1, cli9);
		Chamado c10 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 01", "Decimo chamado", te2, cli10);

		tecnicoRepository.saveAll(Arrays.asList(te1, te2,te3,te4));
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3,cli4,cli5,cli6,cli7,cli8,cli9,cli10));
		chamadoRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10));

	}
}
