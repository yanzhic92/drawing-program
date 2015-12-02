import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Drawing_window extends JFrame {
	private JMenuBar bar;
	private JMenu file;
	private JMenuItem newfile,openfile,savefile,exit;//items in "file"

	
	public Drawing_window(int w,int h){
		file = new JMenu("File");
		bar = new JMenuBar();
		bar.add(file);
		
		setJMenuBar(bar);
		
        
        newfile = new JMenuItem("New");  
        openfile = new JMenuItem("Open" );  
        savefile = new JMenuItem("Save");  
        exit = new JMenuItem("Exit"); 
		
		file.add(newfile);
		file.add(openfile);		
		file.add(savefile);		
		file.add(exit);
		
		setSize(w, h);
		
		DrawArea DrawArea = new DrawArea();
	    Container c = getContentPane();
	    c.add(DrawArea,BorderLayout.CENTER);  

	    
	    setVisible(true);
	
	}	
	
}