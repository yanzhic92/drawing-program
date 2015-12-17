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
        Graphics2D g2d = (Graphics2D)g;//������ʻ�  
        int  j = 0;  
        while(j<=index)  
        {  
            draw(g2d,DrawList[j]);  
            j++;  
        }  
          
    }  
    void draw(Graphics2D g2d , Drawing i)  
    {  
        i.draw(g2d);//�����ʴ���������������У�������ɸ��ԵĻ�ͼ  
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
        // TODO ������  
        DrawingWindow.setStratBar("�������ڣ�["+me.getX()+" ,"+me.getY()+"]");  
    }  
    @Override  
    public void mouseExited(MouseEvent me) {  
        // TODO ����˳�  
    	DrawingWindow.setStratBar("����˳��ڣ�["+me.getX()+" ,"+me.getY()+"]");  
    }  
    @Override  
    public void mousePressed(MouseEvent me) {  
        // TODO ��갴��  
    	DrawingWindow.setStratBar("��갴���ڣ�["+me.getX()+" ,"+me.getY()+"]");//����״̬����ʾ  
          
    	DrawList[index].x1 = DrawList[index].x2 = me.getX();  
    	DrawList[index].y1 = DrawList[index].y2 = me.getY();  
          
        //�����ǰѡ��Ϊ��ʻ�����Ƥ�� �����������Ĳ���  
        if(currentChoice == 3||currentChoice ==13){  
        	DrawList[index].x1 = DrawList[index].x2 = me.getX();  
        	DrawList[index].y1 = DrawList[index].y2 = me.getY();  
            index++;  
            createNewitem();//�����µ�ͼ�εĻ�����Ԫ����  
        }  
              
    }  
    @Override  
    public void mouseReleased(MouseEvent me) {  
        // TODO ����ɿ�  
    	DrawingWindow.setStratBar("����ɿ��ڣ�["+me.getX()+" ,"+me.getY()+"]");  
        if(currentChoice == 3||currentChoice ==13){  
        	DrawList[index].x1 = me.getX();  
        	DrawList[index].y1 = me.getY();  
        }  
        DrawList[index].x2 = me.getX();  
        DrawList[index].y2 = me.getY();  
        repaint();  
        index++;  
        createNewitem();//�����µ�ͼ�εĻ�����Ԫ����  
    }  
}  


}

