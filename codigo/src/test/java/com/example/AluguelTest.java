package test.java.com.example;

import main.java.org.example.entities.Aluguel;
import main.java.org.example.entities.Cliente;
import main.java.org.example.entities.Equipamento;
import main.java.org.example.enums.TipoEquipamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AluguelTest {

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
        aluguel = new Aluguel(cliente01, equipamento01, LocalDate.of(2023, 9, 1), LocalDate.of(2023, 10, 12));
    }

    @Test
    @DisplayName("Teste - dataValida()")
    public void dataValidaTeste() throws Exception {
        // Certifica-se de que dataInicio não é inferior à dataFim
        assertThrows(Exception.class, () -> {
            aluguel = new Aluguel(cliente01, equipamento01, LocalDate.of(2023, 10, 1), LocalDate.of(2023, 9, 10));
        });

        // Certifica-se de que dataInicio é inferior à dataFim
        assertDoesNotThrow(() -> {
            aluguel = new Aluguel(cliente01, equipamento01, LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 10));
        });
    }

    /**
     * Caso de teste para o construtor da classe Aluguel com parâmetros.
     * Verifica se o construtor inicializa corretamente o atributo dataInicio.
     */
    @Test
    @DisplayName("Teste - Aluguel (Cliente cliente, Equipamento equipamento, LocalDate dataInicio, LocalDate dataFim)")
    public void aluguelTeste() {
        // Certifica-se de que dataInicio do aluguel é igual a 1 de setembro de 2023
        assertEquals(LocalDate.of(2023, 9, 1), aluguel.getDataInicio());
        // Certifica-se de que dataInicio não aluguel é igual a 10 de setembro de 2023
        assertNotEquals(LocalDate.of(2023, 9, 10), aluguel.getDataInicio());
    }

    /**
     * Caso de teste para o método setEquipamento da classe Aluguel.
     * Verifica se o método setEquipamento atualiza corretamente o atributo equipamento.
     */
    @Test
    @DisplayName("Teste - setEquipamento (Equipamento equipamento)")
    public void setEquipamentoTeste() {
        aluguel.setEquipamento(equipamento01);
        aluguel.setEquipamento(equipamento02);
        // Certifica-se de que o equipamento agora é igual a equipamento02
        assertEquals(equipamento02, aluguel.getEquipamento());
        // Certifica-se de que o equipamento não é igual a equipamento01
        assertNotEquals(equipamento01, aluguel.getEquipamento());
    }

    /**
     * Caso de teste para o método getCliente da classe Aluguel.
     * Verifica se o método getCliente retorna corretamente o atributo cliente.
     */
    @Test
    @DisplayName("Teste - getCliente()")
    public void getClientTeste() {
        aluguel.setCliente(cliente01);
        // Certifica-se de que o cliente é igual a cliente01
        assertEquals(cliente01, aluguel.getCliente());
        aluguel.setCliente(cliente02);
        // Certifica-se de que o cliente agora é não igual a cliente01
        assertNotEquals(cliente01, aluguel.getCliente());
    }

    /**
     * Caso de teste para o método setDataInicio da classe Aluguel.
     * Verifica se o método getDataInicio retorna corretamente o atributo dataInicio.
     */
    @Test
    @DisplayName("Teste - setDataInicio(LocalDatal data)")
    public void setDataInicioTeste() {
        aluguel.setDataInicio(LocalDate.of(2010, 10, 8));
        // Certifica-se de que dataInicio do aluguel é igual a 1 de setembro de 2023
        assertEquals(LocalDate.of(2010, 10, 8), aluguel.getDataInicio());
        // Certifica-se de que dataInicio não aluguel é igual a 10 de setembro de 2023
        assertNotEquals(LocalDate.of(2023, 9, 10), aluguel.getDataInicio());
    }
}
