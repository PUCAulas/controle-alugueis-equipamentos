package test.java.com.example;

import static org.junit.jupiter.api.Assertions.*;

import main.java.org.example.entities.Equipamento;
import main.java.org.example.enums.TipoEquipamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EquipamentoTest {

    Equipamento equipamento01;
    Equipamento equipamento02;

    /**
     * Construtores padroes usados nos testes
     *
     * @throws Exception Caso o construtor seja invalido, lanca excecao
     */
    @BeforeEach
    public void setUp() throws Exception {
        equipamento01 = new Equipamento("Martelo", "Martelo Tipo Pena 800gr Worker", TipoEquipamento.FERRAMENTA, 5.32);
        equipamento02 = new Equipamento("Caminhao", "Caminhão Caçamba", TipoEquipamento.VEICULO, 129.65);
    }

    /**
     * Caso de teste para o nome da classe Equipamento.
     * Verifica se o nome do equipamento retorna corretamente o atributo definido.
     */
    @Test
    @DisplayName("Testa NomeEquipamento")
    public void testNomeEquipamento() {
        assertEquals("Martelo", equipamento01.getNome());
        assertEquals("Caminhao", equipamento02.getNome());
    }

    /**
     * Caso de teste para a descricao da classe Equipamento.
     * Verifica se a descricao do equipamento retorna corretamente o atributo
     * definido.
     */
    @Test
    @DisplayName("Testa DescricaoEquipamento")
    public void testDescricaoEquipamento() {
        assertEquals("Martelo Tipo Pena 800gr Worker", equipamento01.getDescricao());
        assertEquals("Caminhão Caçamba", equipamento02.getDescricao());
    }

    /**
     * Caso de teste para o tipo da classe Equipamento.
     * Verifica se o tipo do equipamento retorna corretamente o atributo definido.
     */
    @Test
    @DisplayName("Testa TipoEquipamento")
    public void testTipoEquipamento() {
        assertEquals(TipoEquipamento.FERRAMENTA, equipamento01.getTipoEquipamento());
        assertEquals(TipoEquipamento.VEICULO, equipamento02.getTipoEquipamento());
    }

    /**
     * Caso de teste para o valorDiaria da classe Equipamento.
     * Verifica se o valorDiaria do equipamento retorna corretamente o atributo
     * definido.
     */
    @Test
    @DisplayName("Testa ValorDiariaEquipamento")
    public void testValorDiariaEquipamento() {
        assertEquals(5.32, equipamento01.getValorDiaria());
        assertEquals(129.65, equipamento02.getValorDiaria());
    }

}