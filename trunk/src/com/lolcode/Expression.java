package com.lolcode;

/**
 * @author brianegge
 */
public interface Expression {

    int execute(Runtime runtime, Boolean[] result);
}
