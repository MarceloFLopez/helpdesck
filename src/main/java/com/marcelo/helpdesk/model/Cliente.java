package com.marcelo.helpdesk.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

import com.marcelo.helpdesk.enums.Perfil;

@Entity
public class Cliente extends Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "cliente")
	private List<Chamado> chamados = new ArrayList<>();

	public Cliente() {
		super();
		addPerfil(Perfil.CLIENTE);
	}

	public Cliente(Integer id, String nome, @CPF String cpf, @Email String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfil(Perfil.CLIENTE);
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

}
