package br.utfpr.avaliacao;

public class Triangulo {

    /**
     * Dado três lados de triangulo, realiza a sua classificação com relação aos seus lados
     *
     * @param lado1 {int} lado 1 do triangulo
     * @param lado2 {int} lado 2 do triangulo
     * @param lado3 {int} lado 3 do triangulo
     * @return {String} "equilatero" se o triangulo possui três lados iguais
     *                  "isoceles" se o triangulo possui dois lados iguais
     *                  "escaleno" se o triangulo possui três lados diferentes
     */
    public String classificar(int lado1, int lado2, int lado3) throws TrianguloException {

        if(lado1 == 0 || lado2 == 0 || lado3 == 0) {
            throw new TrianguloException("Triangulo inválido");
        }

        if(validarSomaLados(lado1, lado2, lado3)) {
            if(lado1 == lado2 && lado1 == lado3 && lado2 == lado3) {
                return "equilatero";
            }
            if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
                return "isoceles";
            }
            return "escaleno";
        }
        return null;
    }

    /**
     * Valida se a soma de dois lados de um triangulo é maior que o terceiro lado
     * @param lado1 {int} lado 1 do triangulo
     * @param lado2 {int} lado 2 do triangulo
     * @param lado3 {int} lado 3 do triangulo
     * @return {boolean}    true se a soma é maior
     *                      false se é menor
     */
    private boolean validarSomaLados(int lado1, int lado2, int lado3) {
        return lado1 < lado2 + lado3 && lado2 < lado1 + lado3 && lado3 < lado1 + lado2;
    }
}
