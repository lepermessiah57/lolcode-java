package com.lolcode;

/**
 * @author brianegge
 */
public class ExpressionBigger implements Expression {
    private final Token variable;
    private final Object arg;

    public ExpressionBigger(Token variable, Object arg) {
        this.variable = variable;
        this.arg = arg;
    }

    public int execute(Runtime runtime, Boolean[] result) {
        if (!runtime.checkVariable(variable)) {
            return -1;
        }
        Object o = runtime.variables.get(variable.image);
        if (o == null) {
            o = 0;
        }
        if (arg instanceof Integer) {
            result[0] = (Integer) o > (Integer) arg;
            return 0;
        } else {
            runtime.setError(variable, "WRONG TYPE");
            return -1;
        }
    }
}
