import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

class UpdateStudents
{
	JFrame f;
	JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11,lbl12,lbl13,lbl14,lbl15, lbl16;
	JTextField txtName,txtAge,txtAddress,txtEmail,txtClassXII,txtFname,txtDate,txtPhone,txtClassX,txtRollNo,txtCNIC,txtBranch,txtCourse,txtSearch;
	JButton btnUpdate,btnCancel,btnSearch;

	UpdateStudents()
	{
		f = new JFrame("Update Students");

		f.getContentPane().setBackground(Color.WHITE);

		lbl1 = new JLabel("Update Student Details:");
		lbl1.setBounds(150,05,500,60);
		lbl1.setForeground(Color.BLACK);
		lbl1.setFont(new Font("Monotype Corsiva",Font.BOLD,35));

		lbl16 = new JLabel("Enter roll no to search the data of student : ");
		lbl16.setBounds(40,80,500,20);
		lbl16.setForeground(Color.BLACK);
		lbl16.setFont(new Font("Monotype Corsiva",Font.PLAIN,22));

		txtSearch = new JTextField();
		txtSearch.setBounds(410,80,150,25);
		txtSearch.setForeground(Color.BLACK);
		txtSearch.setFont(new Font("Serif",Font.BOLD,18));
		txtSearch.setHorizontalAlignment(JTextField.CENTER);

		lbl2 = new JLabel("Name");
		lbl2.setBounds(40,140,150,30);
		lbl2.setForeground(Color.BLACK);
		lbl2.setFont(new Font("Serif",Font.BOLD,20));

		txtName = new JTextField();
		txtName.setBounds(170,140,150,30);
		txtName.setForeground(Color.BLACK);
		txtName.setFont(new Font("Serif",Font.BOLD,18));
		txtName.setHorizontalAlignment(JTextField.CENTER);

		lbl3 = new JLabel("Age");
		lbl3.setBounds(40,180,150,30);
		lbl3.setForeground(Color.BLACK);
		lbl3.setFont(new Font("Serif",Font.BOLD,20));

		txtAge = new JTextField();
		txtAge.setBounds(170,180,150,30);
		txtAge.setForeground(Color.BLACK);
		txtAge.setFont(new Font("Serif",Font.BOLD,18));
		txtAge.setHorizontalAlignment(JTextField.CENTER);

		lbl4 = new JLabel("Address");
		lbl4.setBounds(40,220,150,30);
		lbl4.setForeground(Color.BLACK);
		lbl4.setFont(new Font("Serif",Font.BOLD,20));

		txtAddress = new JTextField();
		txtAddress.setBounds(170,220,150,30);
		txtAddress.setForeground(Color.BLACK);
		txtAddress.setFont(new Font("Serif",Font.BOLD,18));
		txtAddress.setHorizontalAlignment(JTextField.CENTER);

		lbl5 = new JLabel("Email id");
		lbl5.setBounds(40,260,150,30);
		lbl5.setForeground(Color.BLACK);
		lbl5.setFont(new Font("Serif",Font.BOLD,20));

		txtEmail = new JTextField();
		txtEmail.setBounds(170,260,150,30);
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setFont(new Font("Serif",Font.BOLD,12));
		txtEmail.setHorizontalAlignment(JTextField.CENTER);

		lbl6 = new JLabel("Class XII(%)");
		lbl6.setBounds(40,300,150,30);
		lbl6.setForeground(Color.BLACK);
		lbl6.setFont(new Font("Serif",Font.BOLD,20));

		txtClassXII = new JTextField();
		txtClassXII.setBounds(170,300,150,30);
		txtClassXII.setForeground(Color.BLACK);
		txtClassXII.setFont(new Font("Serif",Font.BOLD,18));
		txtClassXII.setHorizontalAlignment(JTextField.CENTER);

		lbl13 = new JLabel("Roll No");
		lbl13.setBounds(40,340,250,30);
		lbl13.setForeground(Color.BLACK);
		lbl13.setFont(new Font("Serif",Font.BOLD,20));

		txtRollNo = new JTextField();
		txtRollNo.setBounds(170,340,150,30);
		txtRollNo.setForeground(Color.BLACK);
		txtRollNo.setFont(new Font("Serif",Font.BOLD,18));
		txtRollNo.setHorizontalAlignment(JTextField.CENTER);

		lbl7 = new JLabel("Branch");
		lbl7.setBounds(40,380,150,30);
		lbl7.setForeground(Color.BLACK);
		lbl7.setFont(new Font("Serif",Font.BOLD,20));

		txtBranch = new JTextField();
		txtBranch.setBounds(170,380,150,30);
		txtBranch.setForeground(Color.BLACK);
		txtBranch.setFont(new Font("Serif",Font.BOLD,18));
		txtBranch.setHorizontalAlignment(JTextField.CENTER);
		
		lbl8 = new JLabel("Father's Name");
		lbl8.setBounds(340,140,150,30);
		lbl8.setForeground(Color.BLACK);
		lbl8.setFont(new Font("Serif",Font.BOLD,20));

		txtFname = new JTextField();
		txtFname.setBounds(530,140,150,30);
		txtFname.setForeground(Color.BLACK);
		txtFname.setFont(new Font("Serif",Font.BOLD,18));
		txtFname.setHorizontalAlignment(JTextField.CENTER);

		lbl9 = new JLabel("DOB");
		lbl9.setBounds(340,180,250,30);
		lbl9.setForeground(Color.BLACK);
		lbl9.setFont(new Font("Serif",Font.BOLD,20));

		txtDate = new JTextField();
		txtDate.setBounds(530,180,150,30);
		txtDate.setForeground(Color.BLACK);
		txtDate.setFont(new Font("Serif",Font.BOLD,18));
		txtDate.setHorizontalAlignment(JTextField.CENTER);

		lbl10 = new JLabel("Phone");
		lbl10.setBounds(340,220,250,30);
		lbl10.setForeground(Color.BLACK);
		lbl10.setFont(new Font("Serif",Font.BOLD,20));

		txtPhone = new JTextField();
		txtPhone.setBounds(530,220,150,30);
		txtPhone.setForeground(Color.BLACK);
		txtPhone.setFont(new Font("Serif",Font.BOLD,18));
		txtPhone.setHorizontalAlignment(JTextField.CENTER);

		lbl11 = new JLabel("Class X(%)");
		lbl11.setBounds(340,260,250,30);
		lbl11.setForeground(Color.BLACK);
		lbl11.setFont(new Font("Serif",Font.BOLD,20));

		txtClassX = new JTextField();
		txtClassX.setBounds(530,260,150,30);
		txtClassX.setForeground(Color.BLACK);
		txtClassX.setFont(new Font("Serif",Font.BOLD,18));
		txtClassX.setHorizontalAlignment(JTextField.CENTER);

		lbl14 = new JLabel("CNIC");
		lbl14.setBounds(340,300,250,30);
		lbl14.setForeground(Color.BLACK);
		lbl14.setFont(new Font("Serif",Font.BOLD,20));

		txtCNIC = new JTextField();
		txtCNIC.setBounds(530,300,150,30);
		txtCNIC.setForeground(Color.BLACK);
		txtCNIC.setFont(new Font("Serif",Font.BOLD,18));
		txtCNIC.setHorizontalAlignment(JTextField.CENTER);

		lbl12 = new JLabel("Course");
		lbl12.setBounds(340,340,250,30);
		lbl12.setForeground(Color.BLACK);
		lbl12.setFont(new Font("Serif",Font.BOLD,20));

		txtCourse = new JTextField();
		txtCourse.setBounds(530,340,150,30);
		txtCourse.setForeground(Color.BLACK);
		txtCourse.setFont(new Font("Serif",Font.BOLD,18));
		txtCourse.setHorizontalAlignment(JTextField.CENTER);

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(400,410,100,30);
		btnUpdate.setBackground(Color.BLACK);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Serif",Font.BOLD,15));
		btnUpdate.setFocusable(false);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(570,410,100,30);
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Serif",Font.BOLD,15));
		btnCancel.setFocusable(false);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(570,80,110,25);
		btnSearch.setBackground(Color.BLACK);
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Serif",Font.BOLD,15));
		btnSearch.setFocusable(false);

		
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
		f.add(lbl14);
		f.add(lbl16);

		f.add(txtName);
		f.add(txtAge);
		f.add(txtAddress);
		f.add(txtEmail);
		f.add(txtClassXII);
		f.add(txtFname);
		f.add(txtDate);
		f.add(txtPhone);
		f.add(txtClassX);
		f.add(txtRollNo);
		f.add(txtCNIC);
		f.add(txtBranch);
		f.add(txtCourse);
		f.add(txtSearch);

		f.add(btnUpdate);
		f.add(btnCancel);
		f.add(btnSearch);

		f.setLayout(null);
		f.setLocation(300,100);
		f.setSize(730,500);
		f.setVisible(true);
		f.setResizable(false);
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnSearch.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					String search = txtSearch.getText();

					try
					{
						Class.forName("com.mysql.jdbc.Driver");

						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");

						Statement state = conn.createStatement();

						ResultSet rs = state.executeQuery("SELECT * FROM addstudent WHERE rollNo = '"+search+"'");

						while(rs.next())
						{
							txtName.setText(rs.getString("name"));
							txtFname.setText(rs.getString("fName"));
							txtAge.setText(rs.getString("age"));
							txtDate.setText(rs.getString("date"));
							txtAddress.setText(rs.getString("address"));
							txtPhone.setText(rs.getString("phone"));
							txtEmail.setText(rs.getString("email"));
							txtClassX.setText(rs.getString("classX"));
							txtClassXII.setText(rs.getString("classXII"));
							txtCNIC.setText(rs.getString("cnic"));
							txtRollNo.setText(rs.getString("rollNo"));
							txtCourse.setText(rs.getString("course"));
							txtBranch.setText(rs.getString("branch"));
						}

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

		btnUpdate.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					String name = txtName.getText().toString();
					String fName = txtFname.getText().toString();
					String age = txtAge.getText().toString();
					String dob = txtDate.getText().toString();
					String address = txtAddress.getText().toString();
					String phone = txtPhone.getText().toString();
					String email = txtEmail.getText().toString();
					String classX = txtClassX.getText().toString();
					String classXII = txtClassXII.getText().toString();
					String cnic = txtCNIC.getText().toString();
					String rNo = txtRollNo.getText().toString(); 
					String course = txtCourse.getText().toString();
					String branch = txtBranch.getText().toString();

					try
					{
						Class.forName("com.mysql.jdbc.Driver");

						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");

						Statement state = conn.createStatement();

						String query = "UPDATE addstudent set name = '"+name+"', fName = '"+fName+"', age = '"+age+"', date = '"+dob+"', "+
										" address = '"+address+"', phone = '"+phone+"', email = '"+email+"', classX = '"+classX+"', "+
										" classXII = '"+classXII+"', cnic = '"+cnic+"', rollNo = '"+rNo+"', course = '"+course+"', "+
										" branch = '"+branch+"' WHERE rollNo = '"+rNo+"'  ";

						state.executeUpdate(query);
						
						JOptionPane.showMessageDialog(null, "Successfully Update");
						f.setVisible(false);

						new UpdateStudents().f.setVisible(true);				
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
					f.setVisible(false);
				}
			});
		
	}

	public static void main(String arg[])
	{
		new UpdateStudents();
	}

	
}