package gdecid.visual.tuple;

import java.awt.Graphics;

import gdecid.visual.VisualItem;

public class TableVisualItem implements VisualItem{
	String name;
	double x;
	double y;
	
	public TableVisualItem(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	
}
