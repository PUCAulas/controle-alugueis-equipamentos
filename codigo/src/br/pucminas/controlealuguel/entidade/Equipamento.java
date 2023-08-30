package br.pucminas.controlealuguel.entidade;

import br.pucminas.controlealuguel.enums.TipoEquipamento;

public class Equipamento {
	
	private static Integer id;
	private static String nome;
	private static String descricao;
	private static TipoEquipamento tipoEquipamento;
	private static Double valorDiaria ;

	
	public static Integer getId() {
		return id;
	}
	public static void setId(Integer id) {
		Equipamento.id = id;
	}
	public static String getNome() {
		return nome;
	}
	public static void setNome(String nome) {
		Equipamento.nome = nome;
	}
	public static String getDescricao() {
		return descricao;
	}
	public static void setDescricao(String descricao) {
		Equipamento.descricao = descricao;
	}
	public static TipoEquipamento getTipoEquipamento() {
		return tipoEquipamento;
	}
	public static void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
		Equipamento.tipoEquipamento = tipoEquipamento;
	}
	public static Double getValorDiaria() {
		return valorDiaria;
	}
	public static void setValorDiaria(Double valorDiaria) {
		Equipamento.valorDiaria = valorDiaria;
	}
	
}

