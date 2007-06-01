package com.lolcode;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author brianegge
 */
public abstract class Runtime {
    static final String EOL = System.getProperty("line.separator");

    abstract PrintStream out();

    abstract PrintStream err();

    private String lastErrorMessage;
    private Token lastErrorToken;

    public final Map<String, Object> variables = new HashMap<String, Object>();

    void setError(Token resource, String errorMessage) {
        lastErrorToken = resource;
        lastErrorMessage = errorMessage;
    }

    String getLastError() {
        return lastErrorMessage + " AT " + lastErrorToken.beginLine + ":" + lastErrorToken.beginColumn;
    }

    public boolean checkVariable(Token variable) {
        if (!variables.containsKey(variable.image)) {
            setError(variable, "HAS NO " + variable.image);
            return false;
        }
        return true;
    }
}
