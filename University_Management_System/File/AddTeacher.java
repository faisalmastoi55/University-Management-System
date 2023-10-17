import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;
class AddTeacher
{
	JFrame f;
	JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11,lbl12,lbl13,lbl14,lbl15;
	JTextField txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11,txt12;
	JButton btn1,btn2;
	JComboBox cb,cb1;

	AddTeacher()
	{
		f = new JFrame("Add Teacher");

		ImageIcon image = new ImageIcon("E:\\JAVA_Projects\\University_Management_System\\img\\Teacher.jpg");
		lbl14 = new JLabel(image);
		lbl14.setBounds(0,0,730,500);

		lbl1 = new JLabel("New Teacher Details");
		lbl1.setBounds(200,10,500,60);
		lbl1.setForeground(Color.BLACK);
		lbl1.setFont(new Font("Serif",Font.BOLD,30));

		lbl2 = new JLabel("Name");
		lbl2.setBounds(40,100,150,30);
		lbl2.setForeground(Color.BLACK);
		lbl2.setFont(new Font("Serif",Font.BOLD,20));

		txt1 = new JTextField();
		txt1.setBounds(170,100,150,30);
		txt1.setForeground(Color.BLACK);
		txt1.setOpaque(false);
		txt1.setFont(new Font("Serif",Font.BOLD,18));
		txt1.setHorizontalAlignment(JTextField.CENTER);

		lbl3 = new JLabel("Age");
		lbl3.setBounds(40,140,150,30);
		lbl3.setForeground(Color.BLACK);
		lbl3.setFont(new Font("Serif",Font.BOLD,20));

		txt2 = new JTextField();
		txt2.setBounds(170,140,150,30);
		txt2.setForeground(Color.BLACK);
		txt2.setOpaque(false);
		txt2.setFont(new Font("Serif",Font.BOLD,18));
		txt2.setHorizontalAlignment(JTextField.CENTER);

		lbl4 = new JLabel("Address");
		lbl4.setBounds(40,180,150,30);
		lbl4.setForeground(Color.BLACK);
		lbl4.setFont(new Font("Serif",Font.BOLD,20));

		txt3 = new JTextField();
		txt3.setBounds(170,180,150,30);
		txt3.setForeground(Color.BLACK);
		txt3.setOpaque(false);
		txt3.setFont(new Font("Serif",Font.BOLD,18));
		txt3.setHorizontalAlignment(JTextField.CENTER);

		lbl5 = new JLabel("Email id");
		lbl5.setBounds(40,220,150,30);
		lbl5.setForeground(Color.BLACK);
		lbl5.setFont(new Font("Serif",Font.BOLD,20));

		txt4 = new JTextField();
		txt4.setBounds(170,220,150,30);
		txt4.setForeground(Color.BLACK);
		txt4.setOpaque(false);
		txt4.setFont(new Font("Serif",Font.BOLD,18));
		txt4.setHorizontalAlignment(JTextField.CENTER);

		lbl6 = new JLabel("Class XII(%)");
		lbl6.setBounds(40,260,150,30);
		lbl6.setForeground(Color.BLACK);
		lbl6.setFont(new Font("Serif",Font.BOLD,20));

		txt5 = new JTextField();
		txt5.setBounds(170,260,150,30);
		txt5.setForeground(Color.BLACK);
		txt5.setOpaque(false);
		txt5.setFont(new Font("Serif",Font.BOLD,18));
		txt5.setHorizontalAlignment(JTextField.CENTER);

		lbl7 = new JLabel("Education");
		lbl7.setBounds(40,300,150,30);
		lbl7.setForeground(Color.BLACK);
		lbl7.setFont(new Font("Serif",Font.BOLD,20));

		String edu[] = {"Education", "B.Tech", "BBA", "BCA", "Bsc", "Msc", "MBA", "BA"};
		cb = new JComboBox(edu);
		cb.setBounds(170,300,150,30);

		lbl8 = new JLabel("Father's Name");
		lbl8.setBounds(340,100,150,30);
		lbl8.setForeground(Color.BLACK);
		lbl8.setFont(new Font("Serif",Font.BOLD,20));

		txt6 = new JTextField();
		txt6.setBounds(530,100,150,30);
		txt6.setForeground(Color.BLACK);
		txt6.setOpaque(false);
		txt6.setFont(new Font("Serif",Font.BOLD,18));
		txt6.setHorizontalAlignment(JTextField.CENTER);

		lbl9 = new JLabel("DOB(Y-M-D)");
		lbl9.setBounds(340,140,250,30);
		lbl9.setForeground(Color.BLACK);
		lbl9.setFont(new Font("Serif",Font.BOLD,20));

		txt7 = new JTextField();
		txt7.setBounds(530,140,150,30);
		txt7.setForeground(Color.BLACK);
		txt7.setOpaque(false);
		txt7.setFont(new Font("Serif",Font.BOLD,18));
		txt7.setHorizontalAlignment(JTextField.CENTER);

		lbl10 = new JLabel("Phone");
		lbl10.setBounds(340,180,250,30);
		lbl10.setForeground(Color.BLACK);
		lbl10.setFont(new Font("Serif",Font.BOLD,20));

		txt8 = new JTextField();
		txt8.setBounds(530,180,150,30);
		txt8.setForeground(Color.BLACK);
		txt8.setOpaque(false);
		txt8.setFont(new Font("Serif",Font.BOLD,18));
		txt8.setHorizontalAlignment(JTextField.CENTER);

		lbl11 = new JLabel("Class X(%)");
		lbl11.setBounds(340,220,250,30);
		lbl11.setForeground(Color.BLACK);
		lbl11.setFont(new Font("Serif",Font.BOLD,20));

		txt9 = new JTextField();
		txt9.setBounds(530,220,150,30);
		txt9.setForeground(Color.BLACK);
		txt9.setOpaque(false);
		txt9.setFont(new Font("Serif",Font.BOLD,18));
		txt9.setHorizontalAlignment(JTextField.CENTER);

		lbl12 = new JLabel("Department");
		lbl12.setBounds(340,260,250,30);
		lbl12.setForeground(Color.BLACK);
		lbl12.setFont(new Font("Serif",Font.BOLD,20));

		String dep[] = {"Department", "Computer Science", "Electronics", "Electrical", "Machanical", "Software", "Civil"};
		cb1 = new JComboBox(dep);
		cb1.setBounds(530,260,150,30);

		lbl13 = new JLabel("CNIC");
		lbl13.setBounds(340,300,250,30);
		lbl13.setForeground(Color.BLACK);
		lbl13.setFont(new Font("Serif",Font.BOLD,20));

		txt10 = new JTextField();
		txt10.setBounds(530,300,150,30);
		txt10.setForeground(Color.BLACK);
		txt10.setOpaque(false);
		txt10.setFont(new Font("Serif",Font.BOLD,18));
		txt10.setHorizontalAlignment(JTextField.CENTER);

		lbl15 = new JLabel("Emp Id");
		lbl15.setBounds(340,340,200,30);
		lbl15.setForeground(Color.BLACK);
		lbl15.setFont(new Font("Serif",Font.BOLD,20));

		txt12 = new JTextField();
		txt12.setBounds(530,340,150,30);
		txt12.setForeground(Color.BLACK);
		txt12.setOpaque(false);
		txt12.setFont(new Font("Serif",Font.BOLD,18));
		txt12.setHorizontalAlignment(JTextField.CENTER);

		btn1 = new JButton("Submit");
		btn1.setBounds(200,410,100,30);
		btn1.setBackground(Color.BLACK);
		btn1.setForeground(Color.WHITE);
		btn1.setFont(new Font("Serif",Font.BOLD,15));
		btn1.setFocusable(false);

		btn2 = new JButton("Cancel");
		btn2.setBounds(370,410,100,30);
		btn2.setBackground(Color.BLACK);
		btn2.setForeground(Color.WHITE);
		btn2.setFont(new Font("Serif",Font.BOLD,15));
		btn2.setFocusable(false);


		f.add(lbl1);
		f.add(lbl2);
		f.add(lbl3);
		f.add(lbl4);
		f.add(lbl5);
		f.add(lbl6);
		f.add(lbl7);
		f.add(lbl8);
		f.add(lbl9);
		f.add(lbl10);
		f.add(lbl11);
		f.add(lbl12);
		f.add(lbl13);
		f.add(lbl15);
		
		f.add(cb);
		f.add(cb1);

		f.add(txt1);
		f.add(txt2);
		f.add(txt3);
		f.add(txt4);
		f.add(txt5);
		f.add(txt6);
		f.add(txt7);
		f.add(txt8);
		f.add(txt9);
		f.add(txt10);
		f.add(txt12);
		
		f.add(btn1);
		f.add(btn2);

		f.add(lbl14);

		f.setLayout(null);
		f.setLocation(300,100);
		f.setSize(730,500);
		f.setVisible(true);
		f.setResizable(false);
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		btn1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					
					String name = txt1.getText().toString();
					String fName = txt6.getText().toString();
					String age = txt2.getText().toString();
					String dob = txt7.getText().toString();
					String address = txt3.getText().toString();
					String phone = txt8.getText().toString();
					String email = txt4.getText().toString();
					String classX = txt9.getText().toString();
					String classXII = txt5.getText().toString();
					String department = (String)cb1.getSelectedItem();
					String education = (String)cb.getSelectedItem();
					String cnic = txt10.getText().toString();
					String empId = txt12.getText().toString(); 

						try
						{
							Class.forName("com.mysql.jdbc.Driver");

							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");

							Statement state = conn.createStatement();

							String query = "INSERT INTO addteacher VALUES('"+name+"', '"+fName+"', '"+age+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+classX+"', '"+classXII+"', '"+department+"', '"+education+"', '"+cnic+"', '"+empId+"')";
							state.executeUpdate(query);

							JOptionPane.showMessageDialog(null, "Successfully Insert The Data");
							f.setVisible(false);

							new AddTeacher().f.setVisible(true);
						}

						catch(ClassNotFoundException cnfe)
						{
							System.out.println("SQL Exception : " +cnfe);
						}

						catch(SQLException sqle)
						{
							System.out.println("Exception : " +sqle);
						}
					}
			});

		btn2.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					f.setVisible(false);
				}
			});
		
	}

	public static void main(String arg[])
	{
		new AddTeacher();
	}

	
}