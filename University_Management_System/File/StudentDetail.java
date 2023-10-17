import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

import java.sql.*;

class StudentDetail
{
	JFrame f;
	JLabel lbl1,lbl2,lbl3;
	JTextField txt1;
	JButton btnDelete, btnAdd, btnUpdate;
	DefaultTableModel model;
	DefaultTableCellRenderer center;

	StudentDetail()
	{
		f = new JFrame("Student Details");

		String row[][] = {};

		String columns[] = {"Roll No", "Name", "Father's Name", "Age", "DOB", "Addrees", "Phone", "Email", "Class X(%)", "Class XII(%)", "CNIC", "Course", "Branch"};

		model = new DefaultTableModel(row, columns);

		JTable table = new JTable(model)
		{
			public boolean isCellEditable(int row, int columns)
			{
				return false;
			}
		};

		center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(center);
		table.getColumnModel().getColumn(3).setCellRenderer(center);
		table.getColumnModel().getColumn(4).setCellRenderer(center);
		table.getColumnModel().getColumn(8).setCellRenderer(center);
		table.getColumnModel().getColumn(9).setCellRenderer(center);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(20,20,950,250);
		table.setForeground(Color.BLACK);
		table.getTableHeader().setFont(new Font("Agency FB",Font.BOLD,18));
		table.setRowHeight(30);
		f.add(pane);

		lbl1 = new JLabel("Enter Roll no to delete Student Record : ");
		lbl1.setBounds(30,290,450,30);
		lbl1.setForeground(Color.BLACK);
		lbl1.setFont(new Font("Serif",Font.BOLD,15));
		f.add(lbl1);

		txt1 = new JTextField();
		txt1.setBounds(300,290,100,30);
		txt1.setForeground(Color.BLACK);
		txt1.setHorizontalAlignment(JTextField.CENTER);
		txt1.setFont(new Font("Serif",Font.BOLD,16));
		f.add(txt1);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(420,290,100,30);
		btnDelete.setBackground(Color.BLACK);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Serif",Font.BOLD,16));
		btnDelete.setFocusable(false);
		f.add(btnDelete);

		lbl2 = new JLabel("Add New Student");
		lbl2.setBounds(30,360,300,30);
		lbl2.setForeground(Color.BLACK);
		lbl2.setFont(new Font("Serif",Font.BOLD,15));
		f.add(lbl2);

		btnAdd = new JButton("Add");
		btnAdd.setBounds(220,360,120,30);
		btnAdd.setBackground(Color.BLACK);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Serif",Font.BOLD,15));
		btnAdd.setFocusable(false);
		f.add(btnAdd);

		lbl3 = new JLabel("Update Student Details");
		lbl3.setBounds(30,400,300,30);
		lbl3.setForeground(Color.BLACK);
		lbl3.setFont(new Font("Serif",Font.BOLD,15));
		f.add(lbl3);

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(220,400,120,30);
		btnUpdate.setBackground(Color.BLACK);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Serif",Font.BOLD,15));
		btnUpdate.setFocusable(false);
		f.add(btnUpdate);



		f.setLayout(null);
		f.setLocation(200,100);
		f.setSize(1000,500);
		f.setVisible(true);
		f.setResizable(false);
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");

			Statement state = conn.createStatement();

			ResultSet rs = state.executeQuery("SELECT * FROM addstudent");

			while(rs.next())
			{
				String id = Integer.toString(rs.getInt("rollNo"));
				String name = rs.getString("name");
				String fName = rs.getString("fName");
				String age = Integer.toString(rs.getInt("age"));
				String dob = rs.getString("date");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String classX = rs.getString("classX");
				String classXII = rs.getString("classXII");
				String cnic = rs.getString("cnic");
				String department = rs.getString("branch");
				String education = rs.getString("course");

				String tbtdata[] = {id,name,fName,age,dob,address,phone,email,classX,classXII,cnic,department,education};
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(tbtdata);

			}
		}

		catch(ClassNotFoundException cnfe)
		{
			System.out.println("SQL Exception : " +cnfe);
		}

		catch(SQLException sqle)
		{
			System.out.println("SQLException : " +sqle);
		}

		table.addMouseListener(new MouseAdapter()
			{
				public void mouseClicked(MouseEvent me)
				{
					int rowIndex = table.getSelectedRow();

					String rNo = (String)model.getValueAt(rowIndex, 0);
					txt1.setText(rNo);
				}
			});

		btnDelete.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{

					int selection = JOptionPane.showConfirmDialog(null, "Do you want to delete this data", "Conform", JOptionPane.YES_NO_OPTION);

					if(selection == JOptionPane.YES_OPTION)
					{
						try
						{
							Class.forName("com.mysql.jdbc.Driver");

							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");

							Statement state = conn.createStatement();
							
							String id = txt1.getText();

							String query = "DELETE FROM addstudent WHERE rollNo = '"+id+"'";
							state.executeUpdate(query);
							f.setVisible(false);

							new StudentDetail().f.setVisible(true);
						}

						catch(ClassNotFoundException cnfe)
						{
							System.out.println("SQL Exception : " +cnfe);
						}

						catch(SQLException sqle)
						{
							System.out.println("SQLException : " +sqle);
						}
					}
					txt1.setText(null);
				}
			});

		btnAdd.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					new AddStudent();
					f.setVisible(false);
				}
			});

		btnUpdate.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					new UpdateStudents();
					f.setVisible(false);
				}
			});

	}

	public static void main(String arg[])
	{
		new StudentDetail();
	}
}