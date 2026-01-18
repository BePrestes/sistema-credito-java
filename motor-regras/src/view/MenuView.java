package view;

import java.util.Scanner;

public class MenuView {

    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\nSISTEMA DE CRÉDITO");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Listar clientes");
        System.out.println("3 - Avaliar cliente");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
        return scanner.nextInt();
    }

    public Scanner getScanner() {
        return scanner;
    }
}