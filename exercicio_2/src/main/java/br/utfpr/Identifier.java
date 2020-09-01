package br.utfpr;

import br.utfpr.exceptions.IdentifierException;

import java.util.regex.Pattern;

public class Identifier {

    public Identifier() {
    }

    public boolean identify(String identifier) throws IdentifierException {

        if (identifier == null || identifier.isEmpty()) {
            throw new IdentifierException("Identifier should not be empty or null");
        }

        String str = identifier.toLowerCase();
        return Pattern.compile("(?=[a-z])([a-z0-9]){1,6}").matcher(str).matches();
    }
}
