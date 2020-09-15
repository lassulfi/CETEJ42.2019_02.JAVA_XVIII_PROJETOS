package br.utfpr.craps.ui;

import br.utfpr.craps.dominio.Craps;
import br.utfpr.craps.dominio.Dado;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Craps craps = new Craps(new Dado());

        Scanner scan = new Scanner(System.in);
        while(!craps.isFimDeJogo()) {
            System.out.println("Digite enter para continuar.");
            scan.nextLine();

            int soma = craps.rolarDados();
            System.out.println("Soma: " + soma);
        }
        scan.close();

        if(craps.getVencedor() == 1) {
            System.out.println("Você ganhou!");
        } else if (craps.getVencedor() == 2) {
            System.out.println("A banca ganhou!");
        } else {
            throw new IllegalStateException();
        }
    }
}
