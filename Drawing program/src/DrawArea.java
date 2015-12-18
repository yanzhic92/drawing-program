import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawArea extends JPanel{
	private int currentChoice = 3;
	DrawingWindow DrawingWindow =null; 
	Drawing[] DrawList =new Drawing[10000];
	int index = 0;
	int R,G,B;
	float stroke = (float) 1.0;
	
	DrawArea(DrawingWindow d) {  
		DrawingWindow = d;  
	    setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));  
	    setBackground(Color.white);
	    addMouseListener(new MouseA());//add mouselistener 
        addMouseMotionListener(new MouseB());  
	    createNewitem();  
	    }  
	
	public void paintComponent(Graphics g){  
        super.paintComponent(g);  
        Graphics2D g2d = (Graphics2D)g; 
        int  j = 0;  
        while(j<=index)  
        {  
            draw(g2d,DrawList[j]);  
            j++;  
        }  
          
    }  
    void draw(Graphics2D g2d , Drawing i)  
    {  
        i.draw(g2d);
    }  
    
    

public void setStroke(float f){
	stroke = f;
}

void createNewitem(){
		switch(currentChoice){
		case 1: DrawList[index] = new Pen();break;
		case 2: DrawList[index] = new Line();break;
		case 3: DrawList[index] = new Rect();break;
		case 4: DrawList[index] = new Circle();break;
		case 5: DrawList[index] = new Rubber();break;
		}
  DrawList[index].R = R;
  DrawList[index].G = G;
  DrawList[index].B = B;
  DrawList[index].stroke = stroke ;
 
}

public void setIndex(int x){
    index = x;  
}  
public int getIndex(){ 
    return index ;  
}  

public void setCurrentChoice(int i )
{  
    currentChoice = i;  
}  

class MouseA extends MouseAdapter  
{  
      
    @Override  
    public void mouseEntered(MouseEvent me) {  
        // TODO 
        DrawingWindow.setStratBar("mouseEntered at:["+me.getX()+" ,"+me.getY()+"]");  
    }  
    @Override  
    public void mouseExited(MouseEvent me) {  
        // TODO 
    	DrawingWindow.setStratBar("mouseExited at:["+me.getX()+" ,"+me.getY()+"]");  
    }  
    @Override  
    public void mousePressed(MouseEvent me) {  
        // TODO   
    	DrawingWindow.setStratBar("mousePressed at:["+me.getX()+" ,"+me.getY()+"]");
          
    	DrawList[index].x1 = DrawList[index].x2 = me.getX();  
    	DrawList[index].y1 = DrawList[index].y2 = me.getY();  
          

        if(currentChoice == 3||currentChoice ==13){  
        	DrawList[index].x1 = DrawList[index].x2 = me.getX();  
        	DrawList[index].y1 = DrawList[index].y2 = me.getY();  
            index++;  
            createNewitem();
        }  
              
    }  
    @Override  
    public void mouseReleased(MouseEvent me) {  
        // TODO
    	DrawingWindow.setStratBar("mouseReleased at:["+me.getX()+" ,"+me.getY()+"]");  
        if(currentChoice == 1||currentChoice ==5){  
        	DrawList[index].x1 = me.getX();  
        	DrawList[index].y1 = me.getY();  
        }  
        DrawList[index].x2 = me.getX();  
        DrawList[index].y2 = me.getY();  
        repaint();  
        index++;  
        createNewitem();
    }  
}  
class MouseB extends MouseMotionAdapter {  
    public void mouseDragged(MouseEvent me)  
    {  
    	DrawingWindow.setStratBar("mouseDragged at：["+me.getX()+" ,"+me.getY()+"]");  
        if(currentChoice == 1||currentChoice ==5){  
        	DrawList[index-1].x1 = DrawList[index].x2 = DrawList[index].x1 =me.getX();  
        	DrawList[index-1].y1 = DrawList[index].y2 = DrawList[index].y1 = me.getY();  
            index++;  
            createNewitem();
        }  
        else   
        {  
        	DrawList[index].x2 = me.getX();  
        	DrawList[index].y2 = me.getY();  
        }  
        repaint();  
    }  
    public void mouseMoved(MouseEvent me)
    {  
    	DrawingWindow.setStratBar("mouseMoved at：["+me.getX()+" ,"+me.getY()+"]");  
    }  
  }  
}  


