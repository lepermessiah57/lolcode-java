package com.lolcode;

/**
 * @author brianegge
 */
public class StatementFunction implements Statement {
    private final Token verb;
    private final Token variable;
    private final Object arg;

    public StatementFunction(Token verb, Token variable, Object arg) {
        this.verb = verb;
        this.variable = variable;
        this.arg = arg;
    }

    public int execute(Runtime runtime) {
        if (!runtime.checkVariable(variable)) {
            return -1;
        }
        if ("UP".equals(verb.image)) {
            Object o = runtime.variables.get(variable.image);
            if (o == null) {
                o = 0;
            }
            if (arg instanceof Integer) {
                o = (Integer) o + (Integer) arg;
            } else {
                runtime.setError(variable, "WRONG TYPE");
                return -1;
            }
            runtime.variables.put(variable.image, o);
        }
        return 0;
    }
}
