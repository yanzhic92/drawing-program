import java.awt.*;
class Line extends Drawing
{
	void draw(Graphics2D g) {
		g.setColor(new Color(R,G,B));
		g.setStroke(new BasicStroke(stroke));
		g.drawLine(x1, y1, x2, y2);
	}
}