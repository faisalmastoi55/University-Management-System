import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class UniversitySystem implements ActionListener
{
	JFrame f;
	JLabel lbl1;
	ImageIcon image;
	JMenuBar mb;
	JMenu master, detail, attendence, attendenceDetail, exams, update, fees, utility, about, exit;
	JMenuItem item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14;
	JMenuItem item15, item16, item17, item18, item19;

	UniversitySystem()
	{
		f = new JFrame("University Management System");

		image = new ImageIcon("E:\\JAVA_Projects\\University_Management_System\\img\\University2.jpg");
		lbl1 = new JLabel(image);
		f.add(lbl1);

		mb = new JMenuBar();
		
		master = new JMenu("Master");
		master.setForeground(Color.BLACK);
		master.setMnemonic(KeyEvent.VK_M);
		
		detail = new JMenu("Details");
		detail.setForeground(Color.BLACK);
		detail.setMnemonic(KeyEvent.VK_D);

		attendence = new JMenu("Attendence");
		attendence.setForeground(Color.BLACK);
		attendence.setMnemonic(KeyEvent.VK_A);

		attendenceDetail = new JMenu("Attendence Detail");
		attendenceDetail.setForeground(Color.BLACK);
		attendenceDetail.setMnemonic(KeyEvent.VK_T);

		exams = new JMenu("Examinations");
		exams.setForeground(Color.BLACK);
		exams.setMnemonic(KeyEvent.VK_E);

		update = new JMenu("Update Details");
		update.setForeground(Color.BLACK);
		update.setMnemonic(KeyEvent.VK_U);

		fees = new JMenu("Fees Detail");
		fees.setForeground(Color.BLACK);
		fees.setMnemonic(KeyEvent.VK_F);

		utility = new JMenu("Utility");
		utility.setForeground(Color.BLACK);
		utility.setMnemonic(KeyEvent.VK_I);

		about = new JMenu("About");
		about.setForeground(Color.BLACK);
		about.setMnemonic(KeyEvent.VK_B);

		exit = new JMenu("Exit");
		exit.setForeground(Color.BLACK);
		exit.setMnemonic(KeyEvent.VK_X);

		item1 = new JMenuItem("New Faculty");
		item1.setFont(new Font("monospaced",Font.BOLD,16));
		
		item2 = new JMenuItem("New Student Admission");
		item2.setFont(new Font("monospaced",Font.BOLD,16));

		item3 = new JMenuItem("Teacher Details");
		item3.setFont(new Font("monospaced",Font.BOLD,16));

		item4 = new JMenuItem("Student Details");
		item4.setFont(new Font("monospaced",Font.BOLD,16));

		item5 = new JMenuItem("Student Attendence");
		item5.setFont(new Font("monospaced",Font.BOLD,16));

		item6 = new JMenuItem("Teacher Attendence");
		item6.setFont(new Font("monospaced",Font.BOLD,16));

		item7 = new JMenuItem("Student Detail");
		item7.setFont(new Font("monospaced",Font.BOLD,16));

		item8 = new JMenuItem("Teacher Detail");
		item8.setFont(new Font("monospaced",Font.BOLD,16));

		item9 = new JMenuItem("Examination Details");
		item9.setFont(new Font("monospaced",Font.BOLD,16));

		item10 = new JMenuItem("Enter Marks");
		item10.setFont(new Font("monospaced",Font.BOLD,16));

		item11 = new JMenuItem("Update Students");
		item11.setFont(new Font("monospaced",Font.BOLD,16));

		item12 = new JMenuItem("Update Teachers");
		item12.setFont(new Font("monospaced",Font.BOLD,16));

		item13 = new JMenuItem("Fee Details");
		item13.setFont(new Font("monospaced",Font.BOLD,16));

		item14 = new JMenuItem("Student Fee Form");
		item14.setFont(new Font("monospaced",Font.BOLD,16));

		item15 = new JMenuItem("NotePad");
		item15.setFont(new Font("monospaced",Font.BOLD,16));

		item16 = new JMenuItem("Calculator");
		item16.setFont(new Font("monospaced",Font.BOLD,16));

		item17 = new JMenuItem("Web Browser");
		item17.setFont(new Font("monospaced",Font.BOLD,16));

		item18 = new JMenuItem("About Us");
		item18.setFont(new Font("monospaced",Font.BOLD,16));

		item19 = new JMenuItem("EXIT");
		item19.setFont(new Font("monospaced",Font.BOLD,16));

		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
		item5.addActionListener(this);
		item6.addActionListener(this);
		item7.addActionListener(this);
		item8.addActionListener(this);
		item9.addActionListener(this);
		item10.addActionListener(this);
		item11.addActionListener(this);
		item12.addActionListener(this);
		item13.addActionListener(this);
		item14.addActionListener(this);
		item15.addActionListener(this);
		item16.addActionListener(this);
		item17.addActionListener(this);
		item18.addActionListener(this);
		item19.addActionListener(this);


		master.add(item1);
		master.add(item2);

		detail.add(item3);
		detail.add(item4);
		
		attendence.add(item5);
		attendence.add(item6);
		
		attendenceDetail.add(item7);
		attendenceDetail.add(item8);
		
		exams.add(item9);
		exams.add(item10);
		
		update.add(item11);
		update.add(item12);
		
		fees.add(item13);
		fees.add(item14);

		utility.add(item15);
		utility.add(item16);
		utility.add(item17);

		about.add(item18);

		exit.add(item19);

		mb.add(master);
		mb.add(detail);
		mb.add(attendence);
		mb.add(attendenceDetail);
		mb.add(exams);
		mb.add(update);
		mb.add(fees);
		mb.add(utility);
		mb.add(about);
		mb.add(exit);

		f.setJMenuBar(mb);
		//f.setJMenuBar(mb);
		//f.setJMenuBar(mb);
		//f.setJMenuBar(mb);
		//f.setJMenuBar(mb);
		//f.setJMenuBar(mb);
		//f.setJMenuBar(mb);
		//f.setJMenuBar(mb);
		
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String msg = ae.getActionCommand();

		if(msg.equals("New Faculty"))
		{
			new AddTeacher().f.setVisible(true);

		}

		else if(msg.equals("New Student Admission"))
		{
			new AddStudent().f.setVisible(true);
		}

		else if(msg.equals("Teacher Details"))
		{
			new TeacherDetail().f.setVisible(true);
		}

		else if(msg.equals("Student Details"))
		{
			new StudentDetail().f.setVisible(true);
		}

		else if(msg.equals("Student Attendence"))
		{
			new AddAttendence().f.setVisible(true);

		}

		else if(msg.equals("Teacher Attendence"))
		{
			new AddTeacherAttendence().f.setVisible(true);
		}

		else if(msg.equals("Student Detail"))
		{
			new SAttandenceDetail().win.setVisible(true);
		}

		else if(msg.equals("Teacher Detail"))
		{
			new TAttandenceDetail().win.setVisible(true);
		}

		else if(msg.equals("Enter Marks"))
		{
			new StudentMarkSheet().win.setVisible(true);
		}

		else if(msg.equals("Examination Details"))
		{
			new CheckResult1().win.setVisible(true);
		}

		else if(msg.equals("Update Students"))
		{
			new UpdateStudents().f.setVisible(true);
		}

		else if(msg.equals("Update Teachers"))
		{
			new UpdateTeachers().f.setVisible(true);
		}

		else if(msg.equals("Fee Details"))
		{
			new FeeDetail().win.setVisible(true);
		}

		else if(msg.equals("Student Fee Form"))
		{
			new StudentFees().win.setVisible(true);
		}

		else if(msg.equals("NotePad"))
		{
			try{
				Runtime.getRuntime().exec("notepad.exe");
			}
			catch(Exception e)
			{

			}
		}

		else if(msg.equals("Calculator"))
		{
			try{
				Runtime.getRuntime().exec("calc.exe");
			}
			catch(Exception e)
			{

			}
		}

		else if(msg.equals("Web Browser"))
		{
			try{
				Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\Chrome.exe");
			}
			catch(Exception e)
			{

			}
		}

		else if(msg.equals("EXIT"))
		{
			System.exit(0);
		}

		else if(msg.equals("About Us"))
		{
			new UniversityInformation().win.setVisible(true);
		}

	}

	public static void main(String arg[])
	{
		new UniversitySystem();
	}
	
}