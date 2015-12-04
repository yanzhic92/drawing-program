import java.awt.*;
public class Rubber extends Drawing{
    void draw(Graphics2D g2d ){  
        g2d.setPaint(new Color(255,255,255));
        g2d.setStroke(new BasicStroke(stroke));  
        g2d.drawLine(x1, y1,x2, y2);  
    }  
}  