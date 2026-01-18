package regras;

import model.Cliente;
import model.ResultadoAvaliacao;
import motor.RegraAvaliacao;

public class NovoClienteRegra implements RegraAvaliacao {

    @Override
    public boolean appliesTo(Cliente cliente) {
        return !cliente.isVip() && cliente.getDiasAtraso() == 0;
    }

    @Override
    public ResultadoAvaliacao execute(Cliente cliente) {
        return new ResultadoAvaliacao(
                "Novo cliente aprovado com restrições",
                false
        );
    }
}
