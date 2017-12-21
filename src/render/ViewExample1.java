package render;

import java.awt.Graphics;

import javax.swing.JFrame;

import gdecid.Visualization;
import gdecid.action.layout.CircleLayout;
import gdecid.action.layout.Layout;
import gdecid.data.Graph;
import gdecid.data.io.GraphMLReader;


public class ViewExample1 {
	public static void main(String[] args) {
		
		Graph graph = new GraphMLReader().init();
		
		Visualization vis = new Visualization();
		vis.add("graph", graph);
				
	//	vis.putAction("layout", new CircleLayout("graph"));
		
//        Display d = new Display();
       // d.setSize(800, 600); // set display size
		
        JFrame frame = new JFrame("GDECID View Example1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.add(d);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); // show the window
                
   //     new CircleLayout(Graph.NODES).run(vis);
        new CircleLayout("graph").run(vis);;
       // d.add(ts);
        //d.repaint();
	}
	
}
