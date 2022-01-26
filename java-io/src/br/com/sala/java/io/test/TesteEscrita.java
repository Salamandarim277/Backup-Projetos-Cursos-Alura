package br.com.sala.java.io.test;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TesteEscrita {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream fos = new FileOutputStream("spoonLocalScript2.txt");
		OutputStreamWriter osr = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osr);
		bw.write("Hello World");
		bw.close();
	}

}

