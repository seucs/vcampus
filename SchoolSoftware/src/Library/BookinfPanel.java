package Library;


import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.util.*;
import java.lang.*;
public class BookinfPanel extends JPanel{
	
	JButton nextpage=new JButton("下一页");
	JButton previouspage=new JButton("上一页");
	JLabel changeto=new JLabel("跳转至");
	JLabel page=new JLabel("页");
	JButton confirm=new JButton("确定");
	JTextField pageinput= new JTextField();
	String[][] bookData = new String[30][8];
	String[] columnNames = {"图书编号","图书名称","作者","出版社","总本数","可借本数","备注","所在书架"};
	String[] columnnames={"预约借阅"};
	String[][] nullData = new String[1][1];
	
	JTable BOOKINF = new JTable(bookData, columnNames);
	JTable YUYUE = new JTable(nullData, columnnames);
	JScrollPane INFBOOK=new JScrollPane(BOOKINF);
	JScrollPane yuyue=new JScrollPane(YUYUE);
	ArrayList<JButton> subscribe=new ArrayList();
	int pagenumber=0;
	int maxpage=0;
	JLabel currentpage=new JLabel(); 
	ArrayList<String[][]> ALLData=new ArrayList();
	
	public BookinfPanel(){
		this.setLayout(null);
		this.setSize(900, 700);
		BOOKINF.setEnabled(false);
		nullData[0][0]=null;
		String[][] testData1=new String[30][8];
		String[][] testData2=new String[30][8];
		for(int i=0;i<=29;i++) for(int j=0;j<=7;j++) testData1[i][j]="4";
		ALLData.add(testData1);
		maxpage++;
		for(int i=0;i<=29;i++) for(int j=0;j<=7;j++) testData2[i][j]="2";
		ALLData.add(testData2);
		maxpage++;
		
		for(int i=0;i<=29;i++) for(int j=0;j<=7;j++) bookData[i][j]=ALLData.get(0)[i][j];
		currentpage.setText(pagenumber+1+"/"+maxpage+"页");
		INFBOOK.setBounds(0,0,800,503);
		yuyue.setBounds(797,0,106,22);
		previouspage.setBounds(279,510,80,20);
		nextpage.setBounds(369,510,80,20);
		page.setBounds(534,510,80,20);
		pageinput.setBounds(499,511,32,20);
		changeto.setBounds(459,510,80,20);
		confirm.setBounds(554,510,60,20);
		currentpage.setBounds(799,510,60,20);
		this.add(currentpage);
		this.add(INFBOOK);
		this.add(yuyue);
		this.add(nextpage);
		this.add(previouspage);
		this.add(page);
		this.add(pageinput);
		this.add(changeto);
		this.add(confirm);
		
		for( int i=0;i<=29;i++)
		{
			if(bookData[i][5]!="0"){
				JButton temp = new JButton("预约借阅");			
				subscribe.add(temp);			
				subscribe.get(i).setBounds(800, 22+16*i, 100,15);			
				this.add(subscribe.get(i));			
				subscribe.get(i).setVisible(false);
				subscribe.get(i).setVisible(true);			
				subscribe.get(i).setBorderPainted(false);		
				returnNumber(i);
				final int j=returnNumber(i);
				subscribe.get(i).addActionListener(new java.awt.event.ActionListener() {

					public void actionPerformed(java.awt.event.ActionEvent e) {
						if(bookData[j][5]!="0"){

						JOptionPane.showMessageDialog(null, "预约成功", "提示信息",JOptionPane.CLOSED_OPTION);
						INFBOOK.setVisible(false); INFBOOK.setVisible(true);
						int temp=Integer.parseInt(bookData[j][5]);
						temp=temp-1;
						if( temp==0) {subscribe.get(j).setText("不可借");	subscribe.get(j).setEnabled(false);}
						bookData[j][5]=String.valueOf(temp);
						ALLData.get(pagenumber)[j][5]=bookData[j][5];
							
						}
			
					}

				});
			
				
			}
			
			
		
			else{
				JButton temp = new JButton("不可借");			
				subscribe.add(temp);			
				subscribe.get(i).setBounds(800, 22+16*i, 90,15);			
				this.add(subscribe.get(i));			
				subscribe.get(i).setVisible(false);
				subscribe.get(i).setVisible(true);			
				subscribe.get(i).setBorder(null);
				subscribe.get(i).setEnabled(false);
				}
				

			}

		nextpage.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				pageplus();
	
			}
		});
		previouspage.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				pageminus();
	
			}
		});
		confirm.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				pageto();
	
			}
		});




}


	int returnNumber(int i){
		return i;
		
	}
public	void pageplus(){
		if(pagenumber<maxpage-1)
		{pagenumber++;
		

		for(int i=0;i<=29;i++) for(int j=0;j<=7;j++) bookData[i][j]=ALLData.get(pagenumber)[i][j];
		BOOKINF.setVisible(false);BOOKINF.setVisible(true);
		
		currentpage.setText(pagenumber+1+"/"+maxpage+"页");
//		currentpage.setVisible(false);currentpage.setVisible(true);
	}}
public	void pageminus(){
		if(pagenumber>0)
		{pagenumber--;
		for(int i=0;i<=29;i++) for(int j=0;j<=7;j++) bookData[i][j]=ALLData.get(pagenumber)[i][j];
		BOOKINF.setVisible(false);BOOKINF.setVisible(true);
		currentpage.setText(pagenumber+1+"/"+maxpage+"页");
	}}
public	void pageto(){
		pagenumber=Integer.parseInt(pageinput.getText())-1;
		if(pagenumber>=0&&pagenumber<maxpage)
		{for(int i=0;i<=29;i++) for(int j=0;j<=7;j++) bookData[i][j]=ALLData.get(pagenumber)[i][j];
		BOOKINF.setVisible(false);BOOKINF.setVisible(true);
		currentpage.setText(pagenumber+1+"/"+maxpage+"页");
		}
		
	}
}

