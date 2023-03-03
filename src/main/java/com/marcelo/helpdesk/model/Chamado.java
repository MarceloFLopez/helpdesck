package com.marcelo.helpdesk.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marcelo.helpdesk.enums.Prioridade;
import com.marcelo.helpdesk.enums.Status;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
public class Chamado implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAbertura = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFechamento;
	private Prioridade prioridade;
	private Status status;
	private String titulo;
	private String observacoes;

	@ManyToOne
	@JoinColumn(name = "tecnico__id")
	private Tecnico tecnico;
	
	@ManyToOne
	@JoinColumn(name = "cliente__id")
	private Cliente cliente;

	public Chamado() {
		super();
	}

	public Chamado(Integer id, Prioridade prioridade, Status status, String titulo, String observacoes, Tecnico tecnico,
			Cliente cliente) {
		super();
		Id = id;
		this.prioridade = prioridade;
		this.status = status;
		this.titulo = titulo;
		this.observacoes = observacoes;
		this.tecnico = tecnico;
		this.cliente = cliente;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chamado other = (Chamado) obj;
		return Objects.equals(Id, other.Id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

}
