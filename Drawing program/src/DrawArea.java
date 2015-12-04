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
}

