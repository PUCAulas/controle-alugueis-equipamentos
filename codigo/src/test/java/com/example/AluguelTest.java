package test.java.com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.java.org.example.entities.Aluguel;
import main.java.org.example.entities.Cliente;
import main.java.org.example.entities.Equipamento;
import main.java.org.example.enums.TipoEquipamento;

class AluguelTest {

	Cliente cliente01 = new Cliente("Jose", LocalDate.of(1980, 10, 8), "12345678955");
	Cliente cliente02 = new Cliente("Maria", LocalDate.of(1970, 9, 1), "98765432122");
	Equipamento equipamento01 = new Equipamento("Martelo", "Martelo Tipo Pena 800gr Worker", TipoEquipamento.FERRAMENTA, 5.32);
	Equipamento equipamento02 = new Equipamento("Caminhao", "Caminhão Caçamba", TipoEquipamento.VEICULO, 129.65);
	Aluguel aluguel = new Aluguel(cliente01, equipamento01, LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 10));

	@Test
	@DisplayName("Test - Aluguel (Cliente cliente, Equipamento equipamento, LocalDate dataInicio, LocalDate dataFim)")
	public void aluguelTest() {
		assertEquals(LocalDate.of(2023, 9, 1), aluguel.getDataInicio());
		assertNotEquals(LocalDate.of(2023, 9, 10), aluguel.getDataInicio());
	}

	@Test
	@DisplayName("Test - setEquipamento (Equipamento equipamento)")
	public void setEquipamentoTest() {
		aluguel.setEquipamento(equipamento01);
		aluguel.setEquipamento(equipamento02);
		assertEquals(equipamento02, aluguel.getEquipamento());
		assertNotEquals(equipamento01, aluguel.getEquipamento());
	}

	@Test
	@DisplayName("Test - getCliente ( )")
	public void getClientTest() {
		aluguel.setCliente(cliente01);
		assertEquals(cliente01, aluguel.getCliente());
		aluguel.setCliente(cliente02);
		assertNotEquals(cliente01, aluguel.getCliente());
	}

}
