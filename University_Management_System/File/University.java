import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class University
{
	public static void main(String arg[])
	{
		Frame f = new Frame("University Management System");
		ImageIcon i2 = new ImageIcon("E:\\JAVA_Projects\\University_Management_System\\img\\University1.jpg");
		JLabel m1 =new JLabel(i2);
		//m1.setBounds(-50,-50,100,100);
		f.add(m1);

		f.setVisible(true);

		int i;
		int x = 1;
		
		for(i=2; i<=600; i+=4, x+=1)
		{
			f.setLocation((500-((i+x)/2) ), 300-(i/2));
			f.setSize(i+3*x,i+x/2);

			try
			{
				Thread.sleep(10);
			}

			catch(Exception e)
			{

			}
		}

	Thread t1;

		t1 = new Thread();
		t1.start();

		try
		{
			Thread.sleep(3000);
			Login log = new Login();
			f.setVisible(false);
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}
