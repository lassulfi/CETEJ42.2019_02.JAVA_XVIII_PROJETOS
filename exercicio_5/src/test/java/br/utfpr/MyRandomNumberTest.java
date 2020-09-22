package br.utfpr;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class MyRandomNumberTest {

    private MyRandomNumber myRandomNumber;

    @Before
    public void setup() {
        myRandomNumber = new MyRandomNumber(new Random());
    }

    @Test(expected = IntervaloInvalidoException.class)
    public void shouldThrownAnExceptionIfBeginIsLessThenZero() throws IntervaloInvalidoException {
        myRandomNumber.nextRandomNumber(-1, 100);
        Assert.fail();
    }

    @Test(expected = IntervaloInvalidoException.class)
    public void shouldThrownAnExceptionIfEndIsLessThenZero() throws IntervaloInvalidoException {
        myRandomNumber.nextRandomNumber(0, -1);
        Assert.fail();
    }

    @Test(expected = IntervaloInvalidoException.class)
    public void shouldThrownAnExceptionIfBeginIsGreaterThenEnd() throws IntervaloInvalidoException {
        myRandomNumber.nextRandomNumber(100, 1);
        Assert.fail();
    }

    @Test(expected = IntervaloInvalidoException.class)
    public void shouldThrownAnExceptionIfBeginIsEqualsToEnd() throws IntervaloInvalidoException {
        myRandomNumber.nextRandomNumber(1, 1);
        Assert.fail();
    }

    @Test
    public void shouldReturnARandomNumberBetweenBeginAndEnd() throws IntervaloInvalidoException {
        int begin = 1, end = 10;
        int number = myRandomNumber.nextRandomNumber(begin, end);
        assertTrue(number >= begin);
        assertTrue(number <= end);
    }

    @Test
    public void currentValueShouldBeDifferentThenTheLastValue() throws IntervaloInvalidoException {
        int begin = 0, end = 10;
        int bound = end - begin;
        Random randomMock = mock(Random.class);
        myRandomNumber = new MyRandomNumber(randomMock);

        when(randomMock.nextInt(bound)).thenReturn(5);
        int firstRandomNumber = myRandomNumber.nextRandomNumber(begin, end);

        when(randomMock.nextInt(bound)).thenReturn(6);
        int secondRandomNumber = myRandomNumber.nextRandomNumber(begin, end);

        assertTrue(firstRandomNumber != secondRandomNumber);
        verify(randomMock, times(2)).nextInt(bound);
    }

    @Test
    public void shouldLoopUntilTheCurrentValueIsDifferentThenTheLastValue()
            throws IntervaloInvalidoException {
        int begin = 0, end = 10;
        int bound = end - begin;
        Random randomMock = mock(Random.class);
        myRandomNumber = new MyRandomNumber(randomMock);

        when(randomMock.nextInt(bound)).thenReturn(5);
        int firstRandomNumber = myRandomNumber.nextRandomNumber(begin, end);

        when(randomMock.nextInt(bound)).thenReturn(5, 2);
        int nextValue = myRandomNumber.nextRandomNumber(begin, end);

        verify(randomMock, times(3)).nextInt(bound);
        assertTrue(nextValue != firstRandomNumber);
    }
}
