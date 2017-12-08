package gdecid.render;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Map;

import javax.swing.JFrame;

import gdecid.visual.tuple.TableEdgeItem;
import gdecid.visual.tuple.TableNodeItem;
import gdecid.visual.VisualItem;

import render.Constants;
import render.GraphicsLib;


public class EdgeRenderer {
	
    protected int     m_xAlign1   = Constants.CENTER;
    protected int     m_yAlign1   = Constants.CENTER;
    protected int     m_xAlign2   = Constants.CENTER;
    protected int     m_yAlign2   = Constants.CENTER;
    protected float   m_curWidth  = 10;
    protected static final double HALF_PI = Math.PI / 2;
    
    int width;
    int height;
    
    Point2D m_tmpPoints[]  = new Point2D[2];
    Point2D m_isctPoints[] = new Point2D[2];
	
	public Line2D m_line = new Line2D.Float();
	public Rectangle2D item1 =new Rectangle2D.Float(250, 100, 20, 20); 
	public Rectangle2D item2 =new Rectangle2D.Float(500, 300, 20, 20); 
	
    protected int     m_arrowWidth  = 8;
    protected int     m_arrowHeight = 12;
	public Shape   m_curArrow;
    public Polygon m_arrowHead   = updateArrowHead(m_arrowWidth, m_arrowHeight);
    protected AffineTransform m_arrowTrans = new AffineTransform();
    
    public double s2x;
    public double s2y;
		
	
	public void paint(Graphics g) {
//		Graphics2D g2d = (Graphics2D)g; 
//		Shape shape = getRawShape();
//		//shape = m_rect;
//		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_DEFAULT);
//		Stroke s = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
//		g2d.setStroke(s);
//		g2d.draw(item1);
//		g2d.draw(item2);
//		g2d.draw(shape);
//		g2d.fill(m_curArrow);
		g.drawLine(100, 100, 200, 90);
		//getAngle(100, 100, 150, 50);
		//System.out.println(s2x);
		//g.drawLine(100, 100, (int)s2x, (int)s2y);
	}
	
	protected Shape getRawShape(TableEdgeItem tableEdgeItem, Map<String, Object> Nodes) {
		Shape shape = null;
	
        TableEdgeItem edge = (TableEdgeItem)tableEdgeItem;
        TableNodeItem item1 = (TableNodeItem) edge.getSourceItem(Nodes);
        TableNodeItem item2 = (TableNodeItem) edge.getTargetItem(Nodes);

        System.out.println(item1.getBounds().getWidth());
		
		m_tmpPoints[0] = getAlignedPoint(item1.getBounds(), m_xAlign1, m_yAlign1);
		m_tmpPoints[1] = getAlignedPoint(item2.getBounds(), m_xAlign2, m_yAlign2);
		
		
        Point2D start = null, end = null;
        start = m_tmpPoints[0];
        end   = m_tmpPoints[1];
		
        TableNodeItem dest = item2;
        int i = GraphicsLib.intersectLineRectangle(start, end, dest.getBounds(), m_isctPoints);
        if ( i > 0 ) end = m_isctPoints[0];
        
        // create the arrow head shape
        AffineTransform at = getArrowTrans(start, end, m_curWidth);
        m_curArrow = at.createTransformedShape(m_arrowHead);
        
        // update the endpoints for the edge shape
        // need to bias this by arrow head size
        Point2D lineEnd = m_tmpPoints[1]; 
        lineEnd.setLocation(0, -m_arrowHeight);
        at.transform(lineEnd, lineEnd);
        
        
        
        double n1x = m_tmpPoints[0].getX();
        double n1y = m_tmpPoints[0].getY();
        double n2x = m_tmpPoints[1].getX();
        double n2y = m_tmpPoints[1].getY();
        
        m_line.setLine(n1x, n1y, n2x, n2y);
        shape = m_line;
		
        
		return shape;
	}
	
    public Point getAlignedPoint(Rectangle2D r, int xAlign, int yAlign) {
    	Point p = new Point();
        double x = r.getX(), y = r.getY(), w = r.getWidth(), h = r.getHeight();
        if ( xAlign == Constants.CENTER ) {
            x = x+(w/2);
        } else if ( xAlign == Constants.RIGHT ) {
            x = x+w;
        }
        if ( yAlign == Constants.CENTER ) {
            y = y+(h/2);
        } else if ( yAlign == Constants.BOTTOM ) {
            y = y+h;
        }
        p.setLocation(x,y);
        return p;
    }
    
    protected Polygon updateArrowHead(int w, int h) {
        if ( m_arrowHead == null ) {
            m_arrowHead = new Polygon();
        } else {
            m_arrowHead.reset();
        }
        m_arrowHead.addPoint(0, 0);
        m_arrowHead.addPoint(-w/2, -h);
        m_arrowHead.addPoint( w/2, -h);
        m_arrowHead.addPoint(0, 0);
        return m_arrowHead;
    }
    
    protected AffineTransform getArrowTrans(Point2D p1, Point2D p2, double width) {
    	m_arrowTrans.setToTranslation(p2.getX(), p2.getY());
    	m_arrowTrans.rotate(-HALF_PI + 
    			Math.atan2(p2.getY()-p1.getY(), p2.getX()-p1.getX()));
    	if ( width > 1 ) {
    		double scalar = width/4;
    		m_arrowTrans.scale(scalar, scalar);
    	}
    	return m_arrowTrans;
    }    
    
    public void getS2TRelativeAngle(double sx, double sy, double tx, double ty, int width, int height) {
    	double s2tlineAngle = Math.atan2(sy-ty, tx-sx);
    	System.out.println(s2tlineAngle);
    	double test2 = Math.sin(s2tlineAngle+Math.PI*15/180);
    	System.out.println(test2);
    	double s2t2lineAngle = s2tlineAngle + Math.PI*15/180;
    	
    	double s2tmpy=20*Math.sin(s2t2lineAngle);
    	double s2tmpx=20*Math.cos(s2t2lineAngle);
    	s2x = sx + s2tmpx;
    	s2y = sy - s2tmpy;
    }

	public void Render(Graphics2D g2d, TableEdgeItem tableEdgeItem, Map<String, Object> Nodes) {
		Shape shape = getRawShape(tableEdgeItem, Nodes);		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.draw(shape);
		g2d.fill(m_curArrow);
	}
	

}
