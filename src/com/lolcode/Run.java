package com.lolcode;

import com.lolcode.parser.LolCode;
import com.lolcode.parser.ParseException;

import java.io.PrintStream;

/**
 * An interpreter for Adam Lindsay's <a href="http://lolcode.com">LOLCODE</a> programming language
 *
 * @author brianegge
 */
public class Run extends Runtime {

    /**
     * @param args optional; the name of the files to parse
     * @throws com.lolcode.parser.ParseException
     *          If the LOL program fails to parse
     */
    public static void main(String args[]) throws ParseException {
        LolCode parser;
        Runtime runtime = new Run();
        if (args.length == 0) {
            parser = new LolCode(System.in);
            parser.CompilationUnit();
            parser.CompilationUnit().interpret(runtime);
        } else {
            try {
                for (String file : args) {
                    parser = new LolCode(new java.io.FileInputStream(file));
                    parser.CompilationUnit();
                    parser.CompilationUnit().interpret(runtime);
                }

            } catch (java.io.FileNotFoundException e) {
                System.err.println("File " + args[0] + " not found.");
                abort();
            }
        }
    }


    private static void abort() {
        System.out.println("Run:  Usage is one of:");
        System.out.println("         java Run < inputfile");
        System.out.println("OR");
        System.out.println("         java Run inputfile(s)");
        System.exit(1);
    }

    public PrintStream out() {
        return System.out;
    }

    public PrintStream err() {
        return System.err;
    }
}
