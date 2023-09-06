package main.java.org.example.entidade;

import main.java.org.example.enums.TipoEquipamento;

public class Equipamento {
	
	private Integer id;
	private static Integer proximoId = 1;
	private String nome;
	private String descricao;
	private TipoEquipamento tipoEquipamento;
	private Double valorDiaria ;
	
	public Equipamento(String nome, String descricao, TipoEquipamento tipoEquipamento, Double valorDiaria) {
		this.id = proximoId++;
		this.nome = nome;
		this.descricao = descricao;
		this.tipoEquipamento = tipoEquipamento;
		this.valorDiaria = valorDiaria;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public TipoEquipamento getTipoEquipamento() {
		return tipoEquipamento;
	}
	public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
		this.tipoEquipamento = tipoEquipamento;
	}
	public Double getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	
}

