import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import javax.swing.table.*;

import java.sql.*;

class CheckResult1
{
	JFrame win, win1;
	JLabel lblTitle;
	JTextField txtSearch;
	JButton btnResult;
	JTable table;
	DefaultTableModel model;
	DefaultTableCellRenderer center;
	Border border = BorderFactory.createLineBorder(Color.BLACK);
	Border borderOutLine = BorderFactory.createLineBorder(Color.GRAY);
	String p2,p3;
	JPanel p1;
	JTextArea txtArea;
	JScrollPane pane;

	public CheckResult1()
	{
		win = new JFrame("Check Result");
		win.getContentPane().setBackground(Color.WHITE);

		lblTitle = new JLabel("Check Result");
		lblTitle.setBounds(150,10,300,50);
		lblTitle.setForeground(Color.GREEN);
		lblTitle.setFont(new Font("Serif",Font.BOLD,30));

		txtSearch = new JTextField();
		txtSearch.setBounds(50,80,200,30);
		txtSearch.setForeground(Color.BLACK);
		txtSearch.setFont(new Font("Serif",Font.BOLD,18));
		txtSearch.setHorizontalAlignment(JTextField.CENTER);

		btnResult = new JButton("Result");
		btnResult.setBounds(270,80,150,30);
		btnResult.setForeground(Color.RED);
		btnResult.setBackground(Color.WHITE);
		btnResult.setFont(new Font("Serif",Font.BOLD,20));
		btnResult.setFocusable(false);

		String row[][] = {};

		String column[] = {"Roll No", "Name", "Father's Name", "Age", "DOB", "Addrees", "Phone", "Email", "Class X(%)", "Class XII(%)", "CNIC", "branch", "Course"};

		model = new DefaultTableModel(row,column);

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
		table.getColumnModel().getColumn(8).setCellRenderer(center);
		table.getColumnModel().getColumn(9).setCellRenderer(center);
		table.getColumnModel().getColumn(11).setCellRenderer(center);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(20,130,745,200);
		table.setForeground(Color.BLACK);
		table.getTableHeader().setFont(new Font("Agency FB",Font.BOLD,18));
		table.setRowHeight(30);
		
		win.add(lblTitle);

		win.add(txtSearch);

		win.add(btnResult);

		win.add(pane);


		win.setLayout(null);
		win.setSize(800,450);
		win.setLocationRelativeTo(null);
		win.setResizable(false);
		//win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setVisible(true);

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
					int row = table.getSelectedRow();

					String rNo = (String)model.getValueAt(row, 0);
					txtSearch.setText(rNo);

				}
			});

		btnResult.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					try
					{
						Class.forName("com.mysql.jdbc.Driver");

						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");

						Statement state = conn.createStatement();

						//new Result(txtSearch.getText()).win.setVisible(true);
						faisal();
						win.setVisible(false);
					}

					catch(Exception e){

					}
				}
			});

		/*btnResult.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					new Result().win.setVisible(true);
					win.setVisible(false);
				}
			});
*/
		btnResult.addMouseListener(new MouseAdapter()
			{
				public void mouseEntered(MouseEvent me)
				{
					btnResult.setBackground(Color.BLACK);
					btnResult.setForeground(Color.WHITE);
					btnResult.setBorder(border);
				}
			});

		btnResult.addMouseListener(new MouseAdapter()
			{
				public void mouseExited(MouseEvent me)
				{
					btnResult.setBackground(Color.WHITE);
					btnResult.setForeground(Color.RED);
					btnResult.setBorder(borderOutLine);
				}
			});
	}

	public void faisal()
	{
		win1 = new JFrame("Result");
		win1.getContentPane().setBackground(Color.WHITE);


		JLabel lblTitle2 = new JLabel("");
		lblTitle2.setBounds(80,30,300,30);
		lblTitle2.setFont(new Font("Monotype Corsiva",Font.BOLD,30));

		JLabel lblLine = new JLabel("");
		lblLine.setBounds(30,60,500,10);

		JLabel lblLine1 = new JLabel("");
		lblLine1.setBounds(30,130,500,10);

		JLabel lblLine2 = new JLabel("");
		lblLine2.setBounds(30,340,500,10);

		JLabel lblSubject = new JLabel("");
		lblSubject.setBounds(70,90,500,35);
		lblSubject.setFont(new Font("Monotype Corsiva",Font.BOLD,30));

		JLabel lblMarks = new JLabel("");
		lblMarks.setBounds(300,90,500,30);
		lblMarks.setFont(new Font("Monotype Corsiva",Font.BOLD,30));


		JLabel lblSubject1 = new JLabel("");
		lblSubject1.setBounds(80,150,150,35);
		lblSubject1.setFont(new Font("Monotype Corsiva",Font.PLAIN,25));

		JLabel lblSubject2 = new JLabel("");
		lblSubject2.setBounds(80,190,150,35);
		lblSubject2.setFont(new Font("Monotype Corsiva",Font.PLAIN,25));

		JLabel lblSubject3 = new JLabel("");
		lblSubject3.setBounds(80,230,150,35);
		lblSubject3.setFont(new Font("Monotype Corsiva",Font.PLAIN,25));

		JLabel lblSubject4 = new JLabel("");
		lblSubject4.setBounds(80,270,150,35);
		lblSubject4.setFont(new Font("Monotype Corsiva",Font.PLAIN,25));

		JLabel lblSubject5 = new JLabel("");
		lblSubject5.setBounds(80,310,150,35);
		lblSubject5.setFont(new Font("Monotype Corsiva",Font.PLAIN,25));

		JLabel lblMarks1 = new JLabel("");
		lblMarks1.setBounds(320,150,100,30);
		lblMarks1.setFont(new Font("Agency FB",Font.PLAIN,25));

		JLabel lblMarks2 = new JLabel("");
		lblMarks2.setBounds(320,190,100,30);
		lblMarks2.setFont(new Font("Agency FB",Font.PLAIN,25));

		JLabel lblMarks3 = new JLabel("");
		lblMarks3.setBounds(320,230,100,30);
		lblMarks3.setFont(new Font("Agency FB",Font.PLAIN,25));

		JLabel lblMarks4 = new JLabel("");
		lblMarks4.setBounds(320,270,100,30);
		lblMarks4.setFont(new Font("Agency FB",Font.PLAIN,25));

		JLabel lblMarks5 = new JLabel("");
		lblMarks5.setBounds(320,310,100,30);
		lblMarks5.setFont(new Font("Agency FB",Font.PLAIN,25));

		JLabel lblTotal = new JLabel("");
		lblTotal.setBounds(80,350,150,30);
		lblTotal.setFont(new Font("Agency FB",Font.BOLD,25));

		JLabel lblTotalMarks = new JLabel("");
		lblTotalMarks.setBounds(320,350,100,30);
		lblTotalMarks.setFont(new Font("Agency FB",Font.BOLD,23));

		JLabel lblTotalMarks1 = new JLabel("Total Marks      :   500");
		lblTotalMarks1.setBounds(30,400,150,30);
		lblTotalMarks1.setFont(new Font("Agency FB",Font.BOLD,20));

		JLabel lblTotalMarks2 = new JLabel("");
		lblTotalMarks2.setBounds(30,425,150,30);
		lblTotalMarks2.setFont(new Font("Agency FB",Font.BOLD,20));

		JLabel lblpercentage = new JLabel("");
		lblpercentage.setBounds(30,450,150,30);
		lblpercentage.setFont(new Font("Agency FB",Font.BOLD,20));

		JLabel lblGrade = new JLabel("");
		lblGrade.setBounds(30,475,120,30);
		lblGrade.setFont(new Font("Agency FB",Font.BOLD,20));

		JLabel lblGrade1 = new JLabel("A1");
		lblGrade1.setBounds(150,475,100,30);
		lblGrade1.setFont(new Font("Agency FB",Font.BOLD,20));
		lblGrade1.setVisible(false);

		JLabel lblGrade2 = new JLabel("A");
		lblGrade2.setBounds(150,475,100,30);
		lblGrade2.setFont(new Font("Agency FB",Font.BOLD,20));
		lblGrade2.setVisible(false);

		JLabel lblGrade3 = new JLabel("B");
		lblGrade3.setBounds(150,475,100,30);
		lblGrade3.setFont(new Font("Agency FB",Font.BOLD,20));
		lblGrade3.setVisible(false);

		JLabel lblGrade4 = new JLabel("C");
		lblGrade4.setBounds(150,475,100,30);
		lblGrade4.setFont(new Font("Agency FB",Font.BOLD,20));
		lblGrade4.setVisible(false);

		JLabel lblGrade5 = new JLabel("Fail");
		lblGrade5.setBounds(150,475,100,30);
		lblGrade5.setFont(new Font("Agency FB",Font.BOLD,20));
		lblGrade5.setVisible(false);

		win1.add(lblTitle2);
		
		win1.add(lblSubject);
		win1.add(lblSubject1);
		win1.add(lblSubject2);
		win1.add(lblSubject3);
		win1.add(lblSubject4);
		win1.add(lblSubject5);
		
		win1.add(lblMarks);
		win1.add(lblMarks1);
		win1.add(lblMarks2);
		win1.add(lblMarks3);
		win1.add(lblMarks4);
		win1.add(lblMarks5);

		win1.add(lblTotal);
		win1.add(lblTotalMarks);
		win1.add(lblTotalMarks1);
		win1.add(lblTotalMarks2);
		win1.add(lblpercentage);
		win1.add(lblGrade);
		win1.add(lblGrade1);
		win1.add(lblGrade2);
		win1.add(lblGrade3);
		win1.add(lblGrade4);
		win1.add(lblGrade5);
		
		win1.add(lblLine);
		win1.add(lblLine1);
		win1.add(lblLine2);

		win1.setLayout(null);
		win1.setSize(500,600);
		win1.setLocationRelativeTo(null);
		//win1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		win.setLayout(new BorderLayout());
		win1.setResizable(false);
		win1.setVisible(true);
		
	

		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");

			Statement state = conn.createStatement();

			lblTitle2.setText("\tResult Of Examination");
			lblLine.setText("--------------------------------------------------------------------------------------------------------");
			lblSubject.setText("Subjects");
			lblMarks.setText("Marks"); 
			lblLine1.setText("--------------------------------------------------------------------------------------------------------");
			lblLine2.setText("--------------------------------------------------------------------------------------------------------");

			p2 = txtSearch.getText().toString();

			ResultSet rs = state.executeQuery("SELECT * FROM subject WHERE rollNo = '"+p2+"'");

			while(rs.next())
			{
				lblSubject1.setText(rs.getString("Subject1"));
				lblSubject2.setText(rs.getString("Subject2"));
				lblSubject3.setText(rs.getString("Subject3"));
				lblSubject4.setText(rs.getString("Subject4"));
				lblSubject5.setText(rs.getString("Subject5"));
				
			}

			p3 = txtSearch.getText().toString();

			ResultSet rss = state.executeQuery("SELECT * FROM marks WHERE rollNo = '"+p3+"' ");

			while(rss.next())
			{
				int marks1 = Integer.parseInt(rss.getString("mark1"));
				int marks2 = Integer.parseInt(rss.getString("mark2"));
				int marks3 = Integer.parseInt(rss.getString("mark3"));
				int marks4 = Integer.parseInt(rss.getString("mark4"));
				int marks5 = Integer.parseInt(rss.getString("mark5"));

				int total = marks1+marks2+marks3+marks4+marks5;

				float percentage = (total*100)/500;

				//float percentage1 = percentage;

				if(percentage >= 80 && percentage <= 100)
				{
					lblGrade1.setVisible(true);
				}

				else if(percentage >= 70 && percentage < 80)
				{
					lblGrade2.setVisible(true);
				}

				else if(percentage >= 60 && percentage < 70)
				{
					lblGrade3.setVisible(true);
				}

				else if(percentage >= 40 && percentage < 60)
				{
					lblGrade4.setVisible(true);
				}

				else if(percentage > 00 && percentage < 40)
				{
					lblGrade5.setVisible(true);
				}
				

				lblMarks1.setText(rss.getString("mark1"));
				lblMarks2.setText(rss.getString("mark2"));
				lblMarks3.setText(rss.getString("mark3"));
				lblMarks4.setText(rss.getString("mark4"));
				lblMarks5.setText(rss.getString("mark5"));
				
				lblTotal.setText("Total Marks   :   ");
				lblTotalMarks.setText(""+total);
				lblTotalMarks2.setText("Obtained Marks :   " +total);
				lblpercentage.setText("Percentage       :   " +percentage);
				lblGrade.setText("Grade               :    ");
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
		new CheckResult1();
	}
}