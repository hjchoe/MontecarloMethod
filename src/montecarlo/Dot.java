package montecarlo;

import java.awt.geom.Ellipse2D;

@SuppressWarnings("serial")
class Dot extends Ellipse2D.Double
{
	Boolean touch = false;
	private double r = 0.5d;
	
    Dot(double x, double y)
    {
        setFrame(x - r, y - r, 2.0d * r, 2.0d * r);
    }
}