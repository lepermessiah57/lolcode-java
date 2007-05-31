package com.lolcode;

import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author brianegge
 */
public class HaiWorldTest extends TestCase implements Runtime {

    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bout);
    ByteArrayOutputStream berr = new ByteArrayOutputStream();
    PrintStream err = new PrintStream(berr);
    private static final String EOL = System.getProperty("line.separator");

    public PrintStream out() {
        return out;
    }

    public PrintStream err() {
        return err;
    }

    public void testHaiWorld() throws FileNotFoundException, ParseException {
        LolCode parser = new LolCode(new java.io.FileInputStream("test/samples/hello_world.LOL"));
        LolTree tree = parser.start();
        Run run = new Run(tree, this);
        run.run();
        assertEquals("HAI WORLD" + EOL, bout.toString());
        assertEquals(0, berr.size());
    }
}
