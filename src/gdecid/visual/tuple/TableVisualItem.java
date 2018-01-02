package gdecid.visual.tuple;

import gdecid.data.Graph;
import gdecid.data.Table;
import gdecid.data.tuple.TableTuple;
import gdecid.visual.VisualTable;
import java.awt.Font;
import java.awt.Graphics;

import gdecid.visual.VisualItem;

public class TableVisualItem extends TableTuple implements VisualItem{

    
    protected void init(Table table, Graph graph, int row) {
        m_table = table;
        m_row = row;
    }
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setX(double x) {
		((VisualTable)m_table).setX(m_row, x);
	}

	@Override
	public void setY(double y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setStartX(double x) {
		((VisualTable)m_table).setStartX(m_row, x);
	}
	@Override
	public void setEndX(double x) {
		((VisualTable)m_table).setEndX(m_row, x);
	}
	@Override
	public void setStartY(double y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setEndY(double y) {
		// TODO Auto-generated method stub
		
	}
	
	
}
