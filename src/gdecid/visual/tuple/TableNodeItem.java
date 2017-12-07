package gdecid.visual.tuple;

import java.awt.Font;
import java.awt.Graphics;

public class TableNodeItem extends TableVisualItem{
	String text;
	double x;
	double y;
	double size = 1.0; //定义图片的缩放大小。
	Font font = new Font("黑体", Font.PLAIN, 15);;
	
	public TableNodeItem(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
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

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

}
