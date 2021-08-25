package montecarlo;

import javax.swing.JLabel;

@SuppressWarnings("serial")
class Probability extends JLabel
{
	Probability()
	{
		setText("4 * hits / drops = 0");
		setSize(500, 20);
		setLocation(150, 25);
		setVisible(true);
	}
	
	public void update(double d, double h)
	{
		setText("4 * hits / drops = " + Double.toString(4d*h/d));
	}
}
