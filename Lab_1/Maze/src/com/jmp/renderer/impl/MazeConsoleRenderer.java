package com.jmp.renderer.impl;

import java.util.ArrayList;
import java.util.List;

import com.jmp.entity.animal.Animal;
import com.jmp.entity.maze.Cell;
import com.jmp.entity.maze.Maze;
import com.jmp.logger.ConsoleStream;
import com.jmp.renderer.Renderer;

public class MazeConsoleRenderer implements Renderer {

	private Maze maze;
	private List<Animal> animals = new ArrayList<Animal>();
	
	public MazeConsoleRenderer (Maze maze, List<Animal> animals) {
		this.maze = maze;
		this.animals = animals;
	}

	@Override
	public void render() {
		
		for (List<Cell> row : maze.getMatrix()) {
			for (Cell cell: row) {
				if(isAnimalFound(cell, row)) {
						ConsoleStream.print('@' + " ");
				} else {
					ConsoleStream.print((cell.isAvailable() ? 1 : 0) + " ");
				}					
			}				
			ConsoleStream.printLine("");
		}			
	}
	
	private boolean isAnimalFound(Cell cell, List<Cell> row) {
		for(Animal animal : animals) {
			if(row.indexOf(cell) == animal.getPointY() && maze.getMatrix().indexOf(row) == animal.getPointX()) 
				return true;
		}
		return false;
	}

}
