package com.lolcode;

import com.lolcode.parser.Token;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author brianegge
 */
public abstract class Runtime {
    public static final String EOL = System.getProperty("line.separator");
    public int unwind;

    public abstract PrintStream out();

    public abstract PrintStream err();

    private String lastErrorMessage;
    private Token lastErrorToken;

    public final Map<String, Object> variables = new HashMap<String, Object>();
    public final Stack<Object> stack = new Stack<Object>();

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

    public void push(Object o) {
        stack.push(o);
    }

    public Object pop() {
        return stack.pop();
    }

    public Object getVar(String name) {
        if (!variables.containsKey(name)) {
            throw new LolRuntimeException("HAS NO " + name);
        }
        return variables.get(name);
    }

}
