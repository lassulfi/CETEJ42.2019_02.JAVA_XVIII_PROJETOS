package br.utfpr;

import java.util.Random;

public class MyRandomNumber {
    private final Random random;

    private static int lastValue = 0;

    public MyRandomNumber(Random random) {
        this.random = random;
    }

    /**
     *
     * @param begin inicio do intervalo
     * @param end fim do intervalo
     * @return retornar um numero aleatorio entre [begin, end]
     * o numero aleatorio retornado nao pode ser igual ao anterior
     * @throws IntervaloInvalidoException
     * essa excecao eh lancada quando begin >= end ou (begin<0 || end<0)
     *
     */
    public int nextRandomNumber(int begin, int end) throws IntervaloInvalidoException {

        validateInterval(begin, end);
        int currentValue = getRandomNumber(begin, end);

        while (currentValue == lastValue) {
            currentValue = getRandomNumber(begin, end);
        }
        lastValue = currentValue;

        return currentValue;
    }

    private void validateInterval(int begin,int end) throws IntervaloInvalidoException {
        if(begin < 0 || end < 0 || begin >= end)

            throw new IntervaloInvalidoException("begin eh menor que zero");
    }

    private int getRandomNumber(int begin, int end) {
        return random.nextInt(end - begin) + begin;
    }
}
