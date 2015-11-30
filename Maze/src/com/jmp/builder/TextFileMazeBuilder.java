package com.jmp.builder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jmp.entity.maze.Cell;
import com.jmp.entity.maze.Maze;
import com.jmp.entity.maze.Point;
import com.jmp.logger.ConsoleStream;

public class TextFileMazeBuilder implements MazeBuilder {

	public TextFileMazeBuilder(String filename) {
		this.filename = filename;
	}
	
	private String filename;
	
	@Override
	public Maze build() {
						
		File file = new File(filename);
					
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
}
