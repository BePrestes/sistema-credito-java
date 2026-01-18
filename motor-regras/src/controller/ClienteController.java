package controller;

import model.Cliente;
import model.ResultadoAvaliacao;
import service.ClienteService;
import view.MenuView;

public class ClienteController {

    private final ClienteService service;
    private final MenuView view;

    public ClienteController(ClienteService service, MenuView view) {
        this.service = service;
        this.view = view;
    }

    public void iniciar() {
        int opcao;

        System.out.println("Bem-vindo ao sistema!");

        do {
            opcao = view.mostrarMenu();

            try {
                switch (opcao) {
                    case 1 -> {
                        var sc = view.getScanner();
                        System.out.print("ID: ");
                        Long id = sc.nextLong();
                        System.out.print("Nome: ");
                        String nome = sc.next();
                        System.out.print("VIP (true/false): ");
                        boolean vip = sc.nextBoolean();
                        System.out.print("Dias de atraso: ");
                        int atraso = sc.nextInt();

                        service.cadastrar(new Cliente(id, nome, vip, atraso));
                        System.out.println("Cliente cadastrado com sucesso!");
                    }

                    case 2 -> service.listar()
                            .forEach(c ->
                                    System.out.println(
                                            c.getId() + " - " +
                                                    c.getNome() + " - " +
                                                    c.getStatus()
                                    )
                            );

                    case 3 -> {
                        System.out.println("Aguarde, estamos consultando...");
                        System.out.print("ID do cliente: ");
                        Long id = view.getScanner().nextLong();
                        ResultadoAvaliacao r = service.avaliar(id);
                        System.out.println(r.getMensagem());
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (opcao != 0);

        System.out.println("Volte sempre!");
    }
}
