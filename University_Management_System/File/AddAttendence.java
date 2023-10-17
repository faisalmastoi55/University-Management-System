import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

class AddAttendence
{
	JFrame f;
	JLabel lbl1,lbl2,lbl4;
	JComboBox cb, cbRoll;
	JButton btnSubmit, btnCancel;

	AddAttendence()
	{
		f = new JFrame("Student Attendence");
		f.getContentPane().setBackground(Color.WHITE);

		lbl1 = new JLabel("Attendence");
		lbl1.setBounds(100,20,200,30);
		lbl1.setForeground(Color.BLUE);
		lbl1.setFont(new Font("Serif",Font.BOLD,25));

		lbl2 = new JLabel("Enter Roll No");
		lbl2.setBounds(60,70,100,30);
		lbl2.setForeground(Color.BLACK);

		lbl4 = new JLabel("Attendence");
		lbl4.setBounds(60,150,100,30);
		lbl4.setForeground(Color.BLACK);

		String data[] = {"Attendence","Present","Absent","Leave"};
		cb = new JComboBox(data);
		cb.setBounds(180,155,80,20);

		Choice cbRoll = new Choice();
		cbRoll.setBounds(180,75,80,20);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(70,230,80,20);
		btnSubmit.setBackground(Color.BLACK);
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFocusable(false);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(180,230,80,20);
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFocusable(false);

		f.add(lbl1);
		f.add(lbl2);
		f.add(lbl4);

		f.add(cb);
		f.add(cbRoll);

		f.add(btnSubmit);
		f.add(btnCancel);


		f.setLayout(null);
		f.setSize(350,350);
		f.setLocationRelativeTo(null);
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setVisible(true);


		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root","");

			Statement state = conn.createStatement();

			ResultSet rs = state.executeQuery("SELECT rollNo FROM addstudent");

			while(rs.next())
			{
				cbRoll.add(rs.getString("rollNo"));
			}
		}

		catch(Exception e)
		{

		}

		btnSubmit.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					String roll = (String)cbRoll.getSelectedItem();
					String date = new java.util.Date().toString();
					String attendence = (String)cb.getSelectedItem();

					try
					{
						Class.forName("com.mysql.jdbc.Driver");

						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");

						Statement state = conn.createStatement();

						String query = "INSERT INTO studentattendance VALUES('"+roll+"', '"+date+"', '"+attendence+"')";

						state.executeUpdate(query);

						JOptionPane.showMessageDialog(null,"Successfully Insert The Attendence");
						f.setVisible(false);

						new AddAttendence().f.setVisible(true);
					}

					catch(ClassNotFoundException cnfe)
					{
						System.out.println("Exception : " +cnfe);
					}

					catch(SQLException sqle)
					{
						System.out.println("SQLException : " +sqle);
					}
				}
			});

		btnCancel.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					f.setVisible(false);
				}
			});
	}


	public static void main(String arg[])
	{
		new AddAttendence();
	}
	
}