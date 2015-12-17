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
        Graphics2D g2d = (Graphics2D)g;//定义随笔画  
        int  j = 0;  
        while(j<=index)  
        {  
            draw(g2d,DrawList[j]);  
            j++;  
        }  
          
    }  
    void draw(Graphics2D g2d , Drawing i)  
    {  
        i.draw(g2d);//将画笔传到个各类的子类中，用来完成各自的绘图  
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

class MouseA extends MouseAdapter  
{  
      
    @Override  
    public void mouseEntered(MouseEvent me) {  
        // TODO 鼠标进入  
        DrawingWindow.setStratBar("鼠标进入在：["+me.getX()+" ,"+me.getY()+"]");  
    }  
    @Override  
    public void mouseExited(MouseEvent me) {  
        // TODO 鼠标退出  
    	DrawingWindow.setStratBar("鼠标退出在：["+me.getX()+" ,"+me.getY()+"]");  
    }  
    @Override  
    public void mousePressed(MouseEvent me) {  
        // TODO 鼠标按下  
    	DrawingWindow.setStratBar("鼠标按下在：["+me.getX()+" ,"+me.getY()+"]");//设置状态栏提示  
          
    	DrawList[index].x1 = DrawList[index].x2 = me.getX();  
    	DrawList[index].y1 = DrawList[index].y2 = me.getY();  
          
        //如果当前选择为随笔画或橡皮擦 ，则进行下面的操作  
        if(currentChoice == 3||currentChoice ==13){  
        	DrawList[index].x1 = DrawList[index].x2 = me.getX();  
        	DrawList[index].y1 = DrawList[index].y2 = me.getY();  
            index++;  
            createNewitem();//创建新的图形的基本单元对象  
        }  
              
    }  
    @Override  
    public void mouseReleased(MouseEvent me) {  
        // TODO 鼠标松开  
    	DrawingWindow.setStratBar("鼠标松开在：["+me.getX()+" ,"+me.getY()+"]");  
        if(currentChoice == 3||currentChoice ==13){  
        	DrawList[index].x1 = me.getX();  
        	DrawList[index].y1 = me.getY();  
        }  
        DrawList[index].x2 = me.getX();  
        DrawList[index].y2 = me.getY();  
        repaint();  
        index++;  
        createNewitem();//创建新的图形的基本单元对象  
    }  
}  


}

