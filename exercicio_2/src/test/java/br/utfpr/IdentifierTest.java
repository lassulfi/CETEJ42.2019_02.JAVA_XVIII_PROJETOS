package br.utfpr;


import br.utfpr.exceptions.IdentifierException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IdentifierTest {

    private Identifier identifier;

    @Before
    public void createIdentifier() {
        this.identifier = new Identifier();
    }

    @Test
    public void shouldValidateAValidIdentifier() throws IdentifierException {
        //parte 1: cenário
        String identifier = "a1";
        //parte 2: ação
        boolean isValid = this.identifier.identify(identifier);
        //parte 3: validacao
        assertTrue(isValid);
    }

    @Test
    public void shouldNotValidateIdentifierStartingWithNumber() throws IdentifierException {
        //parte 1: cenário
        String identifier = "2B3";
        //parte 2: ação
        boolean isValid = this.identifier.identify(identifier);
        //parte 3: validação
        assertFalse(isValid);
    }

    @Test
    public void shouldNotValidateIdentifierContainingSpecialCharacter() throws IdentifierException {
        //parte 1: cenário
        String identifer = "Z-12";
        //parte 2: ação
        boolean isValid = this.identifier.identify(identifer);
        //parte 3: validação
        assertFalse(isValid);
    }

    @Test
    public void shouldNotValidateIdentifierWithMoreThanSixCharacters() throws IdentifierException {
        //parte 1: cenário
        String identifier = "A1b2C3d";
        //parte 2: ação
        boolean isValid = this.identifier.identify(identifier);
        //parte 3: validação
        assertFalse(isValid);
    }

    @Test
    public void shouldValidateIdentifierWithOnlyOneLetter() throws IdentifierException {
        //parte 1: cenário
        String identifier = "d";
        //parte 2: ação
        boolean isValid = this.identifier.identify(identifier);
        //parte 3: validação
        assertTrue(isValid);
    }

    @Test(expected = IdentifierException.class)
    public void shouldThrowAnExceptionIfIdentifierIsEmpty() throws IdentifierException {
        //parte 1: cenário
        String identifier = "";
        //parte 2: ação
        this.identifier.identify(identifier);
        //parte 3: validação
    }

    @Test(expected = IdentifierException.class)
    public void shouldThrownAnExceptionIfIndetifierIsNull() throws IdentifierException {
        //parte 1: cenário
        String identifier = null;
        //parte 2: ação
        this.identifier.identify(identifier);
        //parte 3: validação
    }
}
