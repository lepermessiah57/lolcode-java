package com.lolcode;

import java.io.PrintStream;

/**
 * @author brianegge
 */
public interface Runtime {
    PrintStream out();

    PrintStream err();
}
