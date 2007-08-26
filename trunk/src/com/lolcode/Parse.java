package com.lolcode;

import com.lolcode.parser.LolCode;
import com.lolcode.parser.ParseException;

/**
 * A parser for Adam Lindsay's <a href="http://lolcode.com">LOLCODE</a> programming language
 * <p/>
 * This will parse, but not execute the given LOLCODE.  This can be used to verify the syntax of the program.
 *
 * @author brianegge
 */
public final class Parse {

    private Parse() {
    }

    /**
     * @param args optional; the name of the files to parse
     * @throws com.lolcode.parser.ParseException
     *          If the LOL program fails to parse
     */
    public static void main(String args[]) throws ParseException {
        LolCode parser;
        if (args.length == 0) {
            parser = new LolCode(System.in);
            parser.CompilationUnit();
        } else {
            try {
                for (String file : args) {
                    parser = new LolCode(new java.io.FileInputStream(file));
                    parser.CompilationUnit();
                }

            } catch (java.io.FileNotFoundException e) {
                System.err.println("File " + args[0] + " not found.");
                abort();
            }
        }
    }

    private static void abort() {
        System.out.println("Parse:  Usage is one of:");
        System.out.println("         java Parse < inputfile");
        System.out.println("OR");
        System.out.println("         java Parse inputfile(s)");
        System.exit(1);
    }
}
