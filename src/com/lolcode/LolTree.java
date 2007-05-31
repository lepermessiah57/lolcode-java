package com.lolcode;

import java.util.ArrayList;

/**
 * @author brianegge
 */
public class LolTree extends ArrayList<Statement> {
    private final LolTree parent;

    public LolTree(LolTree parent) {
        this.parent = parent;
    }

    public boolean isRoot() {
        return parent == null;
    }
}
