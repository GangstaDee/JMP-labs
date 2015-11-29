package com.jmp.listener.impl;

import com.jmp.entity.animal.Animal;
import com.jmp.entity.maze.Cell;
import com.jmp.entity.maze.DirectionCommand;
import com.jmp.entity.maze.Maze;
import com.jmp.listener.Listener;
import com.jmp.logger.ConsoleStream;

public class MazeNavigator implements Listener {

	private Maze maze;
	private Animal animal;
	
	@Override
	public void performAction(String input) {
				
		Integer eventKey = null;
		try {
			eventKey = Integer.parseInt(input);
		} catch (NumberFormatException ex) {
			ConsoleStream.doError("Unknown command!");
			return;
		}
		
		for (DirectionCommand event: DirectionCommand.values()) {
			if(event.getKey() == eventKey) {
				
				ConsoleStream.doLog("Moving in maze... ");
				
				switch(event) {
				case UP:
					if(checkCell(animal.getPointX() - animal.getStep(), animal.getPointY())) {				
						animal.moveUp();					
					}	
					break;
				case DOWN:
					if(checkCell(animal.getPointX() + animal.getStep(), animal.getPointY())) {					
						animal.moveDown();							
					}
					break;					
				case LEFT:
					if(checkCell(animal.getPointX(), animal.getPointY() - animal.getStep())) {					
						animal.moveLeft();							
					}
					break;				
				case RIGHT:
					if(checkCell(animal.getPointX(), animal.getPointY() + animal.getStep())) {			
						animal.moveRight();						
					}
					break;
				default:
					break;
					
				}				
			}
		}
		
		if(animal.getPoint().equals(maze.getFinish())) {
			ConsoleStream.doLog("Maze is passed");
		}
	}

	public void setMaze(Maze maze) {
		this.maze = maze;
	}
	
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	private boolean checkCell(Integer pointX, Integer pointY) {
		Cell cell = maze.getCell(pointX, pointY);
		if(cell != null && cell.isAvailable()) {
			cell.setPassed(true);
			return true;
		}
		return false;
	}

}
