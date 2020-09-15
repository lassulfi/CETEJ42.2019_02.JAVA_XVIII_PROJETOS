package br.utfpr.craps.dominio;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DadoTest {

    @Test
    public void deveRetornarUmNumeroEntre1e6() {
        Dado dado = new Dado();
        int numero = dado.rolar();

        assertTrue(numero > 1);
        assertTrue(numero < 6);
    }
}
