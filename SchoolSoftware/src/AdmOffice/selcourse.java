package AdmOffice;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class selcourse extends JPanel{
	String colname[]={"课程名","任课教师","上课时间","上课地点"};
	String [][] courseData=new String[35][4];
	String [][] nullData=new String[0][0];
	String [] sele={"选课"};
	//DefaultTableModel tableModel=new DefaultTableModel(courseData,colname);
	JTable table=new JTable(courseData,colname);
	JTable NULLtable=new JTable(nullData,sele);
	JScrollPane jsp=new JScrollPane(table);
	JScrollPane JSP=new JScrollPane(NULLtable);
	JTable nulltable=new JTable(nullData,sele);
	ArrayList<JButton> selbutton=new ArrayList();
//	sellframe selljf=new sellframe();
	final int flag=0;
	public selcourse() {
		this.add(jsp);
		this.setLayout(null);
		this.add(JSP);
		JSP.setBounds(797,0,106,22);
		jsp.setBounds(0, 0, 800, 650);
		
		table.setEnabled(false);
		//for(int i=0;i<=20;i++)for(int j=0;j<=3;j++)courseData[i][j]="0";
		Course test1=new Course("高等数学");
		test1.getcourse(courseData, 0, flag);

//		for (int i=0; i<=3;i++)courseData[25][i]="1";
//		course test1=new course(courseData, 25, flag);
//		course test2=new course(courseData,25,flag);
//		test2.getcourse(courseData, 2, flag);
		
		
		for(int i=0;i<getDatasize();i++)
		{
			JButton temp=new JButton("选课");
			selbutton.add(temp);
			this.add(selbutton.get(i));
			selbutton.get(i).setBorderPainted(false);	
			selbutton.get(i).setBounds(800, 22+16*i, 103,15);
			final int j=returnNumber(i);

			selbutton.get(i).addActionListener(new java.awt.event.ActionListener() {

				public void actionPerformed(java.awt.event.ActionEvent e) {
				sel(j);
				}

			});
		
			
		}
		
		// TODO 自动生成的构造函数存根
	}
	int getDatasize(){
		int size=0;
		for(int i=0;i<=33;i++)
		{	if(courseData[i+1][0]==null&&courseData[i][0]!=null)
		{	 size=i;}
		}
		return size+1;

		
	}
	int returnNumber(int i){
		return i;

}
	void sel(int i){
		selframe jf =new selframe();
		jf.selpanel=this;
		jf.selnumber=i;
		Course test2=new Course("001","高等数学","张三","周五3-4节","教3-101","60","52");
		Course test3=new Course("002","高等数学","李四","周五3-4节","教3-103","60","43");
		test2.getcourse(jf.courseData, 0, jf.flag);
		test3.getcourse(jf.courseData, 1, jf.flag);
	}
	
	}
