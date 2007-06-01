package com.lolcode;

/**
 * @author brianegge
 */
public class StatementRequire implements Statement {

    private final Token resource;

    public StatementRequire(Token resource) {
        this.resource = resource;
    }

    public int execute(Runtime runtime) {
        if ("STDIO".equals(resource.image)) {
            return 0;
        }
        runtime.setError(resource, "HAS NO " + resource.image);
        return -1;
    }
}
