package com.lolcode.parser;

/**
 * @author brianegge
 */
public class LolNode {
    /**
     * Every node member which can be executed should implement this method.  It has a default implementation
     * as some nodes such as data don't need to implement this method.
     *
     * @param runtime the stack and variables
     */
    public void interpret(com.lolcode.Runtime runtime) {
        throw new UnsupportedOperationException(this.getClass().getName() + " is not implemented");
    }
}
