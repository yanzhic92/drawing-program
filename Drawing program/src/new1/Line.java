package new1;



import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

class Line extends Drawing
{
	void draw(Graphics2D g2d) {
		g2d.setPaint(new Color(R, G, B));
		g2d.setStroke(new BasicStroke(stroke, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_BEVEL));
		g2d.drawLine(x1, y1, x2, y2);
		
	}
}
