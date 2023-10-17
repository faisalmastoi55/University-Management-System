import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

class StudentMarkSheet
{
	JFrame win;
	JLabel lblTitle, lblRollNo, lblSubject, lblMarks;
	JTextField txtRollNo, txtSubject1, txtSubject2, txtSubject3, txtSubject4, txtSubject5;
	JTextField txtMarks1, txtMarks2, txtMarks3, txtMarks4, txtMarks5;
	JButton btnSubmit;

	public StudentMarkSheet()
	{
		win = new JFrame("MarkSheet");

		win.getContentPane().setBackground(Color.WHITE);

		lblTitle = new JLabel("Enter marks of Student");
		lblTitle.setBounds(80,20,330,50);
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("Serif",Font.BOLD,31));

		lblRollNo = new JLabel("Enter Roll Number");
		lblRollNo.setBounds(70,100,200,20);
		lblRollNo.setForeground(Color.BLACK);
		lblRollNo.setFont(new Font("Serif",Font.BOLD,13));

		lblSubject = new JLabel("Enter Subject");
		lblSubject.setBounds(70,180,200,20);
		lblSubject.setForeground(Color.BLACK);
		lblSubject.setFont(new Font("Camberia",Font.BOLD,13));

		lblMarks = new JLabel("Enter Marks");
		lblMarks.setBounds(230,180,200,20);
		lblMarks.setForeground(Color.BLACK);
		lblMarks.setFont(new Font("Camberia",Font.BOLD,13));

		txtRollNo = new JTextField();
		txtRollNo.setBounds(200,100,190,20);
		txtRollNo.setBackground(Color.WHITE);
		txtRollNo.setForeground(Color.BLACK);
		txtRollNo.setHorizontalAlignment(JTextField.CENTER);

		txtSubject1 = new JTextField();
		txtSubject1.setBounds(70,220,160,20);
		txtSubject1.setBackground(Color.WHITE);
		txtSubject1.setForeground(Color.BLACK);
		txtSubject1.setHorizontalAlignment(JTextField.CENTER);

		txtSubject2 = new JTextField();
		txtSubject2.setBounds(70,250,160,20);
		txtSubject2.setBackground(Color.WHITE);
		txtSubject2.setForeground(Color.BLACK);
		txtSubject2.setHorizontalAlignment(JTextField.CENTER);

		txtSubject3 = new JTextField();
		txtSubject3.setBounds(70,280,160,20);
		txtSubject3.setBackground(Color.WHITE);
		txtSubject3.setForeground(Color.BLACK);
		txtSubject3.setHorizontalAlignment(JTextField.CENTER);

		txtSubject4 = new JTextField();
		txtSubject4.setBounds(70,310,160,20);
		txtSubject4.setBackground(Color.WHITE);
		txtSubject4.setForeground(Color.BLACK);
		txtSubject4.setHorizontalAlignment(JTextField.CENTER);

		txtSubject5 = new JTextField();
		txtSubject5.setBounds(70,340,160,20);
		txtSubject5.setBackground(Color.WHITE);
		txtSubject5.setForeground(Color.BLACK);
		txtSubject5.setHorizontalAlignment(JTextField.CENTER);

		txtMarks1 = new JTextField();
		txtMarks1.setBounds(230,220,160,20);
		txtMarks1.setBackground(Color.WHITE);
		txtMarks1.setForeground(Color.BLACK);
		txtMarks1.setHorizontalAlignment(JTextField.CENTER);

		txtMarks2 = new JTextField();
		txtMarks2.setBounds(230,250,160,20);
		txtMarks2.setBackground(Color.WHITE);
		txtMarks2.setForeground(Color.BLACK);
		txtMarks2.setHorizontalAlignment(JTextField.CENTER);

		txtMarks3 = new JTextField();
		txtMarks3.setBounds(230,280,160,20);
		txtMarks3.setBackground(Color.WHITE);
		txtMarks3.setForeground(Color.BLACK);
		txtMarks3.setHorizontalAlignment(JTextField.CENTER);

		txtMarks4 = new JTextField();
		txtMarks4.setBounds(230,310,160,20);
		txtMarks4.setBackground(Color.WHITE);
		txtMarks4.setForeground(Color.BLACK);
		txtMarks4.setHorizontalAlignment(JTextField.CENTER);

		txtMarks5 = new JTextField();
		txtMarks5.setBounds(230,340,160,20);
		txtMarks5.setBackground(Color.WHITE);
		txtMarks5.setForeground(Color.BLACK);
		txtMarks5.setHorizontalAlignment(JTextField.CENTER);

		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(70,380,320,30);
		btnSubmit.setBackground(Color.BLACK);
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFocusable(false);


		win.add(lblTitle);
		win.add(lblRollNo);
		win.add(lblSubject);
		win.add(lblMarks);

		win.add(txtRollNo);
		win.add(txtSubject1);
		win.add(txtSubject2);
		win.add(txtSubject3);
		win.add(txtSubject4);
		win.add(txtSubject5);

		win.add(txtMarks1);
		win.add(txtMarks2);
		win.add(txtMarks3);
		win.add(txtMarks4);
		win.add(txtMarks5);

		win.add(btnSubmit);

		win.setLayout(null);
		win.setSize(500,500);
		win.setLocationRelativeTo(null);
		win.setResizable(false);
		//win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setVisible(true);

		btnSubmit.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					String rollNo = txtRollNo.getText().toString();
					String sub1 = txtSubject1.getText().toString();
					String sub2 = txtSubject2.getText().toString();
					String sub3 = txtSubject3.getText().toString();
					String sub4 = txtSubject4.getText().toString();
					String sub5 = txtSubject5.getText().toString();
					
					String mark1 = txtMarks1.getText().toString();
					String mark2 = txtMarks2.getText().toString();
					String mark3 = txtMarks3.getText().toString();
					String mark4 = txtMarks4.getText().toString();
					String mark5 = txtMarks5.getText().toString();

					try
					{
						Class.forName("com.mysql.jdbc.Driver");

						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");

						Statement state = conn.createStatement();

						String query1 = "INSERT INTO subject VALUES('"+rollNo+"', '"+sub1+"', '"+sub2+"', '"+sub3+"', '"+sub4+"', '"+sub5+"')";
						String query2 = "INSERT INTO marks VALUES('"+rollNo+"', '"+mark1+"', '"+mark2+"', '"+mark3+"', '"+mark4+"', '"+mark5+"')";

						state.executeUpdate(query1);
						state.executeUpdate(query2);

						JOptionPane.showMessageDialog(null, "Successfully Insert The Marks");
						win.setVisible(false);

						new StudentMarkSheet().win.setVisible(true);

					}

					catch(ClassNotFoundException cnfe)
					{
						System.out.println("ClassNotFoundException : " +cnfe);
					}

					catch(SQLException sqle)
					{
						System.out.println("SQLException : " +sqle);
					}

				}
			});
	}

	
	public static void main(String[] args) {
		new StudentMarkSheet();
	}
}