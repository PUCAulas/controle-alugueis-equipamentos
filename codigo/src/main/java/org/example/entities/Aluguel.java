package main.java.org.example.entities;

import main.java.org.example.enums.StatusEquipamento;

import java.time.LocalDate;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

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
        verificarDisponibilidadeEquipamento(equipamento);
    }

    public Aluguel() {
        this.cliente = null;
        this.equipamento = null;
        this.dataInicio = null;
        this.dataFim = null;
    }

    public static void gerarRelatorioMensal(List<Aluguel> listaAluguel) {

        YearMonth anoMesAtual = YearMonth.now();
        List<Aluguel> alugueisMesAtual = listaAluguel.stream()
                .filter(aluguel -> dataNoMesAtual(aluguel.getDataInicio(), anoMesAtual))
                .toList();

        double total = alugueisMesAtual.stream()
                .mapToDouble(Aluguel::valorTotal)
                .sum();

        System.out.println("\nRelatorio do mes: ");
        alugueisMesAtual.forEach(Aluguel::imprimir);

        System.out.println("Valor total no mes: " + total);
    }

    private static boolean dataNoMesAtual(LocalDate data, YearMonth anoMesAtual) {
        return YearMonth.from(data).equals(anoMesAtual);
    }

    public static void listarAlugueis(List<Aluguel> listaAluguel) {
        System.out.println("\nLista de Aluguéis:");
        listaAluguel.forEach(Aluguel::imprimir);
    }

    public void alugarEquipamento(List<Cliente> listaCliente, List<Equipamento> listaEquipamentos, List<Aluguel> listaAluguel) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("CPF do Cliente: ");
        String cpfCliente = scanner.nextLine();
        Cliente clienteAluguel = null;

        for (Cliente c : listaCliente) {
            if (c.getCpf().equals(cpfCliente)) {
                clienteAluguel = c;
                break;
            }
        }

        if (clienteAluguel == null) {
            throw new Exception("Cliente não encontrado!");
        }

        System.out.print("ID do Equipamento para Alugar: ");
        int idEquipamentoAluguel = scanner.nextInt();
        Equipamento equipamentoAluguel = null;

        for (Equipamento e : listaEquipamentos) {
            if (e.getId() == idEquipamentoAluguel) {
                equipamentoAluguel = e;
                break;
            }
        }

        if (equipamentoAluguel == null) {
            throw new Exception("Equipamento não encontrado!");
        }

        scanner.nextLine();

        System.out.print("Data de Início (dd/MM/yyyy): ");
        LocalDate dataInicio = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Data de Fim (dd/MM/yyyy): ");
        LocalDate dataFim = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        try {
            this.setCliente(clienteAluguel);
            this.setEquipamento(equipamentoAluguel);
            this.setDataInicio(dataInicio);
            this.setDataFim(dataFim);
            listaAluguel.add(this);
            clienteAluguel.getListaDeAlugueis().add(this);
            equipamentoAluguel.setStatusEquipamento(StatusEquipamento.Em_USO);
            System.out.println("Equipamento alugado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao alugar equipamento: " + e.getMessage());
        }
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

    //Caso o equipamento já esteja alugado pelo cliente (verificar lista) retorne uma exceção

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Double valorTotal() {
        return totalEmDia(this.dataInicio, this.dataFim) * equipamento.getValorDiaria();
    }

    public Integer totalEmDia(LocalDate dataInicio, LocalDate dataFim) {
        return Period.between(dataInicio, dataFim).getDays();
    }

    public void imprimir() {
        System.out.println("Cliente: " + this.getCliente().getNome());
        System.out.println("Equipamento: " + this.getEquipamento().getNome());
        System.out.println("Data de Início: " + this.getDataInicio());
        System.out.println("Data de Fim: " + this.getDataFim());
        System.out.println("Valor Total: R$ " + this.valorTotal());
        System.out.println();
    }

    public void verificarDisponibilidadeEquipamento(Equipamento equipamento) throws Exception {
        if (equipamento.getStatusEquipamento() != StatusEquipamento.DISPONIVEL) {
            throw new Exception("O equipamento não está disponível para empréstimo");
        }
    }
}
