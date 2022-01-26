package br.com.sala.java.io.test;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class TesteEscritaPrintStreamPrintWriter {

    public static void main(String[] args) throws IOException {
    	
    	PrintStream ps = new PrintStream("lorem2.txt");

    	ps.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
    	ps.print("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam");

    	ps.close();
 
        PrintWriter pw = new PrintWriter("lorem2.txt", "UTF-8");

        pw.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        pw.print("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam");

        pw.close();
    }
}
