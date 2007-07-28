package com.lolcode.tests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Provides a test runtime, so we can capture the stdout / stderr streams and assert the values.
 *
 * @author brianegge
 */
public class TestRuntime extends com.lolcode.Runtime {

    private final ByteArrayOutputStream bout = new ByteArrayOutputStream();
    private final PrintStream out = new PrintStream(bout);
    private final ByteArrayOutputStream berr = new ByteArrayOutputStream();
    private final PrintStream err = new PrintStream(berr);
//    private InputStreamReader in = new InputStreamReader(new ByteArrayInputStream(new byte[]{}));

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

//    public void setStdIn(String s) {
//        in = new InputStreamReader(new ByteArrayInputStream( ));
//    }
}
