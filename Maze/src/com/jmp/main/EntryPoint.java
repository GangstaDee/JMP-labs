package com.jmp.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jmp.controller.ConsoleEventController;
import com.jmp.entity.animal.Animal;
import com.jmp.entity.animal.Duck;
import com.jmp.entity.animal.ProgrammedDuck;
import com.jmp.entity.maze.Maze;
import com.jmp.entity.maze.Point;
import com.jmp.factory.MazesFactory;
import com.jmp.logger.ConsoleStream;
import com.jmp.navigator.impl.MazeNavigator;
import com.jmp.renderer.impl.MazeConsoleRenderer;

public class EntryPoint {
	
	public static void main(String[] args) {
		
		ConsoleStream.printLine("Welcome to Maze :) 8 - Up, 4 - Left, 5 - Down, 6 - Right, 'exit' - to quit");	

		String absoluteFilePath = "c:\\Users\\Dasha.Selyavko\\workspace_eclipse\\Maze\\resources\\maze.txt";
		
		Maze maze = MazesFactory.buildFromFile(absoluteFilePath);
		
		List<Animal> ducks = new ArrayList<Animal>();
		Duck duck = new Duck(maze.getStart(), "Darya");
		ducks.add(duck);
		
		ProgrammedDuck programmedDuck = new ProgrammedDuck(new Point(maze.getStart()), "Smart Darya");
		programmedDuck.addCommands(Arrays.asList("5","6","6","5","6"));
		ducks.add(programmedDuck);
					
		ConsoleEventController controller = new ConsoleEventController();	
		controller.addAnimals(ducks);
		
		MazeNavigator duckNavigator = new MazeNavigator();		
		duckNavigator.setMaze(maze);	
		controller.setNavigator(duckNavigator);
				
		MazeConsoleRenderer renderer = new MazeConsoleRenderer(maze, ducks);
		controller.setRenderer(renderer);
		
		controller.run();	
		
	}
	
}
