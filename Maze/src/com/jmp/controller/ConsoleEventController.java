package com.jmp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jmp.listener.Listener;
import com.jmp.logger.ConsoleStream;

public class ConsoleEventController implements Runnable {

	private static final String EXIT = "exit";
	private List<Listener> listeners = new ArrayList<Listener>();
	
	@Override
	public void run() {

		try (Scanner scan = new Scanner(System.in)) {
			while (scan.hasNext()) {
				String input = scan.next();	
				
				if(EXIT.equals(input)) { 
					ConsoleStream.doLog("Bye!");
					System.exit(0);
				}

				for(Listener listener : listeners) {
					listener.performAction(input);
				}
			}
		}
	}
	
	public void addListener (Listener l) {
		listeners.add(l);
	}
}
