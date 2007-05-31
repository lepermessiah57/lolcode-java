package com.lolcode;

/**
 * A parser for Adam Lindsay's <a href="http://lolcode.com">LOLCODE</a> programming language
 *
 * @author brianegge
 */
public final class Parse {

    private Parse() {
    }

    /**
     * @param args optional; the name of the files to parse
     * @throws ParseException If the LOL program fails to parse
     */
    public static void main(String args[]) throws ParseException {
        LolCode parser;
        if (args.length == 0) {
            parser = new LolCode(System.in);
            parser.start();
        } else {
            try {
                for (String file : args) {
                    parser = new LolCode(new java.io.FileInputStream(file));
                    parser.start();
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
