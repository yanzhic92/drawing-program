import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class DrawingWindow extends JFrame {
	private JMenuBar bar;
	private JMenu file;
	private JMenuItem newfile,openfile,savefile,exit;//items in "file"
	private DrawArea drawarea;
	
	private JToolBar buttonbar;
	private JButton button[];
	private String buttonnames[] = {
			"pen","line","rect","circle","rubber"
	};
	
	public DrawingWindow(int w,int h){
		//set menu
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
		
		//set buttons
		buttonbar = new JToolBar();
		buttonbar.setLayout(new GridLayout(1,5));
		button = new JButton[buttonnames.length];
		   for(int i = 0; i < buttonnames.length; i++){
			   button[i] = new JButton(buttonnames[i]);
			   buttonbar.add(button[i]);
		   }
		
		setSize(w, h);
		
		DrawArea drawarea = new DrawArea(null);
	    Container c = getContentPane();
	    c.add(drawarea,BorderLayout.CENTER);
	    c.add(buttonbar,BorderLayout.NORTH);

	    
	    setVisible(true);
	
	}	
	
}