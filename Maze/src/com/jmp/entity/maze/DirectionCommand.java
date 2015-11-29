package com.jmp.entity.maze;

public enum DirectionCommand {
	UP(8), DOWN(5), LEFT(4), RIGHT(6);
	
	final int key;
	
	DirectionCommand(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return key;
	}
	
}
