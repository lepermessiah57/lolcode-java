package com.lolcode.tests;

import com.lolcode.parser.LolCode;
import com.lolcode.parser.ParseException;
import junit.framework.TestCase;

import java.io.FileNotFoundException;

/**
 * @author brianegge
 */
public class RuntimeTestCase extends TestCase {

    final TestRuntime runtime = new TestRuntime();

    void parse(String file) throws FileNotFoundException, ParseException {
        LolCode parser = new LolCode(new java.io.FileInputStream("test/samples/" + file));
        parser.CompilationUnit().interpret(runtime);
        assertTrue("Items still on stack", runtime.stack.empty());
    }

}
