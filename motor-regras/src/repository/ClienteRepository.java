package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteRepository {

    private Map<Long, Cliente> dados = new HashMap<>();

    public void salvar(Cliente cliente) {
        dados.put(cliente.getId(), cliente);
    }

    public Cliente buscar(Long id) {
        return dados.get(id);
    }

    public void atualizar(Cliente cliente) {
        dados.put(cliente.getId(), cliente);
    }

    public List<Cliente> listar() {
        return new ArrayList<>(dados.values());
    }
}
