import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

import java.sql.*;

class SAttandenceDetail
{
	JFrame win;
	JTable table;
	DefaultTableModel model;
	DefaultTableCellRenderer center;
	JScrollPane pane;

	public SAttandenceDetail()
	{
		win = new JFrame("Student Attandence Detail");

		win.getContentPane().setBackground(Color.WHITE);

		String row[][] = {};

		String column[] = {"Roll No", "Date", "Attandence"};

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
		table.getColumnModel().getColumn(1).setCellRenderer(center);
		table.getColumnModel().getColumn(2).setCellRenderer(center);

		pane = new JScrollPane(table);
		table.setForeground(Color.BLACK);
		table.getTableHeader().setFont(new Font("Agency FB",Font.BOLD,18));
		table.setRowHeight(30);
		win.add(pane);
		
		win.setSize(450,400);
		win.setLocationRelativeTo(null);
		win.setResizable(false);
		win.setVisible(true);

		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");

			Statement state = conn.createStatement();

			ResultSet rs = state.executeQuery("SELECT * FROM studentattendance");

			while(rs.next())
			{
				String roll = Integer.toString(rs.getInt("rollNo"));
				String date = rs.getString("date");
				String attendance = rs.getString("attendance");

				String data[] = {roll,date,attendance};
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(data);
			}
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

	public static void main(String[] args) {
		new SAttandenceDetail();
	}
	
}