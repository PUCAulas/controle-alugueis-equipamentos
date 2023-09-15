package main.java.org.example;

import main.java.org.example.entities.Cliente;
import main.java.org.example.entities.Equipamento;
import main.java.org.example.entities.Aluguel;
import main.java.org.example.enums.TipoEquipamento;
import main.java.org.example.enums.StatusEquipamento;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();
        List<Equipamento> equipamentos = new ArrayList<>();
        List<Aluguel> alugueis = new ArrayList<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Equipamento");
            System.out.println("3. Alugar Equipamento");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Listar Equipamentos");
            System.out.println("6. Listar Aluguéis");
            System.out.println("7. Pesquisar aluguéis de clientes");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar a nova linha após a entrada do número

            switch (opcao) {
                case 1:
                    cadastrarCliente(clientes, scanner);
                    break;

                case 2:
                    cadastrarEquipamento(equipamentos, scanner);
                    break;

                case 3:
                    alugarEquipamento(clientes, equipamentos, alugueis, scanner);
                    break;

                case 4:
                    listarClientes(clientes);
                    break;

                case 5:
                    listarEquipamentos(equipamentos);
                    break;

                case 6:
                    listarAlugueis(alugueis);
                    break;
                    
                case 7:
                	pesquisarAlugueisDeClientes(clientes, scanner);
                    break;

                case 8:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarCliente(List<Cliente> clientes, Scanner scanner) {
        System.out.print("Nome do Cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
        String dataNascimentoStr = scanner.nextLine();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, fmt);
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        Cliente cliente;
		try {
			cliente = new Cliente(nomeCliente, dataNascimento, cpf);
			clientes.add(cliente);
	        System.out.println("Cliente cadastrado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
		}
    }

    private static void cadastrarEquipamento(List<Equipamento> equipamentos, Scanner scanner) {
        System.out.print("Nome do Equipamento: ");
        String nomeEquipamento = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricaoEquipamento = scanner.nextLine();
        System.out.print("Tipo (VEICULO, FERRAMENTA, MATERIAL, MAQUINARIO): ");
        String tipoEquipamentoStr = scanner.nextLine();
        TipoEquipamento tipoEquipamento = TipoEquipamento.valueOf(tipoEquipamentoStr);
        System.out.print("Valor da Diária (use vírgula como separador decimal): ");
        Double valorDiaria = scanner.nextDouble();

        Equipamento equipamento = new Equipamento(nomeEquipamento, descricaoEquipamento, tipoEquipamento, valorDiaria);
        equipamentos.add(equipamento);
        System.out.println("Equipamento cadastrado com sucesso!");
    }

    private static void alugarEquipamento(List<Cliente> clientes, List<Equipamento> equipamentos, List<Aluguel> alugueis, Scanner scanner) {
        System.out.print("CPF do Cliente: ");
        String cpfCliente = scanner.nextLine();
        Cliente clienteAluguel = null;

        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpfCliente)) {
                clienteAluguel = c;
                break;
            }
        }

        if (clienteAluguel == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.print("ID do Equipamento para Alugar: ");
        int idEquipamentoAluguel = scanner.nextInt();
        Equipamento equipamentoAluguel = null;

        for (Equipamento e : equipamentos) {
            if (e.getId() == idEquipamentoAluguel) {
                equipamentoAluguel = e;
                break;
            }
        }

        if (equipamentoAluguel == null) {
            System.out.println("Equipamento não encontrado.");
            return;
        }

        scanner.nextLine();  // Limpar a nova linha após a entrada do número

        System.out.print("Data de Início (dd/MM/yyyy): ");
        String dataInicioStr = scanner.nextLine();
        System.out.print("Data de Fim (dd/MM/yyyy): ");
        String dataFimStr = scanner.nextLine();

        try {
            Aluguel aluguel = new Aluguel(clienteAluguel, equipamentoAluguel, dataInicioStr, dataFimStr);
            alugueis.add(aluguel);
            clienteAluguel.getListaDeAlugueis().add(aluguel);
            
            equipamentoAluguel.setStatusEquipamento(StatusEquipamento.Em_USO);
            System.out.println("Equipamento alugado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao alugar equipamento: " + e.getMessage());
        }
    }

    private static void listarClientes(List<Cliente> clientes) {
        System.out.println("\nLista de Clientes:");
        for (Cliente c : clientes) {
            System.out.println("Nome: " + c.getNome());
            System.out.println("CPF: " + c.getCpf());
            System.out.println("Data de Nascimento: " + c.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            System.out.println();
        }
    }

    private static void listarEquipamentos(List<Equipamento> equipamentos) {
        System.out.println("\nLista de Equipamentos:");
        for (Equipamento e : equipamentos) {
            System.out.println("ID: " + e.getId());
            System.out.println("Nome: " + e.getNome());
            System.out.println("Descrição: " + e.getDescricao());
            System.out.println("Tipo: " + e.getTipoEquipamento());
            System.out.println("Valor da Diária: " + e.getValorDiaria());
            System.out.println("Status: " + e.getStatusEquipamento());
            System.out.println();
        }
    }

    private static void listarAlugueis(List<Aluguel> alugueis) {
        System.out.println("\nLista de Aluguéis:");
        for (Aluguel a : alugueis) {
            System.out.println("Cliente: " + a.getCliente().getNome());
            System.out.println("Equipamento: " + a.getEquipamento().getNome());
            System.out.println("Data de Início: " + a.getDataInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            System.out.println("Data de Fim: " + a.getDataFim().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            System.out.println("Valor Total: R$" + String.format("%.2f", a.valorTotal()));
            System.out.println();
        }
    }
    
    private static void pesquisarAlugueisDeClientes(List<Cliente> clientes, Scanner scanner) {
    	System.out.println("\nDigite o CPF do cliente para pesquisa:");
    	String cpf = scanner.nextLine();
    	for (Cliente c : clientes) {
    		if(cpf.equals(c.getCpf())) {
    			c.imprimirLista();
    		}
    	}   	
    }
}
