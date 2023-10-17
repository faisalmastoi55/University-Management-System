import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import javax.swing.table.*;

import java.sql.*;

class FeeDetail
{
	JFrame win;
	JTable table;
	DefaultTableModel model;
	DefaultTableCellRenderer center;
	JScrollPane pane;

	public FeeDetail()
	{
		win = new JFrame("Fee Detail");

		win.getContentPane().setBackground(Color.WHITE);

		String row[][] = {};

		String column[] = {"Roll No", "Name", "Father's Name", "Course", "Branch", "Semester", "Total Pay", "Date"};

		model = new DefaultTableModel(row, column);

		table = new JTable(model)
		{
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};

		center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(center);
		table.getColumnModel().getColumn(3).setCellRenderer(center);
		table.getColumnModel().getColumn(5).setCellRenderer(center);
		table.getColumnModel().getColumn(6).setCellRenderer(center);

		pane = new JScrollPane(table);
		table.setForeground(Color.BLACK);
		table.getTableHeader().setFont(new Font("Agency FB",Font.BOLD,18));
		table.setRowHeight(30);
		win.add(pane);

		
		win.setSize(800,400);
		win.setLocationRelativeTo(null);
		win.setResizable(false);
		win.setVisible(true);
		//win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");

			Statement state = conn.createStatement();

			ResultSet rs = state.executeQuery("SELECT * FROM feedetail");

			while(rs.next())
			{
				String rollNo = Integer.toString(rs.getInt("rollNo"));
				String name = rs.getString("name");
				String fName = rs.getString("fName");
				String course = rs.getString("course");
				String branch = rs.getString("branch");
				String semester = rs.getString("semester");
				String totalPay = rs.getString("totalPay");
				String date = rs.getString("date");

				String data[] = {rollNo,name,fName,course,branch,semester,totalPay,date};
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(data);
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

	public static void main(String[] args) {
		new FeeDetail();
	}
}