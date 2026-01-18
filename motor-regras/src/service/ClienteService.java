package service;

import model.Cliente;
import model.ResultadoAvaliacao;
import model.StatusCliente;
import motor.MotorRegras;
import repository.ClienteRepository;

public class ClienteService {

    private final ClienteRepository repo;
    private final MotorRegras motor;

    public ClienteService(ClienteRepository repo, MotorRegras motor) {
        this.repo = repo;
        this.motor = motor;
    }

    public void cadastrar(Cliente cliente) {

        if (cliente.getId() <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }

        if (cliente.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome obrigatório");
        }

        if (repo.buscar(cliente.getId()) != null) {
            throw new IllegalStateException("Cliente já cadastrado");
        }

        repo.salvar(cliente);
    }

    public ResultadoAvaliacao avaliar(Long id) {

        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }

        Cliente cliente = repo.buscar(id);

        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado");
        }

        if (cliente.getStatus() != StatusCliente.EM_ANALISE) {
            throw new IllegalStateException("Cliente já avaliado");
        }

        ResultadoAvaliacao resultado = motor.process(cliente);

        if (resultado.isBloqueado()) {
            cliente.setStatus(StatusCliente.BLOQUEADO);
        } else {
            cliente.setStatus(StatusCliente.ATIVO);
        }

        repo.atualizar(cliente);
        return resultado;
    }

    public Iterable<Cliente> listar() {
        return repo.listar();
    }
}
