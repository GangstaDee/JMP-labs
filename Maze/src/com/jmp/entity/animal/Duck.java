package com.jmp.entity.animal;

import com.jmp.entity.maze.Point;

public class Duck extends Animal {

	public Duck(Point point) {
		super(point);
		super.setStep(1);
	}

	public void moveUp() {
		super.setPointX(super.getPointX() - super.getStep());
	}
	
	public void moveDown() {
		super.setPointX(super.getPointX() + super.getStep());
	}
	
	public void moveLeft() {
		super.setPointY(super.getPointY() - super.getStep());
	}
	
	public void moveRight() {
		super.setPointY(super.getPointY() + super.getStep());
	}

}
