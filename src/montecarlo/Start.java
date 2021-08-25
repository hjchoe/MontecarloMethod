package montecarlo;

import javax.swing.JButton;
import javax.swing.JTextField;

class Start
{
	JButton sb = new JButton();
	JButton reset = new JButton();
	JTextField f = new JTextField(1);
	
	Start()
	{
		sb.setText("start");
		sb.setSize(60, 20);
		sb.setLocation(270, 325);
		sb.setVisible(true);
		
		reset.setText("reset");
		reset.setSize(100, 20);
		reset.setLocation(200, 350);
		reset.setVisible(true);
		
		f.setText(null);
		f.setSize(100, 20);
		f.setLocation(170, 325);
		f.setVisible(true);
	}
	
	Boolean checkValidNum(String text)
	{
	    if (text == null) return false;
		try
		{
			int x = Integer.parseInt(text);
			if (x < 0) return false;
		}
		catch (NumberFormatException nfe) {
	    	return false;
	    }
		return true;
	}
}
