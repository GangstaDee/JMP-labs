package com.jmp.listener.impl;

import java.util.List;

import com.jmp.entity.animal.Animal;
import com.jmp.entity.maze.Cell;
import com.jmp.entity.maze.Maze;
import com.jmp.listener.Listener;
import com.jmp.logger.ConsoleStream;

public class MazeDisplayer implements Listener {

	private Maze maze;
	private Animal animal;
	
	public void setMaze(Maze maze) {
		this.maze = maze;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	@Override
	public void performAction(String input) {
		
		for (List<Cell> row : maze.getMatrix()) {
			for (Cell cell: row) {
				if(row.indexOf(cell) == animal.getPointY() && maze.getMatrix().indexOf(row) == animal.getPointX()) {
					ConsoleStream.print('@' + " ");
					continue;
				}				
				ConsoleStream.print((cell.isAvailable() ? 1 : 0) + " ");
			}
			ConsoleStream.printLine("");
		}	
		
	}

}
