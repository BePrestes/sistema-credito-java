package model;


public class ResultadoAvaliacao {

    public String mensagem;
    public boolean bloqueado;

    public ResultadoAvaliacao(String mensagem, boolean bloqueado) {
        this.mensagem = mensagem;
        this.bloqueado = bloqueado;
    }

    public String getMensagem() {
        return mensagem;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }
}