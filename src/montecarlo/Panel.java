package montecarlo;

import java.util.ArrayList;
import java.util.Random;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class Panel extends JPanel
{
	Random rand;
	long seed;
	private ArrayList<Dot> dots;
	Probability prob = new Probability();
	Info inf = new Info();
	double drops;
	double hits;
	
	public Panel()
	{
		seed = System.nanoTime();
		dots = new ArrayList<Dot>();
		
		//System.out.println(seed);
		rand = new Random(seed);
		drops = 0;
		hits = 0;
		
		initUI();
	}

    private void initUI()
    {
    	setOpaque(true);
		setSize(new Dimension(200, 200));
		setLocation(150, 50);
		setBackground(new Color(255, 255, 255));
		setBorder(BorderFactory.createLineBorder(Color.BLUE));
		setFocusable(true);
		requestFocus();
		setLayout(null);
    }
    
    @Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		super.paintComponent(g2d);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setColor(Color.BLACK);
        g2d.draw(new Ellipse2D.Double(0d, 0d, 200d, 200d));
        
        for (Dot d : dots)
        {
        	if (d.touch) g2d.setColor(Color.GREEN);
        	else g2d.setColor(Color.RED);
            g2d.draw(d);
        }
	}
    
    public void runDots(int t)
    {
    	//System.out.println("tock");
    	
    	for (int i = 0; i < t; i++)
    	{
	    	double x = 0 + (200 - 0) * rand.nextDouble();
	    	double y = 0 + (200 - 0) * rand.nextDouble();
	    	
	    	Dot nd = new Dot(x, y);
	    	dots.add(nd);
	    	drops++;
	    	
	    	double d = Math.sqrt(Math.pow((100d - x), 2) + Math.pow((100d - y), 2));
	    	if (d <= 100)
	    	{
				hits++;
				nd.touch = true;
	    	}
    	}
    	
    	prob.update(drops, hits);
    	inf.update(drops, hits);
    	
    	repaint();
    }
    
    public void clean()
    {
		seed = System.nanoTime();
		dots = new ArrayList<Dot>();
		rand = new Random(seed);
    	dots.clear();
		drops = 0d;
		hits = 0d;
		repaint();
    }
}
