package new1;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class DrawArea extends JPanel{
	DrawPad drawpad =null;
    Drawing[] itemList =new Drawing[5000];
    
    private int currentChoice = 3;
    int index = 0;
    private Color color = Color.black;
    int R,G,B;
    int f1,f2;
    String stytle ;
    float stroke = 1.0f;
	DrawArea(DrawPad dp) {
		drawpad = dp;
		
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		

		setBackground(Color.white);
		addMouseListener(new MouseA());
		addMouseMotionListener(new MouseB());
		 createNewitem();
		
	}
    
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		int  j = 0;
		while(j<=index)
		{
			draw(g2d,itemList[j]);
			j++;
	    }
		
	}
	void draw(Graphics2D g2d , Drawing i)
	{
		i.draw(g2d);
	}
	
	
	void createNewitem(){
		if(currentChoice == 14)
			setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		else  	setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
			switch(currentChoice){
			case 3: itemList[index] = new Pencil();break;
			case 4: itemList[index] = new Line();break;
			case 5: itemList[index] = new Rect();break;
			case 6: itemList[index] = new fillRect();break;
			case 7: itemList[index] = new Oval();break;
			case 8: itemList[index] = new fillOval();break;
			case 9: itemList[index] = new Circle();break;
			case 10: itemList[index] = new fillCircle();break;
			case 11: itemList[index] = new RoundRect();break;
			case 12: itemList[index] = new fillRoundRect();break;
			case 13: itemList[index] = new Eraser();break;
			case 14: itemList[index] = new Word();break;
		}
	  itemList[index].type = currentChoice;
	  itemList[index].R = R;
	  itemList[index].G = G;
	  itemList[index].B = B;
	  itemList[index].stroke = stroke ;
	 
	}
   
    public void setIndex(int x){
    	index = x;
    }
    public int getIndex(){
    	return index ;
    }
    public void setColor(Color color)
    {
    	this.color = color; 
    }
    public void setStroke(float f)
    {
    	stroke = f;
    }
	public void chooseColor()
	{
		color = JColorChooser.showDialog(drawpad, "choose color", color);
		try {
			R = color.getRed();
			G = color.getGreen();
			B = color.getBlue();
		} catch (Exception e) {
			R = 0;
			G = 0;
			B = 0;
		}
		itemList[index].R = R;
		itemList[index].G = G;
		itemList[index].B = B;
	}
	public void setStroke()
	{
		String input ;
		input = JOptionPane.showInputDialog("input stroke( >0 )");
		try {
			stroke = Float.parseFloat(input);
			
		} catch (Exception e) {
			stroke = 1.0f;
			
		}itemList[index].stroke = stroke;
		
	}
	public void setCurrentChoice(int i )
	{
		currentChoice = i;
	}
	
	public void setFont(int  i,int font)
	{
		if(i == 1)
		{
			f1 = font; 
		}
		else 
			f2 = font;
	}


class MouseA extends MouseAdapter
{

	

	
	public void mouseEntered(MouseEvent me) {
	}

	
	public void mouseExited(MouseEvent me) {
	}

	
	public void mousePressed(MouseEvent me) {
		
		itemList[index].x1 = itemList[index].x2 = me.getX();
		itemList[index].y1 = itemList[index].y2 = me.getY();
		
		
		if(currentChoice == 3||currentChoice ==13){
			itemList[index].x1 = itemList[index].x2 = me.getX();
			itemList[index].y1 = itemList[index].y2 = me.getY();
			index++;
			createNewitem();
		}
		
		if(currentChoice == 14){
			itemList[index].x1 = me.getX();
			itemList[index].y1 = me.getY();
			String input ;
			input = JOptionPane.showInputDialog("Text:");
			itemList[index].s1 = input;
			itemList[index].x2 = f1;
			itemList[index].y2 = f2;
			itemList[index].s2 = stytle;
			
			index++;
			currentChoice = 14;
			createNewitem();
			repaint();
		}
			
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		if(currentChoice == 3||currentChoice ==13){
			itemList[index].x1 = me.getX();
			itemList[index].y1 = me.getY();
		}
		itemList[index].x2 = me.getX();
		itemList[index].y2 = me.getY();
		repaint();
		index++;
		createNewitem();
	}

}


	class MouseB extends MouseMotionAdapter {
      public void mouseDragged(MouseEvent me)
      {
    	  if(currentChoice == 3||currentChoice ==13){
    		  itemList[index-1].x1 = itemList[index].x2 = itemList[index].x1 =me.getX();
    		  itemList[index-1].y1 = itemList[index].y2 = itemList[index].y1 = me.getY();
    		  index++;
    		  createNewitem();
    	  }
    	  else 
    	  {
    		  itemList[index].x2 = me.getX();
    		  itemList[index].y2 = me.getY();
    	  }
    	  repaint();
      }
      public void mouseMoved(MouseEvent me)
      {
      }
	}

}
