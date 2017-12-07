package render;

import java.awt.Graphics;

import javax.swing.JFrame;

import gdecid.action.layout.CircleLayout;
import gdecid.action.layout.Layout;


public class ViewExample1 {
	public static void main(String[] args) {
        Display d = new Display();
       // d.setSize(800, 600); // set display size
		
        JFrame frame = new JFrame("GDECID View Example1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(d);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); // show the window
        
        // 载入node和edge的原始数据
        TupleSet ts = new TupleSet(); 
        ts.init();
        
        new CircleLayout().run(ts);;
        d.add(ts);
        //d.repaint();
	}
	
}
