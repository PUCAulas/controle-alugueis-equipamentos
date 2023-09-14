package test.java.com.example;

import main.java.org.example.entities.Aluguel;
import main.java.org.example.entities.Cliente;
import main.java.org.example.entities.Equipamento;
import main.java.org.example.enums.TipoEquipamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    Cliente cliente01;
    Cliente cliente02;
    Equipamento equipamento01;
    Equipamento equipamento02;
    Aluguel aluguel;

    @BeforeEach
    public void setUp() throws Exception {
        cliente01 = new Cliente("Jose", LocalDate.of(1980, 10, 8), "12345678955");
        cliente02 = new Cliente("Maria", LocalDate.of(1970, 9, 1), "98765432122");
        equipamento02 = new Equipamento("Caminhao", "Caminhão Caçamba", TipoEquipamento.VEICULO, 129.65);
        equipamento01 = new Equipamento("Martelo", "Martelo Tipo Pena 800gr Worker", TipoEquipamento.FERRAMENTA, 5.32);
        aluguel = new Aluguel(cliente01, equipamento01, "01/09/2023", "12/10/2023");
    }

    @Test
    @DisplayName("Teste - dataValida()")
    public void dataValidaTeste() throws Exception {
        // Certifica-se de que dataNascimento é inferior 2005
        assertThrows(Exception.class, () -> {
            cliente01.verificaDataNascimento();
        });

        // Certifica-se de que dataNascimento é superior à 1900
        assertThrows(Exception.class, () -> {
            cliente01.verificaDataNascimento();
        });
    }

    /**
     * Caso de teste para o construtor da classe Cliente com parâmetros.
     * Verifica se o construtor inicializa corretamente.
     */
    @Test
    @DisplayName("Teste - Cliente (String nome, LocalDate dataNascimento, String cpf)")
    public void clienteTest() {
        // Certifica-se de que a data de nascimento eh valida
        assertThrows(LocalDate.of(2023, 10, 11), cliente01.getDataNascimento());
    }

    /**
     * Caso de teste para o método getListaDeAlugueis da classe Cliente.
     * Verifica se o método getListaDeAlugueis retorna corretamente a lista.
     */
    @Test
    @DisplayName("Teste - ListaDeAlugueisNaoNulo()")
    public void ListaDeAlugueisNaoNulo() {
    	cliente02.getListaDeAlugueis().add(aluguel);
    	// Certifica-se de que a lista contém alugueis
    	assertNotNull(cliente02.getListaDeAlugueis());
    }

    /**
     * Caso de teste para o método getListaDeAlugueis da classe Cliente.
     * Verifica se o método getListaDeAlugueis retorna a lista vazia.
     */
    @Test
    @DisplayName("Teste - ListaDeAlugueisEhNulo()")
    public void ListaDeAlugueisEhNulo() {
    	// Certifica-se de que a lista do cliente está vazia
    	assertTrue(cliente02.getListaDeAlugueis(), new ArrayList<>());
    }

}
