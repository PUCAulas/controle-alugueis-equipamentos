package main.java.org.example;

import main.java.org.example.entities.Aluguel;
import main.java.org.example.entities.Cliente;
import main.java.org.example.entities.Equipamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        List<Equipamento> listaEquipamento = new ArrayList<>();
        List<Cliente> listaCliente = new ArrayList<>();
        List<Aluguel> listaAluguel = new ArrayList<>();

        int opcao = 0;

        while (opcao != 9) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Equipamento");
            System.out.println("3. Alugar Equipamento");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Listar Equipamentos");
            System.out.println("6. Listar Aluguéis");
            System.out.println("7. Pesquisar aluguéis de clientes");
            System.out.println("8. Gerar relatorio do mes atual");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    Cliente cliente = new Cliente();
                    cliente.cadastrarCliente(listaCliente);
                    break;
                case 2:
                    Equipamento equipamento = new Equipamento();
                    equipamento.cadastrarEquipamento(listaEquipamento);
                    break;
                case 3:
                    Aluguel aluguel = new Aluguel();
                    aluguel.alugarEquipamento(listaCliente, listaEquipamento, listaAluguel);
                    break;
                case 4:
                    Cliente.listarClientes(listaCliente);
                    break;
                case 5:
                    Equipamento.listarEquipamentos(listaEquipamento);
                    break;
                case 6:
                    Aluguel.listarAlugueis(listaAluguel);
                    break;
                case 7:
                    Cliente clientePesquisa = Cliente.pesquisarCliente(listaCliente);
                    clientePesquisa.pesquisarAlugueisCliente();
                    break;
                case 8:
                    Aluguel.gerarRelatorioMensal(listaAluguel);
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");

            }
        }
    }
}
