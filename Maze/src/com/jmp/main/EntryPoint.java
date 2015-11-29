package com.jmp.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jmp.controller.ConsoleEventController;
import com.jmp.entity.animal.Animal;
import com.jmp.entity.animal.Duck;
import com.jmp.entity.maze.Cell;
import com.jmp.entity.maze.Maze;
import com.jmp.entity.maze.Point;
import com.jmp.listener.Listener;
import com.jmp.listener.impl.MazeDisplayer;
import com.jmp.listener.impl.MazeNavigator;
import com.jmp.logger.ConsoleStream;
import com.jmp.reader.Reader;

public class EntryPoint {
	
	public static void main(String[] args) {
		
		ConsoleStream.printLine("Welcome to Maze :) 8 - Up, 4 - Left, 5 - Down, 6 - Right, 'exit' - to quit");	

		Reader reader = new Reader() {	
			
			@Override
			public File retrieveResource(String fileName) {
							
//				ClassLoader loader = getClass().getClassLoader();
//				URL myURL = loader.getResource(fileName);
//				String path = myURL.getPath();
//				System.out.println("File path: " + path);
//				File file = new File(loader.getResource(fileName).getFile());
				
				String absoluteFilePath = "####-PATH-####-maze.txt";
				File file = new File(absoluteFilePath);
			
				return file;
			}
			
			@Override
			public Object read(File file) {
				
				List<List<Cell>> matrix = new ArrayList<List<Cell>>();
				Point start = null;
				Point finish = null;
				try (Scanner input = new Scanner(file)) {
					start = new Point(input.nextLine().split(" "));
					finish = new Point(input.nextLine().split(" "));
					
					while(input.hasNextLine()) {
								
					    try (Scanner rowReader = new Scanner(input.nextLine())) {
					    	List<Cell> row = new ArrayList<Cell>();
					    
					    	while(rowReader.hasNextInt()) {
					    		Cell cell = new Cell();
					    		cell.setAvailable(rowReader.nextInt() > 0 ? true : false);
					    		row.add(cell);
					    	}
					    	matrix.add(row);
					    }
					}
				} catch (FileNotFoundException e) {
					ConsoleStream.doError("No file was found");
				}
				
				return new Maze(matrix, start, finish);
			}			
		};
		
		Maze maze = (Maze) reader.read(reader.retrieveResource("maze.txt"));		
		Animal animal = new Duck(maze.getStart());
		
		ConsoleEventController controller = new ConsoleEventController();	
		
		Listener mazeNavigator = new MazeNavigator();		
		((MazeNavigator)mazeNavigator).setMaze(maze);
		((MazeNavigator)mazeNavigator).setAnimal(animal);
		controller.addListener(mazeNavigator);
		
		Listener mazeDisplayer = new MazeDisplayer();
		((MazeDisplayer)mazeDisplayer).setMaze(maze);
		((MazeDisplayer)mazeDisplayer).setAnimal(animal);
		controller.addListener(mazeDisplayer);
		
		controller.run();	
		
	}
	
}
