package test.java.com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.java.org.example.entities.Aluguel;
import main.java.org.example.entities.Cliente;
import main.java.org.example.entities.Equipamento;
import main.java.org.example.enums.TipoEquipamento;

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
	@DisplayName("Teste - verificaDataNascimento()")
	public void verificaDataNascimentoTeste() throws Exception {
		// verifica se ano do nascimento é inválido (menor que 1900 ou maior que 2005)
		assertFalse(cliente01.verificaDataNascimento(LocalDate.of(2006, 10, 8)));
		// verifica se ano do nascimento é válido (entre 1900 e 2005)
		assertTrue(cliente01.verificaDataNascimento(LocalDate.of(1980, 10, 8)));
	}

	/**
	 * Caso de teste para o construtor da classe Cliente com parâmetros. Verifica se
	 * o construtor inicializa corretamente.
	 */

	@Test
	@DisplayName("Teste - Cliente (String nome, LocalDate dataNascimento, String cpf)")
	public void clienteTest() {
		assertEquals(LocalDate.of(1980, 10, 8), cliente01.getDataNascimento());
		assertEquals("Jose", cliente01.getNome());
		assertEquals("12345678955", cliente01.getCpf());
	}

	/**
	 * Caso de teste para o método getListaDeAlugueis da classe Cliente. Verifica se
	 * o método getListaDeAlugueis retorna corretamente a lista.
	 */

	@Test
	@DisplayName("Teste - ListaDeAlugueisNaoNulo()")
	public void ListaDeAlugueisNaoNulo() {
		// Certifica-se de que a lista contém alugueis
		assertNotNull(cliente01.getListaDeAlugueis());
	}

}
