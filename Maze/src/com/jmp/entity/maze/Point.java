package com.jmp.entity.maze;

public class Point {

	private Integer pointX;
	private Integer pointY;
	
	public Point(Point p) {
		this.pointX = p.pointX;
		this.pointY = p.pointY;
	}
	
	public Point(Integer pointX, Integer pointY) {
		super();
		this.pointX = pointX;
		this.pointY = pointY;
	}
	
	public Point(String[] p) {
		super();
		this.pointX = Integer.parseInt(p[0]);
		this.pointY = Integer.parseInt(p[1]);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pointX == null) ? 0 : pointX.hashCode());
		result = prime * result + ((pointY == null) ? 0 : pointY.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (pointX == null) {
			if (other.pointX != null)
				return false;
		} else if (!pointX.equals(other.pointX))
			return false;
		if (pointY == null) {
			if (other.pointY != null)
				return false;
		} else if (!pointY.equals(other.pointY))
			return false;
		return true;
	}
	
	public Integer getPointX() {
		return pointX;
	}
	public void setPointX(Integer pointX) {
		this.pointX = pointX;
	}
	public Integer getPointY() {
		return pointY;
	}
	public void setPointY(Integer pointY) {
		this.pointY = pointY;
	}
	
	
}
