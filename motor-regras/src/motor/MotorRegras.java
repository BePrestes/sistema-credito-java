package motor;

import model.Cliente;
import model.ResultadoAvaliacao;

import java.util.List;

public class MotorRegras {

    public List<RegraAvaliacao> regras;

    public MotorRegras(List<RegraAvaliacao> regras) {
        this.regras = regras;
    }

    public ResultadoAvaliacao process(Cliente cliente) {
        for (RegraAvaliacao regra : regras) {
            if (regra.appliesTo(cliente)) {
                return regra.execute(cliente);
            }
        }
        return new ResultadoAvaliacao("Cliente em análise", false);
    }
}