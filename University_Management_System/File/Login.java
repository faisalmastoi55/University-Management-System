import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import javax.swing.border.*;

class Login 
{
	JFrame f;
	ImageIcon icon;
	ImageIcon image;
	JLabel lblLogin, lblImage, lblName, lblPassword;
	JTextField txt1;
	JPasswordField passwordField;
	JButton btn1,btn2;
	Border border = BorderFactory.createLineBorder(Color.GRAY);
	Border borderOutline = BorderFactory.createLineBorder(Color.BLACK);

	Login()
	{
		f = new JFrame("LOGIN");
		f.getContentPane().setBackground(Color.WHITE);
		f.setLayout(null);

		icon = new ImageIcon("E:\\JAVA_Projects\\University_Management_System\\img\\LoginLogo.png");
		f.setIconImage(icon.getImage());

		image = new ImageIcon("E:\\JAVA_Projects\\University_Management_System\\img\\Login.jpg");
		lblImage = new JLabel(image);
		lblImage.setBounds(130,-50,650,350);

		lblLogin = new JLabel("LOGIN");
		lblLogin.setBounds(130,10,600,40);
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setFont(new Font("Serif",Font.BOLD,50));

		lblName = new JLabel("USER_NAME");
		lblName.setBounds(40,80,100,30);
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Serif",Font.BOLD,15));

		lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(40,130,100,30);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Serif",Font.BOLD,15));

		txt1 = new JTextField();
		txt1.setBounds(150,80,150,30);
		txt1.setForeground(Color.BLACK);
		txt1.setOpaque(false);
		txt1.setBorder(border);
		txt1.setHorizontalAlignment(JTextField.CENTER);
		txt1.setFont(new Font("Consolas",Font.BOLD,16));	

		passwordField = new JPasswordField();
		passwordField.setBounds(150,130,150,30);
		passwordField.setForeground(Color.BLACK);
		passwordField.setBorder(border);
		passwordField.setOpaque(false);
		passwordField.setHorizontalAlignment(JPasswordField.CENTER);
		//passwordField.setEchoChar('?');

		btn1 = new JButton("LOGIN");
		btn1.setBounds(40,200,120,30);
		btn1.setBackground(Color.BLACK);
		btn1.setForeground(Color.BLACK);
		btn1.setFocusable(false);
		btn1.setBorder(border);
		btn1.setOpaque(false);
		btn1.setFont(new Font("Serif",Font.BOLD,15));

		btn2 = new JButton("CANCEL");
		btn2.setBounds(180,200,120,30);
		btn2.setBackground(Color.BLACK);
		btn2.setForeground(Color.BLACK);
		btn2.setFocusable(false);
		btn2.setBorder(border);
		btn2.setOpaque(false);
		btn2.setFont(new Font("Serif",Font.BOLD,15));

		f.add(lblLogin);
		f.add(lblName);
		f.add(lblPassword);

		f.add(txt1);
		f.add(passwordField);

		f.add(btn1);
		f.add(btn2);

		f.add(lblImage);

		f.setLocation(300,200);
		f.setSize(600,300);
		f.setUndecorated(true);
		f.setVisible(true);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		txt1.addMouseListener(new MouseAdapter()
			{
				public void mouseEntered(MouseEvent me)
				{
					txt1.setBorder(borderOutline);
					
				}

			});

		txt1.addMouseListener(new MouseAdapter()
			{
				public void mouseExited(MouseEvent me)
				{
					txt1.setBorder(border);
					
				}
			});


		passwordField.addMouseListener(new MouseAdapter()
			{
				public void mouseEntered(MouseEvent me)
				{
					passwordField.setBorder(borderOutline);
				}

			});

		passwordField.addMouseListener(new MouseAdapter()
			{
				public void mouseExited(MouseEvent me)
				{
					passwordField.setBorder(border);
				}
			});

		btn1.addMouseListener(new MouseAdapter()
			{
				public void mouseEntered(MouseEvent me)
				{
					btn1.setBorder(borderOutline);
				}

			});

		btn1.addMouseListener(new MouseAdapter()
			{
				public void mouseExited(MouseEvent me)
				{
					btn1.setBorder(border);
				}
			});

		btn2.addMouseListener(new MouseAdapter()
			{
				public void mouseEntered(MouseEvent me)
				{
					btn2.setBorder(borderOutline);
				}

			});

		btn2.addMouseListener(new MouseAdapter()
			{
				public void mouseExited(MouseEvent me)
				{
					btn2.setBorder(border);
				}
			});


		btn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{

				if(ae.getSource() == btn1)
				{
					String user = txt1.getText();
					String password = passwordField.getText();

						if (user.equals("faisal") && password.equals("faisal12"))
						{
                			JOptionPane.showMessageDialog(null, "Login Successful");
							UniversitySystem us = new UniversitySystem();
							//new HospitalManagement();
							f.setVisible(false);
 
            			} 

            			else if(!user.equals("faisal") && !password.equals("faisal12"))
            			{
            				JOptionPane.showMessageDialog(null, "Invalid Username And Password");
            			}

            			else if(!user.equals("faisal"))
            			{
                			JOptionPane.showMessageDialog(null, "Invalid Username");
            			}

            			else{
            				JOptionPane.showMessageDialog(null,"Invalid password");
            			}
				}
			}
		});

		btn2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(ae.getSource() == btn2)
				{
					System.exit(0);
				}
			}
		});
	}
	
		public static void main(String arg[])
		{
			new Login();
		}

}