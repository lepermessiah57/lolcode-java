package com.lolcode;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

/**
 * @author brianegge
 */
public class Count10Test extends RuntimeTestCase {

    public void testCount10() throws FileNotFoundException, ParseException {
        parse("Count!!1.LOL");
        List<String> s = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");
        assertEquals(s, Arrays.asList(runtime.getStdOut().split(Runtime.EOL)));
        assertEquals("", runtime.getStdErr());
    }
}
