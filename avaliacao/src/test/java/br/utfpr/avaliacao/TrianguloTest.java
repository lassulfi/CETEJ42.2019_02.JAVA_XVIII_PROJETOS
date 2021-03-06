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
    public void CT01_deveClassificarComoTrianguloEquilatero() throws TrianguloException {
        // cenario
        int lado1 = 10, lado2 = 10, lado3 = 10;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
        assertEquals("equilatero", classificacao.toLowerCase());
    }

    @Test
    public void CT02_deveClassificarComoTrianguloIsoceles() throws TrianguloException {
        // cenario
        int lado1 = 10, lado2 = 10, lado3 = 8;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
        assertEquals("isoceles", classificacao.toLowerCase());
    }

    @Test
    public void CT03_deveClassificarComoTrianguloEscaleno() throws TrianguloException {
        // cenario
        int lado1 = 10, lado2 = 9, lado3 = 8;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
        assertEquals("escaleno", classificacao.toLowerCase());
    }

    @Test
    public void CT04_deveClassificarComoTrianguloIsocelesPrimeiraPermutacao() throws TrianguloException {
        // cenario
        int lado1 = 20, lado2 = 20, lado3 = 18;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
        assertEquals("isoceles", classificacao.toLowerCase());
    }

    @Test
    public void CT05_deveClassificarComoTrianguloIsocelesSegundaPermutacao() throws TrianguloException {
        // cenario
        int lado1 = 20, lado2 = 16, lado3 = 20;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
        assertEquals("isoceles", classificacao.toLowerCase());
    }

    @Test
    public void CT06_deveClassificarComoTrianguloIsocelesTerceiraPermutacao() throws TrianguloException {
        // cenario
        int lado1 = 15, lado2 = 20, lado3 = 20;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
        assertEquals("isoceles", classificacao.toLowerCase());
    }

    @Test(expected = TrianguloException.class)
    public void CT07_deveLancarExcecaoSeUmLadoForNulo() throws TrianguloException {
        // cenario
        int lado1 = 0, lado2 = 20, lado3 = 20;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
    }

    @Test(expected = TrianguloException.class)
    public void CT08_deveLancarExcecaoSeUmLadoForNuloPrimeiraPermutacao() throws TrianguloException {
        // cenario
        int lado1 = 20, lado2 = 0, lado3 = 20;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
    }

    @Test(expected = TrianguloException.class)
    public void CT09_deveLancarExcecaoSeUmLadoForNuloSegundaPermutacao() throws TrianguloException {
        // cenario
        int lado1 = 20, lado2 = 0, lado3 = 20;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
    }

    @Test(expected = TrianguloException.class)
    public void CT10_deveLancarExcecaoSeUmLadoForNegativo() throws TrianguloException {
        // cenario
        int lado1 = -10, lado2 = 20, lado3 = 20;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
    }

    @Test(expected = TrianguloException.class)
    public void CT11_deveLancarExcecaoSeUmLadoForNegativoPrimeiraPermutacao() throws TrianguloException {
        // cenario
        int lado1 = 20, lado2 = -10, lado3 = 20;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
    }

    @Test(expected = TrianguloException.class)
    public void CT12_deveLancarExcecaoSeUmLadoForNegativoSegundaPermutacao() throws TrianguloException {
        // cenario
        int lado1 = 20, lado2 = 20, lado3 = -20;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
    }

    @Test(expected = TrianguloException.class)
    public void CT13_deveLancarExcecaoSeSomaDeDoisLadosForIgualAoTerceiro() throws TrianguloException {
        // cenario
        int lado1 = 20, lado2 = 20, lado3 = 40;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
    }

    @Test(expected = TrianguloException.class)
    public void CT14_deveLancarExcecaoSeSomaDeDoisLadosForIgualAoTerceiroPrimeiraPermutacao()
            throws TrianguloException {
        // cenario
        int lado1 = 40, lado2 = 20, lado3 = 20;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
    }

    @Test(expected = TrianguloException.class)
    public void CT15_deveLancarExcecaoSeSomaDeDoisLadosForIgualAoTerceiroSegundaPermutacao()
            throws TrianguloException {
        // cenario
        int lado1 = 20, lado2 = 40, lado3 = 20;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
    }

    @Test(expected = TrianguloException.class)
    public void CT16_deveLancarExcecaoSeSomaDeDoisLadosForIgualAoTerceiroTerceiraPermutacao()
            throws TrianguloException {
        // cenario
        int lado1 = 20, lado2 = 20, lado3 = 40;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
    }

    @Test(expected = TrianguloException.class)
    public void CT17_deveLancarExcecaoSeSomaDeDoisLadosForMenorQueTerceiro() throws TrianguloException {
        // cenario
        int lado1 = 20, lado2 = 20, lado3 = 60;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
    }

    @Test(expected = TrianguloException.class)
    public void CT18_deveLancarExcecaoSeSomaDeDoisLadosForMenorQueTerceiroPrimeiraPermutacao()
            throws TrianguloException {
        // cenario
        int lado1 = 60, lado2 = 20, lado3 = 20;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
    }

    @Test(expected = TrianguloException.class)
    public void CT19_deveLancarExcecaoSeSomaDeDoisLadosForMenorQueTerceiroSegundaPermutacao()
            throws TrianguloException {
        // cenario
        int lado1 = 20, lado2 = 60, lado3 = 20;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
    }

    @Test(expected = TrianguloException.class)
    public void CT20_deveLancarExcecaoParaTodosLadosNulos() throws TrianguloException {
        // cenario
        int lado1 = 20, lado2 = 60, lado3 = 20;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
    }

    @Test(expected = TrianguloException.class)
    public void CT21_deveLancarExcecaoParaTodosLadosNegativos() throws TrianguloException {
        // cenario
        int lado1 = -20, lado2 = -60, lado3 = -20;

        //ação
        String classificacao = triangulo.classificar(lado1, lado2, lado3);

        // validacao
    }
}
