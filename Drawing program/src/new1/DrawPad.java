package new1;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class DrawPad extends JFrame implements ActionListener {


	private JToolBar buttonpanel;
	private JMenuBar bar;
	private JMenu file,color,stroke,help;
	private JMenuItem newfile,openfile,savefile,exit;
	private JMenuItem colorchoice,strokeitem;
	private JLabel startbar;
	private DrawArea drawarea;
	private FileClass fileclass ;
	String[] fontName; 
	
	private String names[] = {"newfile","openfile","savefile","Pencil","Line"
			,"Rectangle","FillRectangle","Oval","FillOval","Circle","FillCircle"
			,"RoundRectangle","FillRoundRectangle","Eraser","Color"
			,"Stroke","Text"};
	
	 JButton button[];
	private JCheckBox bold,italic;
	private JComboBox stytles ;
	public DrawPad(String string) {
		
		super(string);
	   
	    file = new JMenu("file");
	    color = new JMenu("color");
	    stroke = new JMenu("stroke");
	    bar = new JMenuBar();
	    
	    
	    bar.add(file);
	    bar.add(color);
	    bar.add(stroke);

	    
	   
	    setJMenuBar(bar);
	    

	   
	    

	   
	    newfile = new JMenuItem("NEW");
	    openfile = new JMenuItem("LOAD" );
	    savefile = new JMenuItem("SAVE");
	    exit = new JMenuItem("EXIT");
	    
	    
	    file.add(newfile);
	    file.add(openfile);
	    file.add(savefile);
	    file.add(exit);
	    
	   

	   
	    
	    newfile.addActionListener(this);
	    openfile.addActionListener(this);
	    savefile.addActionListener(this);
	    exit.addActionListener(this);
	    
	    
	    colorchoice = new JMenuItem("pallette");
	    colorchoice.addActionListener(this);
	    color.add(colorchoice);

	  	    
	   
	    strokeitem = new JMenuItem("set stroke");
	    stroke.add(strokeitem);
	    strokeitem.addActionListener(this);
	    
	   
	    buttonpanel = new JToolBar( JToolBar.HORIZONTAL);
	   
	    button = new JButton[names.length];
	    for(int i = 3 ;i<names.length;i++)
	    {
	    	button[i] = new JButton(names[i]);
	    	buttonpanel.add(button[i]);
	    	if(i<3)button[i].addActionListener(this);
	        else if(i<=16) button[i].addActionListener(this);
	    }
	   CheckBoxHandler CHandler = new CheckBoxHandler();
	   bold = new  JCheckBox("Bold"); 
	   bold.setFont(new Font(Font.DIALOG,Font.BOLD,20));
	   bold.addItemListener(CHandler);
	   italic = new  JCheckBox("Italic");
	   italic.addItemListener(CHandler);
	   italic.setFont(new Font(Font.DIALOG,Font.ITALIC,20));
	   GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
       fontName = ge.getAvailableFontFamilyNames();
	   stytles = new JComboBox(fontName);
	   stytles.addItemListener(CHandler);
	   stytles.setMaximumSize(new Dimension(400,50));
	   stytles.setMinimumSize(new  Dimension(250,40));
	   stytles.setFont(new Font(Font.DIALOG,Font.BOLD,20));
	  

	   buttonpanel.add(bold);
	   buttonpanel.add(italic);
	   buttonpanel.add(stytles);
	   


	   
	    

	    drawarea = new DrawArea(this);
	    fileclass = new FileClass(this,drawarea);
	   
	    
	    Container con = getContentPane();
	    con.add(buttonpanel, BorderLayout.NORTH);
	    con.add(drawarea,BorderLayout.CENTER);
	    Toolkit tool = getToolkit();
	    Dimension dim = tool.getScreenSize();
	    setBounds(40,40,dim.width-70,dim.height-100);
	    setVisible(true);
	    validate();
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {

		for(int i = 3; i<=13;i++)
		{
			if(e.getSource() ==button[i])
			{
				drawarea.setCurrentChoice(i);
				drawarea.createNewitem();
				drawarea.repaint();
		    }
			
		}
	    if(e.getSource() == newfile||e.getSource() == button[0])
		{fileclass.newFile();}
		else if(e.getSource() == openfile||e.getSource() == button[1])
		{fileclass.openFile();}
		else if(e.getSource() == savefile||e.getSource() == button[2])
		{fileclass.saveFile();}
		else if(e.getSource() == exit)
		{System.exit(0);}
		else if(e.getSource() == colorchoice||e.getSource() == button[14])
		{
			drawarea.chooseColor();
	    }
		else if(e.getSource() == button[15]||e.getSource()==strokeitem)
		{
			drawarea.setStroke();
		}
		else if(e.getSource() == button[16])
		{   JOptionPane.showMessageDialog(null, "Click on text location",""
				,JOptionPane.INFORMATION_MESSAGE); 
			drawarea.setCurrentChoice(14);
			drawarea.createNewitem();
			drawarea.repaint();
		}
		
		
		
	}
	
	public  class CheckBoxHandler implements ItemListener
	{

		
		public void itemStateChanged(ItemEvent ie) {
			if(ie.getSource() == bold)
			{
				if(ie.getStateChange() == ItemEvent.SELECTED)
				drawarea.setFont(1, Font.BOLD);
				else 
					drawarea.setFont(1, Font.PLAIN);
			}
			else if(ie.getSource() == italic)
			{
				if(ie.getStateChange() == ItemEvent.SELECTED)
					drawarea.setFont(2, Font.ITALIC);
				else drawarea.setFont(2, Font.PLAIN);
				
			}
			else if(ie.getSource() == stytles)
			{   
				drawarea.stytle = fontName[stytles.getSelectedIndex()];
			}
		}
		
	}
}


