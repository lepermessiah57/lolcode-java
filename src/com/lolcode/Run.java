package com.lolcode;

import java.io.PrintStream;

/**
 * An interpreter for Adam Lindsay's <a href="http://lolcode.com">LOLCODE</a> programming language
 *
 * @author brianegge
 */
public class Run implements Runtime {
    private final LolTree tree;
    private final Runtime runtime;

    /**
     * @param args optional; the name of the files to parse
     * @throws ParseException If the LOL program fails to parse
     */
    public static void main(String args[]) throws ParseException {
        LolCode parser;
        LolTree tree = null;
        if (args.length == 0) {
            parser = new LolCode(System.in);
            tree = parser.start();
        } else {
            try {
                for (String file : args) {
                    parser = new LolCode(new java.io.FileInputStream(file));
                    tree = parser.start();
                }

            } catch (java.io.FileNotFoundException e) {
                System.err.println("File " + args[0] + " not found.");
                abort();
            }
        }
        Run run = new Run(tree);
        run.run();
    }


    private static void abort() {
        System.out.println("Run:  Usage is one of:");
        System.out.println("         java Run < inputfile");
        System.out.println("OR");
        System.out.println("         java Run inputfile(s)");
        System.exit(1);
    }


    public Run(LolTree tree) {
        this.tree = tree;
        runtime = this;
    }

    public Run(LolTree tree, Runtime runtime) {
        this.tree = tree;
        this.runtime = runtime;
    }

    public void run() {
        for (Statement statement : tree) {
            if (statement != null) {
                statement.execute(runtime);
            }
        }
    }

    public PrintStream out() {
        return System.out;
    }

    public PrintStream err() {
        return System.err;
    }
}
