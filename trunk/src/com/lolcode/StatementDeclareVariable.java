package com.lolcode;

/**
 * @author brianegge
 */
public class StatementDeclareVariable implements Statement {

    private final Token variable;

    public StatementDeclareVariable(Token variable) {
        this.variable = variable;
    }

    public int execute(Runtime runtime) {
        if (runtime.variables.containsKey(variable.image)) {
            runtime.setError(variable, "ALREADY HAS " + variable.image);
            return -1;
        }
        runtime.variables.put(variable.image, null);
        return 0;
    }
}
