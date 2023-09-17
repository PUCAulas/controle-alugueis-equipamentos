package main.java.org.example.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private List<Aluguel> listaDeAlugueis;

    public Cliente() {
        nome = "Nao informado";
        dataNascimento = LocalDate.of(1900, 1, 1);
        cpf = "Nao informado";
        listaDeAlugueis = new ArrayList<>();
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

    public static Cliente pesquisarCliente(List<Cliente> listaCliente) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        for (Cliente cliente : listaCliente)
            if (cliente.getCpf().equals(cpf))
                return cliente;

        throw new Exception("Cliente nao cadastrado");
    }

    public static void listarClientes(List<Cliente> listaCliente) {
        System.out.println("\nLista de Clientes:");
        listaCliente.forEach(Cliente::imprimir);
    }

    public void cadastrarCliente(List<Cliente> listaCliente) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        try {
            this.setNome(nome);
            this.setCpf(cpf);
            this.setDataNascimento(dataNascimento);
            listaCliente.add(this);
            System.out.println("Cliente cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    public void pesquisarAlugueisCliente() {
        this.getListaDeAlugueis().forEach(Aluguel::imprimir);
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

    public void imprimir() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("CPF: " + this.getCpf());
        System.out.println("Data de Nascimento: " + this.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println();
    }

    public boolean verificaDataNascimento(LocalDate dataNascimento) {
        int ano = dataNascimento.getYear();
        return ano >= 1900 && ano <= 2005;
    }

}
