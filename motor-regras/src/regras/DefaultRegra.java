package regras;

import model.Cliente;
import model.ResultadoAvaliacao;
import motor.RegraAvaliacao;


public class DefaultRegra implements RegraAvaliacao {


    @Override
    public boolean appliesTo(Cliente cliente) {
        return true;
    }


    @Override
    public ResultadoAvaliacao execute(Cliente cliente) {
        return new ResultadoAvaliacao("Cliente em análise manual", false);
    }
}