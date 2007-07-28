package com.lolcode.tests;

import com.lolcode.parser.ParseException;
import junit.framework.Assert;

import java.io.FileNotFoundException;

/**
 * @author brianegge
 */
public class HaiWorldTest extends RuntimeTestCase {

    public void testHaiWorld() throws FileNotFoundException, ParseException {
        parse("hello_world.LOL");
        Assert.assertEquals("HAI WORLD!" + com.lolcode.Runtime.EOL, runtime.getStdOut());
        assertEquals("", runtime.getStdErr());
    }
}
