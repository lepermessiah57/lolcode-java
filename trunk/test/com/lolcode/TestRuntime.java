package com.lolcode;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author brianegge
 */
public class TestRuntime extends Runtime {

    private final ByteArrayOutputStream bout = new ByteArrayOutputStream();
    private final PrintStream out = new PrintStream(bout);
    private final ByteArrayOutputStream berr = new ByteArrayOutputStream();
    private final PrintStream err = new PrintStream(berr);

    public PrintStream out() {
        return out;
    }

    public PrintStream err() {
        return err;
    }

    public String getStdOut() {
        return bout.toString();
    }

    public String getStdErr() {
        return berr.toString();
    }
}
