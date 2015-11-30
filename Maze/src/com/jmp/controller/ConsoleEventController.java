package com.jmp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jmp.entity.animal.Animal;
import com.jmp.logger.ConsoleStream;
import com.jmp.navigator.Navigator;
import com.jmp.renderer.Renderer;

public class ConsoleEventController implements Runnable {

	private static final String EXIT = "exit";
	
	private Navigator navigator;
	private Renderer renderer;
	
	private List<Animal> animals = new ArrayList<Animal>();
	
	@Override
	public void run() {

		String command;				
		try (Scanner scan = new Scanner(System.in)) {
			while (scan.hasNext()) {
				command = scan.next();							
				if(EXIT.equals(command)) { 
					ConsoleStream.doLog("Bye!");
					System.exit(0);
				}	
				
				for(Animal animal : animals) {
					navigator.setAnimal(animal);					
					String nextCommand = navigator.getNextCommand() == null ? command : navigator.getNextCommand();						
					navigator.moveAnimal(nextCommand);
					navigator.updateNextCommand();
				}
				renderer.render();
			}																								
		}			
	}
	
	public void addAnimals(List<Animal> list) {
		this.animals.addAll(list);
	}

	public void setRenderer(Renderer renderer) {
		this.renderer = renderer;
	}
	
	public void setNavigator(Navigator navigator) {
		this.navigator = navigator;
	}	
}

