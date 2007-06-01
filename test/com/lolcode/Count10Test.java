package com.lolcode;

import junit.framework.TestCase;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

/**
 * @author brianegge
 */
public class Count10Test extends TestCase {

    private final TestRuntime runtime = new TestRuntime();

    public void testCount10() throws FileNotFoundException, ParseException {
        LolCode parser = new LolCode(new java.io.FileInputStream("test/samples/Count!!1.LOL"));
        LolTree tree = parser.start();
        Run run = new Run(tree, runtime);
        run.run();
        List<String> s = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");
        assertEquals(s, Arrays.asList(runtime.getStdOut().split(Runtime.EOL)));
        assertEquals("", runtime.getStdErr());
    }
}
