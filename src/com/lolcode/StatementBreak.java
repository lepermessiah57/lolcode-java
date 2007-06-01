package com.lolcode;

/**
 * @author brianegge
 */
public class StatementBreak implements Statement {
    public int execute(Runtime runtime) {
        return 1; // Pop the stack one level
    }
}
