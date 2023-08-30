public class Aluguel {

    private Cliente cliente;
    private Equipamento equipamento;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Aluguel(Cliente cliente, Equipamento equipamento, LocalDate dataInicio, LocalDate dataFim) {
        this.cliente = cliente;
        this.equipamento = equipamento;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Aluguel() {
        this.cliente = null;
        this.equipamento = null;
        this.dataInicio = null;
        this.dataFim = null;
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
}