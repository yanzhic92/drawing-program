import java.awt.*;
class Line extends Drawing
{
	void draw(Graphics g) {
		g.setColor(new Color(R,G,B));
		g.setStroke();
		g.drawLine(x1, y1, x2, y2);
	}
}