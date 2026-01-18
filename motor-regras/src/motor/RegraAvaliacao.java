package motor;


import model.Cliente;
import model.ResultadoAvaliacao;


public interface RegraAvaliacao {
    boolean appliesTo(Cliente cliente);

    ResultadoAvaliacao execute(Cliente cliente);
}