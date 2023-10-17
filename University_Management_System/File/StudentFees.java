import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

class StudentFees
{
	JFrame win;
	Choice cbRollNo;
	JLabel lblTitle, lblRollNo, lblName, lblFName, lblCourse, lblBranch, lblSemester, lblPay;
	JTextField txtName, txtFName, txtPay;
	JComboBox cbCourse, cbBranch, cbSemester;
	JButton btnPay, btnCancel;

	public StudentFees()
	{
		win = new JFrame("Student Fee Form");

		win.getContentPane().setBackground(Color.WHITE);

		lblTitle = new JLabel("Student Fee Form");
		lblTitle.setBounds(100,10,500,80);
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("Monotype Corsiva",Font.BOLD,35));

		lblRollNo = new JLabel("Select Roll No");
		lblRollNo.setBounds(70,100,150,30);
		lblRollNo.setForeground(Color.BLACK);
		lblRollNo.setFont(new Font("Serif",Font.BOLD,18));

		lblName = new JLabel("Name");
		lblName.setBounds(70,135,200,25);
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Serif",Font.BOLD,18));

		lblFName = new JLabel("Father's Name");
		lblFName.setBounds(70,170,200,25);
		lblFName.setForeground(Color.BLACK);
		lblFName.setFont(new Font("Serif",Font.BOLD,18));

		lblCourse = new JLabel("Course");
		lblCourse.setBounds(70,205,200,25);
		lblCourse.setForeground(Color.BLACK);
		lblCourse.setFont(new Font("Serif",Font.BOLD,18));

		lblBranch = new JLabel("Branch");
		lblBranch.setBounds(70,240,200,25);
		lblBranch.setForeground(Color.BLACK);
		lblBranch.setFont(new Font("Serif",Font.BOLD,18));

		lblSemester = new JLabel("Semester");
		lblSemester.setBounds(70,275,200,25);
		lblSemester.setForeground(Color.BLACK);
		lblSemester.setFont(new Font("Serif",Font.BOLD,18));

		lblPay = new JLabel("Total Pay");
		lblPay.setBounds(70,310,200,25);
		lblPay.setForeground(Color.BLACK);
		lblPay.setFont(new Font("Serif",Font.BOLD,18));

		txtName = new JTextField();
		txtName.setBounds(250,135,150,25);
		txtName.setForeground(Color.BLACK);
		txtName.setHorizontalAlignment(JTextField.CENTER);
		txtName.setFont(new Font("Serif",Font.BOLD,18));

		txtFName = new JTextField();
		txtFName.setBounds(250,170,150,25);
		txtFName.setForeground(Color.BLACK);
		txtFName.setHorizontalAlignment(JTextField.CENTER);
		txtFName.setFont(new Font("Serif",Font.BOLD,18));

		txtPay = new JTextField();
		txtPay.setBounds(250,310,150,25);
		txtPay.setForeground(Color.BLACK);
		txtPay.setHorizontalAlignment(JTextField.CENTER);
		txtPay.setFont(new Font("Serif",Font.BOLD,18));

		cbRollNo = new Choice();
		cbRollNo.setBounds(250,100,150,25);

		String course[] ={"Course", "B.Tech", "BBA", "BCA", "Bsc", "Msc", "MBA", "BA"};

		cbCourse = new JComboBox(course);
		cbCourse.setBounds(250,205,150,25);

		String branch[] = {"Branch", "Computer Science", "Electronics", "Electrical", "Machanical", "Software", "Civil"};

		cbBranch = new JComboBox(branch);
		cbBranch.setBounds(250,240,150,25);

		String semester[] = {"Semester", "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", };

		cbSemester = new JComboBox(semester);
		cbSemester.setBounds(250,275,150,25);

		btnPay = new JButton("Pay");
		btnPay.setBounds(80,370,150,30);
		btnPay.setBackground(Color.BLACK);
		btnPay.setForeground(Color.WHITE);
		btnPay.setFont(new Font("Serif",Font.BOLD,15));
		btnPay.setFocusable(false);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(240,370,150,30);
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Serif",Font.BOLD,15));
		btnCancel.setFocusable(false);

		win.add(lblTitle);
		win.add(lblRollNo);
		win.add(lblName);
		win.add(lblFName);
		win.add(lblCourse);
		win.add(lblBranch);
		win.add(lblSemester);
		win.add(lblPay);

		win.add(txtName);
		win.add(txtFName);
		win.add(txtPay);

		win.add(cbRollNo);
		win.add(cbCourse);
		win.add(cbBranch);
		win.add(cbSemester);

		win.add(btnPay);
		win.add(btnCancel);

		win.setLayout(null);
		win.setSize(500,500);
		win.setLocationRelativeTo(null);
		win.setResizable(false);
		//win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setVisible(true);

		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");

			Statement state = conn.createStatement();

			ResultSet rs = state.executeQuery("SELECT rollNo FROM addstudent");

			while(rs.next())
			{
				cbRollNo.add(rs.getString("rollNo"));
			}
		}

		catch(Exception e)
		{

		}

		btnPay.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					String rollNo = (String)cbRollNo.getSelectedItem();
					String name = txtName.getText().toString();
					String fName = txtFName.getText().toString();
					String course = (String)cbCourse.getSelectedItem();
					String branch = (String)cbBranch.getSelectedItem();
					String semester = (String)cbSemester.getSelectedItem();
					String totalPay = txtPay.getText().toString();
					String date = new java.util.Date().toString();

					try
					{
						Class.forName("com.mysql.jdbc.Driver");

						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");

						Statement state = conn.createStatement();

						String query = "INSERT INTO feedetail VALUES('"+rollNo+"', '"+name+"', '"+fName+"', '"+course+"', '"+branch+"', '"+semester+"', '"+totalPay+"', '"+date+"')";

						state.executeUpdate(query);

						JOptionPane.showMessageDialog(null, "Successfully Pay");
						win.setVisible(false);

						new StudentFees().win.setVisible(true);
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

		btnCancel.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					win.setVisible(false);
				}
			});
	}

	public static void main(String[] args) {
		new StudentFees();
	}
	
}