package main.java.org.example.entities;

import main.java.org.example.enums.StatusEquipamento;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Aluguel {

    public static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Cliente cliente;
    private Equipamento equipamento;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Aluguel(Cliente cliente, Equipamento equipamento, String dataInicio, String dataFim) throws Exception {
        if (dataValida(LocalDate.parse(dataInicio, fmt), LocalDate.parse(dataFim, fmt))) {
            this.cliente = cliente;
            this.equipamento = equipamento;
            this.dataInicio = LocalDate.parse(dataInicio, fmt);
            this.dataFim = LocalDate.parse(dataFim, fmt);
        } else
            throw new Exception("Data invalida!");
        verificarDisponiEquipamento(equipamento);
    }

    public Aluguel() {
        this.cliente = null;
        this.equipamento = null;
        this.dataInicio = null;
        this.dataFim = null;
    }

    public boolean dataValida(LocalDate dataInicio, LocalDate dataFim) {

        return dataFim.isAfter(dataInicio);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    //Caso o equipamento já esteja alugado pelo cliente (verificar lista) retorne uma exceção

    public Double valorTotal() {
        return totalEmDia(this.dataInicio, this.dataFim) * equipamento.getValorDiaria();
    }

    public Integer totalEmDia(LocalDate dataInicio, LocalDate dataFim) {

        Period period = Period.between(dataInicio, dataFim);

        return period.getDays();
    }


    public void verificarDisponiEquipamento(Equipamento equipamento) throws Exception{
        if(equipamento.getStatusEquipamento() != StatusEquipamento.DISPONIVEL) {
            throw new Exception("O equipamento não está disponível para empréstimo");
        }
    }




}
