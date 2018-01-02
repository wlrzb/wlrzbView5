package gdecid.visual.tuple;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import gdecid.data.Graph;
import gdecid.data.Table;

public class TableNodeItem extends TableVisualItem {

    protected Graph m_graph;
        
    protected void init(Table table, Graph graph, int row) {
        m_table = table;
        m_graph = graph;
        m_row = row;
    }
	

}
