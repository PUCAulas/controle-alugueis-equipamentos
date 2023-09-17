package main.java.org.example.entities;

import main.java.org.example.enums.StatusEquipamento;
import main.java.org.example.enums.TipoEquipamento;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Equipamento {

    private static Integer proximoId = 1;
    private Integer id;
    private String nome;
    private String descricao;
    private TipoEquipamento tipoEquipamento;
    private StatusEquipamento statusEquipamento;
    private Double valorDiaria;

    public Equipamento() {
        this.id = proximoId++;
        this.nome = "nao informado";
        this.descricao = "nao informado";
        this.tipoEquipamento = null;
        this.valorDiaria = 0.0;
        this.statusEquipamento = null;
    }

    public Equipamento(String nome, String descricao, TipoEquipamento tipoEquipamento, Double valorDiaria) {
        this.id = proximoId++;
        this.nome = nome;
        this.descricao = descricao;
        this.tipoEquipamento = tipoEquipamento;
        this.valorDiaria = valorDiaria;
        this.statusEquipamento = StatusEquipamento.DISPONIVEL;
    }

    public static void listarEquipamentos(List<Equipamento> listaEquipamento) {
        System.out.println("\nLista de Equipamentos:");
        listaEquipamento.forEach(Equipamento::imprimir);
    }

    public void cadastrarEquipamento(List<Equipamento> listaEquipamentos) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do Equipamento: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Tipo " + Arrays.toString(TipoEquipamento.values()) + ": ");
        TipoEquipamento tipoEquipamento = TipoEquipamento.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Valor da Diária (use vírgula como separador decimal): ");
        Double valorDiaria = scanner.nextDouble();

        this.setNome(nome);
        this.setDescricao(descricao);
        this.setTipoEquipamento(tipoEquipamento);
        this.setValorDiaria(valorDiaria);
        this.setStatusEquipamento(StatusEquipamento.DISPONIVEL);

        listaEquipamentos.add(this);
        System.out.println("Equipamento cadastrado com sucesso!");
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

    public StatusEquipamento getStatusEquipamento() {
        return statusEquipamento;
    }

    public void setStatusEquipamento(StatusEquipamento statusEquipamento) {
        this.statusEquipamento = statusEquipamento;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public void imprimir() {
        System.out.println("ID: " + this.getId());
        System.out.println("Nome: " + this.getNome());
        System.out.println("Descrição: " + this.getDescricao());
        System.out.println("Tipo: " + this.getTipoEquipamento());
        System.out.println("Valor da Diária: " + this.getValorDiaria());
        System.out.println("Status: " + this.getStatusEquipamento());
        System.out.println();
    }

}

