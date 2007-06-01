package com.lolcode;

import junit.framework.TestCase;

import java.io.FileNotFoundException;

/**
 * @author brianegge
 */
public class HaiWorldTest extends TestCase {

    private final TestRuntime runtime = new TestRuntime();

    public void testHaiWorld() throws FileNotFoundException, ParseException {
        LolCode parser = new LolCode(new java.io.FileInputStream("test/samples/hello_world.LOL"));
        LolTree tree = parser.start();
        Run run = new Run(tree, runtime);
        run.run();
        assertEquals("HAI WORLD" + Runtime.EOL, runtime.getStdOut());
        assertEquals("", runtime.getStdErr());
    }
}
