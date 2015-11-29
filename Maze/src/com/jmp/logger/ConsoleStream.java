package com.jmp.logger;

import java.io.PrintStream;

public class ConsoleStream {

	private static PrintStream outputStream = System.out;
	private static PrintStream errorStream = System.err;

	public static void print(String message) {
		outputStream.print(message);
	}
	
	public static void printLine(String message) {
		outputStream.println(message);
	}
	
	public static void doError(String message) {
		errorStream.println(message);
	}
	
	public static void doLog(String message) {
		errorStream.println(message);
	}
}
