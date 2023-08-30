package br.pucminas.controlealuguel.entidade;

import java.time.LocalDate;
import java.util.List;

public class Cliente {
	private String nome;
	private LocalDate dataNascimento;
	private Integer cpf;
	private List<Aluguel> listaDeAlugueis;

}
