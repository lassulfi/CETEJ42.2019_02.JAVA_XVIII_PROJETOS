package br.utfpr.avaliacao;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrianguloTest {

    private Triangulo triangulo;

    @Before
    public void setup() {
        triangulo = new Triangulo();
    }

    @Test
    public void deveClassificarComoTrianguloEquilatero() throws TrianguloException {
        // cenario
        int lado1 = 10, lado2 = 10, lado3 = 10;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
        assertEquals("equilatero", classificacao.toLowerCase());
    }

    @Test
    public void deveClassificarComoTrianguloIsoceles() throws TrianguloException {
        // cenario
        int lado1 = 10, lado2 = 10, lado3 = 8;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
        assertEquals("isoceles", classificacao.toLowerCase());
    }

    @Test
    public void deveClassificarComoTrianguloEscaleno() throws TrianguloException {
        // cenario
        int lado1 = 10, lado2 = 9, lado3 = 8;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
        assertEquals("escaleno", classificacao.toLowerCase());
    }

    @Test
    public void deveClassificarComoTrianguloIsocelesPrimeiraPermutacao() throws TrianguloException {
        // cenario
        int lado1 = 20, lado2 = 20, lado3 = 18;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
        assertEquals("isoceles", classificacao.toLowerCase());
    }

    @Test
    public void deveClassificarComoTrianguloIsocelesSegundaPermutacao() throws TrianguloException {
        // cenario
        int lado1 = 20, lado2 = 16, lado3 = 20;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
        assertEquals("isoceles", classificacao.toLowerCase());
    }

    @Test
    public void deveClassificarComoTrianguloIsocelesTerceiraPermutacao() throws TrianguloException {
        // cenario
        int lado1 = 15, lado2 = 20, lado3 = 20;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
        assertEquals("isoceles", classificacao.toLowerCase());
    }

    @Test(expected = TrianguloException.class)
    public void deveLancarExcecaoSeUmLadoForNulo() throws TrianguloException {
        // cenario
        int lado1 = 0, lado2 = 20, lado3 = 20;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
    }
}
