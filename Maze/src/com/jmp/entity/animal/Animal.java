package com.jmp.entity.animal;

import com.jmp.entity.maze.Point;

public abstract class Animal {

	private Point point;
	
	private Integer step;
	
	public Animal(Point point) {
		super();
		this.point = point;
	}

	public Point getPoint() {
		return point;
	}

	public Integer getPointX() {
		return point.getPointX();
	}

	public void setPointX(Integer pointX) {
		this.point.setPointX(pointX);
	}

	public Integer getPointY() {
		return point.getPointY();
	}

	public void setPointY(Integer pointY) {
		this.point.setPointY(pointY);
	}

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public abstract void moveUp(); 
	
	public abstract void moveDown();

	public abstract void moveLeft(); 

	public abstract void moveRight();
}
