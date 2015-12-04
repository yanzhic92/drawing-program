import java.awt.*;
class Pen extends Drawing{
    void draw(Graphics2D g2d ){  
        g2d.setPaint(new Color(R,G,B));  
        g2d.setStroke(new BasicStroke(stroke));  
        g2d.drawLine(x1, y1,x2, y2);  
    }  
}  