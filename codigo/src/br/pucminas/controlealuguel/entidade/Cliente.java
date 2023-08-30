package br.pucminas.controlealuguel.entidade;

import java.time.LocalDate;
import java.util.List;

public class Cliente {
	private String nome;
	private LocalDate dataNascimento;
	private Integer cpf;
	private List<Aluguel> listaDeAlugueis;

	public Cliente() {

	}

	public Cliente(String nome, LocalDate dataNascimento, Integer cpf, List<Aluguel> listaDeAlugueis) {

		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.listaDeAlugueis = listaDeAlugueis;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public List<Aluguel> getListaDeAlugueis() {
		return listaDeAlugueis;
	}

	public void setListaDeAlugueis(List<Aluguel> listaDeAlugueis) {
		this.listaDeAlugueis = listaDeAlugueis;
	}

}
