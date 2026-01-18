package model;

public class Cliente {

    private Long id;
    private String nome;
    private boolean vip;
    private int diasAtraso;
    private StatusCliente status;

    public Cliente(Long id, String nome, boolean vip, int diasAtraso) {
        this.id = id;
        this.nome = nome;
        this.vip = vip;
        this.diasAtraso = diasAtraso;
        this.status = StatusCliente.EM_ANALISE;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isVip() {
        return vip;
    }

    public int getDiasAtraso() {
        return diasAtraso;
    }

    public StatusCliente getStatus() {
        return status;
    }

    public void setStatus(StatusCliente status) {
        this.status = status;
    }
}
