package montecarlo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
class Frame extends JFrame
{
	protected Panel p;
	public Start sta;
	public static Boolean state = false;

	public Frame()
	{
	    initUI();
	}
	
	private void initUI()
	{  
	    p = new Panel();
	    sta = new Start();
	    
	    sta.sb.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String text = sta.f.getText();
				if (sta.checkValidNum(text))
				{
					p.runDots(Integer.parseInt(text));
					sta.sb.setText("add");
				}
				sta.f.setText(null);
			}
		});
	    
	    sta.reset.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				p.clean();
				sta.f.setText(null);
				sta.sb.setText("start");
			}
		});
		
	    setTitle("Montecarlo Method Simulation");
        setPreferredSize(new Dimension(500, 430));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new Color(255, 255, 255));
    	pack();
		setLocationRelativeTo(null);
        setVisible(true);
		setFocusable(false);
		setLayout(null);
		
		add(p);
		add(p.prob);
		add(p.inf);
		add(sta.sb);
		add(sta.f);
		add(sta.reset);
	}
}

