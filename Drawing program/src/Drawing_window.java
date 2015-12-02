import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Drawing_window extends JFrame {
	private JMenuBar bar;
	private JMenu file;
	private JMenuItem newfile,openfile,savefile,exit;//items in "file"
	private JToolBar buttons;
	
	public Drawing_window(int h, int w){
		lol
		file = new JMenu("File");
		bar = new JMenuBar();
		bar.add(file);
		
		setJMenuBar(bar);
		
		file.add(newfile);
		file.add(openfile);		
		file.add(savefile);		
		file.add(exit);
		
		
	    setSize(w, h);
	    Container c = getContentPane();
	    c.add(buttons, BorderLayout.NORTH);
	    
	    setVisible(true);
	
	}	
	
}