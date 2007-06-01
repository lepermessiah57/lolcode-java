package com.lolcode;

import java.io.FileNotFoundException;

/**
 * @author brianegge
 */
public class HaiWorldTest extends RuntimeTestCase {

    public void testHaiWorld() throws FileNotFoundException, ParseException {
        parse("hello_world.LOL");
        assertEquals("HAI WORLD" + Runtime.EOL, runtime.getStdOut());
        assertEquals("", runtime.getStdErr());
    }
}
