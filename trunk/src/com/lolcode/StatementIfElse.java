package com.lolcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author brianegge
 */
public class StatementIfElse implements Statement {
    private final Expression expr;
    private final List<Statement> then;
    private final List<Statement> Else;

    public StatementIfElse(Expression expr, Statement... then) {
        this(expr, Arrays.asList(then), null);
    }

    public StatementIfElse(Expression expr, List<Statement> then, List<Statement> Else) {
        this.expr = expr;
        this.then = then;
        this.Else = Else;
    }

    public int execute(Runtime runtime) {
        Boolean result[] = new Boolean[1];
        int state = expr.execute(runtime, result);
        if (state != 0) {
            return state - 1;
        }
        if (result[0]) {
            if (then != null) {
                for (Statement statement : then) {
                    int stack = statement.execute(runtime);
                    if (stack != 0) {
                        return stack;
                    }
                }
            }
        }
        if (Else != null) {
            for (Statement statement : Else) {
                int stack = statement.execute(runtime);
                if (stack != 0) {
                    return stack;
                }
            }
        }
        return 0;
    }
}
