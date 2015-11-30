package com.jmp.entity.animal;

import java.util.LinkedList;
import java.util.List;

import com.jmp.entity.maze.Point;

public class ProgrammedDuck extends Duck{

	private List<String> commands = new LinkedList<String>();
	
	public ProgrammedDuck(Point point, String name) {
		super(point, name);
	}
	
	public void addCommand(String command) {
		this.commands.add(command);
	}
	
	public void addCommands(List<String> commands) {
		this.commands.addAll(commands);
	}
	
	@Override
	public String getNextCommand() {
		if(this.commands.size() > 0) {
			return this.commands.get(0);
		}
		return "0";
	}

	@Override
	public void updateNextCommand() {
		if(this.commands.size() > 0) {
			this.commands.remove(0);
		}			
	}
	
}
