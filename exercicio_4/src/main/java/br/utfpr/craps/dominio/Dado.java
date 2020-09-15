package br.utfpr.craps.dominio;

import java.util.Random;

public class Dado implements IDado {
    private Random rand = new Random();

    public int rolar() {
        return rand.nextInt(6) + 1;
    }
}
