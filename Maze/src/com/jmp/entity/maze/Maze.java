package com.jmp.entity.maze;

import java.util.ArrayList;
import java.util.List;

public class Maze {

	private Point start;
	private Point finish;
	
	private List<List<Cell>> matrix = new ArrayList<List<Cell>>();

	public Maze (List<List<Cell>> matrix, Point start, Point finish) {
		this.matrix = matrix;
		this.start = start;
		this.finish = finish;
	}	

	public List<List<Cell>> getMatrix() {
		//defensive copy instead
		return matrix;
	}
	
	public Point getFinish() {
		return finish;
	}

	public void setFinish(Point finish) {
		this.finish = finish;
	}

	public void setMatrix(List<List<Cell>> matrix) {
		this.matrix = matrix;
	}

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public Cell getCell(Integer x, Integer y) {
		
		if(x >= 0 && y >= 0) {
			List<Cell> row = getMatrix().get(x);
			if(row != null) {
				return row.get(y);			
			}
		}
		return null;
	}	
}
