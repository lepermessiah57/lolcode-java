package com.lolcode;

import java.util.List;

/**
 * @author brianegge
 */
public class StatementLoop implements Statement {
    private final List<Statement> statements;

    public StatementLoop(List<Statement> statements) {
        this.statements = statements;
    }

    public int execute(Runtime runtime) {
        while (true) {
            for (Statement statement : statements) {
                int stack = statement.execute(runtime);
                if (stack != 0) {
                    return stack - 1;
                }
            }
        }
    }
}
