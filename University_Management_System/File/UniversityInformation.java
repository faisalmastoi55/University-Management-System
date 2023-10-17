import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class UniversityInformation
{
	JFrame win;
	ImageIcon image,imageFaisal;
	JLabel lblImage, lblFaisal, lblAbout,lblName, lblDep, lblUni, lblDesi, lblEmail, lblCell, lblAddress, lblClose;

	public UniversityInformation()
	{
		win = new JFrame("Hospital Information");
		win.getContentPane().setBackground(Color.WHITE);

		image = new ImageIcon("E:\\JAVA_Projects\\University_Management_System\\img\\University3.jpg");
		lblImage = new JLabel(image);
		lblImage.setBounds(0,40,730,550);
		
		imageFaisal = new ImageIcon("E:\\Hospital\\Faisal.jpg");
		lblFaisal = new JLabel(imageFaisal);
		lblFaisal.setBounds(-90,100,400,300);

		lblClose = new JLabel("  X");
		lblClose.setBounds(690,0,40,35);
		lblClose.setBackground(Color.BLACK);
		lblClose.setForeground(Color.BLACK);
		lblClose.setOpaque(false);
		lblClose.setFont(new Font("Comic Sans MS",Font.PLAIN,20));

		lblAbout = new JLabel("About Us");
		lblAbout.setBounds(280,40,300,50);
		lblAbout.setForeground(Color.BLACK);
		lblAbout.setFont(new Font("Agency FB",Font.BOLD,50));

		lblName = new JLabel("Name : Faisal Ali Mastoi");
		lblName.setBounds(230,130,300,30);
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Cambria",Font.BOLD,20));

		lblDep = new JLabel("Department : IMCS");
		lblDep.setBounds(230,170,300,30);
		lblDep.setForeground(Color.BLACK);
		lblDep.setFont(new Font("Cambria",Font.BOLD,20));

		lblUni = new JLabel("University : University of Sindh");
		lblUni.setBounds(230,210,300,30);
		lblUni.setForeground(Color.BLACK);
		lblUni.setFont(new Font("Cambria",Font.BOLD,20));

		lblDesi = new JLabel("Designation : Software Engineer");
		lblDesi.setBounds(230,250,300,30);
		lblDesi.setForeground(Color.BLACK);
		lblDesi.setFont(new Font("Cambria",Font.BOLD,20));

		lblEmail = new JLabel("E-Mail : faisalmastoi341@gmail.com");
		lblEmail.setBounds(230,290,350,30);
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Cambria",Font.BOLD,20));

		lblCell = new JLabel("Cell No : +92 311 1794360");
		lblCell.setBounds(230,330,300,30);
		lblCell.setForeground(Color.BLACK);
		lblCell.setFont(new Font("Cambria",Font.BOLD,20));

		lblAddress = new JLabel("Address : Khuda KI Basti, Kotri");
		lblAddress.setBounds(230,370,300,30);
		lblAddress.setForeground(Color.BLACK);
		lblAddress.setFont(new Font("Cambria",Font.BOLD,20));


		win.add(lblClose);
		win.add(lblAbout);
		win.add(lblName);
		win.add(lblDep);
		win.add(lblUni);
		win.add(lblDesi);
		win.add(lblEmail);
		win.add(lblCell);
		win.add(lblAddress);



		/*lbl = new JLabel("<html> Faisal  <br/> Mastoi</html>">);
		lbl.setBounds(100,50,150,30);
		lbl.setForeground(Color.BLACK);
		win.add(lbl);*/

		win.add(lblFaisal);


		win.add(lblImage);



		win.setSize(730,500);
		win.setLocation(280,100);
		win.setResizable(false);
		win.setUndecorated(true);
		win.setVisible(true);


		lblClose.addMouseListener(new MouseAdapter()
			{
				public void mouseEntered(MouseEvent me)
				{
					lblClose.setBackground(Color.RED);
					lblClose.setForeground(Color.WHITE);
					lblClose.setOpaque(true);
				}
			});

		lblClose.addMouseListener(new MouseAdapter()
			{
				public void mouseExited(MouseEvent me)
				{
					lblClose.setBackground(Color.BLACK);
					lblClose.setForeground(Color.BLACK);
					lblClose.setOpaque(false);
				}
			});

		lblClose.addMouseListener(new MouseAdapter()
			{
				public void mouseClicked(MouseEvent ae)
				{
					win.setVisible(false);

				}
			});
	}

	public static void main(String[] args) {
		new UniversityInformation();
	}
	
}