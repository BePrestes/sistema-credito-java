package regras;

import model.Cliente;
import model.ResultadoAvaliacao;
import motor.RegraAvaliacao;

public class InadimplenteRegra implements RegraAvaliacao {

    @Override
    public boolean appliesTo(Cliente cliente) {
        return cliente.getDiasAtraso() > 30;
    }

    @Override
    public ResultadoAvaliacao execute(Cliente cliente) {
        return new ResultadoAvaliacao("Cliente Inadimplente - BLOQUEADO", true);
    }
}


