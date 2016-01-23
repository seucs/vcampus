package AdmOffice;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class selframe extends JFrame{
	String colname[]={"课程编号","课程名","任课教师","上课时间","上课地点"};
	String[][] courseData=new String[30][5];
	JTable table=new JTable(courseData,colname);
	String [][] nullData=new String[0][0];
	String [] sele={"选择"};
	JTable NULLtable=new JTable(nullData,sele);
	JScrollPane jsp=new JScrollPane(table);
	JScrollPane JSP=new JScrollPane(NULLtable);
	JTable nulltable=new JTable(nullData,sele);
	ArrayList<JButton> selbutton=new ArrayList();
	selcourse selpanel=new selcourse();
	int selnumber;
	final int flag=1;
	public selframe() {
		this.setSize(600, 500);
		this.add(jsp);
		this.setLayout(null);
		this.add(JSP);
		
		JSP.setBounds(497,0,106,22);
		jsp.setBounds(0, 0, 500, 503);
		
		table.setEnabled(false);
		for(int i=0;i<=10;i++)for(int j=0;j<=4;j++)courseData[i][j]=null;
		for(int i=0;i<=getDatasize();i++)
		{
			JButton temp=new JButton("选择");
			selbutton.add(temp);
			this.add(selbutton.get(i));
			selbutton.get(i).setBorderPainted(false);	
			selbutton.get(i).setBounds(500, 22+16*i, 103,15);
			final int j=returnNumber(i);

			selbutton.get(i).addActionListener(new java.awt.event.ActionListener() {

				public void actionPerformed(java.awt.event.ActionEvent e) {
					
				}

			});
		
			
		}
		
		
		this.setVisible(true);
		// TODO 自动生成的构造函数存根
	}
	int getDatasize(){
		int size=0;
		for(int i=0;i<=28;i++)
		{	if(courseData[i+1][0]==null&&courseData[i][0]!=null)
		{	 size=i;}
		}
		return size+1;

		
	}
	int returnNumber(int i){
		return i;

}
	

}
