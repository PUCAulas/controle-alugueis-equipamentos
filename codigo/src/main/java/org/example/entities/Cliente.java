package main.java.org.example.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nome;
	private LocalDate dataNascimento;
	private String cpf;
	private List<Aluguel> listaDeAlugueis;

	public Cliente() {

	}

	public Cliente(String nome, LocalDate dataNascimento, String cpf) throws Exception {
		if (verificaDataNascimento(dataNascimento)) {
			this.nome = nome;
			this.dataNascimento = dataNascimento;
			this.cpf = cpf;
			this.listaDeAlugueis = new ArrayList<>();
		} else {
			throw new Exception("Data Inválida");
		}
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Aluguel> getListaDeAlugueis() {
		return listaDeAlugueis;
	}

	public void setListaDeAlugueis(List<Aluguel> listaDeAlugueis) {
		this.listaDeAlugueis = listaDeAlugueis;
	}

	public void imprimirLista() {
		for (Aluguel aluguel : listaDeAlugueis) {
			System.out.println(aluguel);
		}
	}

	public boolean verificaDataNascimento(LocalDate dataNascimento) {
		int ano = dataNascimento.getYear();
		return ano >= 1900 && ano <= 2005;
	}

}
