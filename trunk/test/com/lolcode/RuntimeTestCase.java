package com.lolcode;

import junit.framework.TestCase;

import java.io.FileNotFoundException;

/**
 * @author brianegge
 */
public class RuntimeTestCase extends TestCase {

    protected final TestRuntime runtime = new TestRuntime();

    protected void parse(String file) throws FileNotFoundException, ParseException {
        LolCode parser = new LolCode(new java.io.FileInputStream("test/samples/" + file));
        LolTree tree = parser.start();
        Run run = new Run(tree, runtime);
        run.run();
    }

}
