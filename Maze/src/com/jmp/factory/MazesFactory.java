package com.jmp.factory;

import com.jmp.builder.TextFileMazeBuilder;
import com.jmp.entity.maze.Maze;

public class MazesFactory {

	public static Maze buildFromFile(String fileName) {
		
		return new TextFileMazeBuilder(fileName).build();
	}

}
