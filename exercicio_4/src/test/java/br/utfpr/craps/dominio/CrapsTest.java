package br.utfpr.craps.dominio;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class CrapsTest {

    private Craps craps;
    private Dado dadoMock;

    @Before
    public void setup() {
        dadoMock = Mockito.mock(Dado.class);
        craps = new Craps(dadoMock);
    }

    @Test
    public void jogadorPerdeNaPrimeiraRolagemDeDados() {
        when(dadoMock.rolar()).thenReturn(1);

        craps.rolarDados();

        assertTrue(craps.isFimDeJogo());
        assertEquals(2, craps.getVencedor());
    }

    @Test
    public void jogadorGanhaNaPrimeiraRolagem() {
        when(dadoMock.rolar()).thenReturn(5, 2);

        craps.rolarDados();

        assertTrue(craps.isFimDeJogo());
        assertEquals(1, craps.getVencedor());
    }

    @Test
    public void jogadorPerdeNaTerceiraRolagem() {
        when(dadoMock.rolar()).thenReturn(3, 5);
        craps.rolarDados();
        assertFalse(craps.isFimDeJogo());

        when(dadoMock.rolar()).thenReturn(6, 5);
        craps.rolarDados();
        assertFalse(craps.isFimDeJogo());

        when(dadoMock.rolar()).thenReturn(5, 2);
        craps.rolarDados();
        assertTrue(craps.isFimDeJogo());
        assertEquals(2, craps.getVencedor());
    }

    @Test
    public void jogadorGanhaNaSegundaRolagem() {
        when(dadoMock.rolar()).thenReturn(1, 3);
        craps.rolarDados();
        assertFalse(craps.isFimDeJogo());

        when(dadoMock.rolar()).thenReturn(2, 2);
        craps.rolarDados();
        assertTrue(craps.isFimDeJogo());
        assertEquals(1, craps.getVencedor());
    }

    @Test
    public void jogadorPerdeNaSegundaRolagem() {
        when(dadoMock.rolar()).thenReturn(1, 3);
        craps.rolarDados();
        assertFalse(craps.isFimDeJogo());

        when(dadoMock.rolar()).thenReturn(5, 2);
        craps.rolarDados();
        assertTrue(craps.isFimDeJogo());
        assertEquals(2, craps.getVencedor());
    }
}
