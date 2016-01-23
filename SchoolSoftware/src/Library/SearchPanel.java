package Library;


import javax.swing.*;

import Connect.Client;

import java.awt.*;
import java.util.*;
import java.lang.*;
public class SearchPanel extends JPanel{
	
//	JButton bookinf=new JButton("查询图书信息");
//	JButton personalinf=new JButton("查询个人记录");
//	JButton searchbook=new JButton("搜索图书");
	JButton nextpage=new JButton("下一页");
	JButton previouspage=new JButton("上一页");
	JButton back=new JButton("返回搜索");
	JLabel changeto=new JLabel("跳转至");
	JLabel page=new JLabel("页");
	JButton confirm=new JButton("确定");
	JLabel searchname=new JLabel("书名");
	JTextField nameinput= new JTextField();
	JTextField authorinput= new JTextField();
	JLabel searchauthor=new JLabel("作者");
	JButton search =new JButton("搜索");
	JLabel message=new JLabel("请输入要搜索的书名或作者");
	JTextField pageinput= new JTextField();
//	JLabel welcome=new JLabel("欢迎进入图书馆系统！");
//	JLabel select= new JLabel("请选择上方功能。");
//	String[][] bookData = new String[30][9];
	String[][] searchData= new String[30][8];
//	String[][] personalData=new String[30][7];
//
	String[] columnNames = {"图书编号","图书名称","作者","出版社","总本数","可借本数","备注","所在书架"};
	String[] columnnames={"预约借阅","管理图书"};
	String[][] nullData = new String[1][2];
	JTable BOOKSEARCH = new JTable(searchData, columnNames);
	JTable YUYUE = new JTable(nullData, columnnames);
	JScrollPane SEARCHBOOK=new JScrollPane(BOOKSEARCH);
	JScrollPane yuyue=new JScrollPane(YUYUE);
	ArrayList<JButton> subscribe=new ArrayList();
	ArrayList<JButton> guanli=new ArrayList();
	int pagenumber=0;
	int maxpage=0;
	JLabel currentpage=new JLabel(); 
	ArrayList<String[][]> ALLData=new ArrayList();
	int admin=1;
	libraryadmin libadm;
	Client mClient;
	
	public SearchPanel(Client client){
		mClient = client;
		this.setLayout(null);
		this.setSize(900, 700);
		BOOKSEARCH.setEnabled(false);
		nullData[0][0]=null;
		nullData[0][1]=null;
		String[][] testData1=new String[30][8];
//		String[][] testData2=new String[30][8];
//		for(int i=0;i<=29;i++) for(int j=0;j<=7;j++) testData1[i][j]="4";
		ALLData.add(testData1);
		maxpage++;
//		for(int i=0;i<=29;i++) for(int j=0;j<=7;j++) testData2[i][j]="2";
//		ALLData.add(testData2);
//		maxpage++;
//		for(int i=0;i<=7;i++)ALLData.get(0)[0][i]="w";
//		book book1=new book(ALLData.get(0),0);
//		book book2=new book("001", "w", "s", "2", "3", "3", "sl", "b-1");
//		book2.getbook(ALLData.get(0),2);
		
		for(int i=0;i<=29;i++) for(int j=0;j<=7;j++) searchData[i][j]=ALLData.get(0)[i][j];
		this.add(searchname);
		this.add(searchauthor);
		this.add(authorinput);
		this.add(nameinput);
		this.add(search);
		this.add(back);
		this.add(message);
		currentpage.setText(pagenumber+1+"/"+maxpage+"页");
		message.setFont(new Font("微软雅黑",Font.ROMAN_BASELINE,18));
		message.setBounds(300,100,500,200);
		searchname.setBounds(300,230,100,20);
		searchauthor.setBounds(300,270,100,20);
		authorinput.setBounds(350,272,200,20);
		nameinput.setBounds(350,232,200,20);
		search.setBounds(300,300,250,25);
		yuyue.setBounds(797-80*admin,0,106+80*admin,22);
		SEARCHBOOK.setBounds(0,0,800-80*admin,503);

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
		back.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {

				back();
	
		}

		});

		
		search.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				mClient.sendBookQuery(nameinput.getText());
				//sousuo();
	
		}

		});
	
		
	}

		
	
	void back(){
		this.removeAll();
		this.setVisible(false);
		this.setVisible(true);
		this.add(searchname);
		this.add(searchauthor);
		this.add(authorinput);
		this.add(nameinput);
		this.add(search);
		this.add(message);
		message.setFont(new Font("微软雅黑",Font.ROMAN_BASELINE,18));
		message.setBounds(300,150,500,200);
		searchname.setBounds(300,280,100,20);
		searchauthor.setBounds(300,320,100,20);
		authorinput.setBounds(350,322,200,20);
		nameinput.setBounds(350,282,200,20);
		search.setBounds(300,350,250,25);
	//	back.setBounds(430,350,120,25);
		
	}

void sousuo(){
	//String inputname =nameinput.getText();
	//String inputauthor =authorinput.getText();
	for(int i=0;i<=29;i++) for(int j=0;j<=7;j++) ;
	if(  nameinput.getText().isEmpty()&&authorinput.getText().isEmpty()	);
	
	else 
	{
		
	this.removeAll();
	this.add(SEARCHBOOK);
	this.add(nextpage);
	this.add(previouspage);
	this.add(page);
	this.add(pageinput);
	this.add(back);
	this.add(changeto);
	this.add(confirm);
	this.add(yuyue);
	nextpage.setVisible(false);		nextpage.setVisible(true);
	page.setVisible(false);		page.setVisible(true);
	previouspage.setVisible(false);		previouspage.setVisible(true);
	pageinput.setVisible(false);		pageinput.setVisible(true);
	confirm.setVisible(false);		confirm.setVisible(true);
	changeto.setVisible(false);		changeto.setVisible(true);
	for( int i=0;i<=29;i++)
	{
		if(searchData[i][5]!="0"){
			JButton temp = new JButton("预约");	
			subscribe.add(temp);			
			subscribe.get(i).setBounds(800-80*admin, 22+16*i, 101-admin*20,15);			
			this.add(subscribe.get(i));			
			subscribe.get(i).setVisible(false);
			subscribe.get(i).setVisible(true);			
			subscribe.get(i).setBorderPainted(false);		
			returnNumber(i);
			JButton temp1 = new JButton("管理");	
			guanli.add(temp1);			
			guanli.get(i).setBounds(802, 22+16*i, 101,15);			
			this.add(guanli.get(i));			
			guanli.get(i).setVisible(false);
			guanli.get(i).setVisible(true);			
			guanli.get(i).setBorderPainted(false);		
			final int j=returnNumber(i);
			subscribe.get(i).addActionListener(new java.awt.event.ActionListener() {

				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(searchData[j][5]!="0"){

					JOptionPane.showMessageDialog(null, "预约成功", "提示信息",JOptionPane.CLOSED_OPTION);
					SEARCHBOOK.setVisible(false); SEARCHBOOK.setVisible(true);
					int temp=Integer.parseInt(searchData[j][5]);
					temp=temp-1;
					if( temp==0) {subscribe.get(j).setText("不可借");	subscribe.get(j).setEnabled(false);}
					searchData[j][5]=String.valueOf(temp);
					ALLData.get(pagenumber)[j][5]=searchData[j][5];
					ALLData.get(pagenumber)[j][5]=searchData[j][5];
						
					}
		
				}

			});

			guanli.get(i).addActionListener(new java.awt.event.ActionListener() {

				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					guanli(j);
					
						
					
		
				}

			});
		
		
			
		}
		
		
	
		else{
			JButton temp = new JButton("不可借");			
			subscribe.add(temp);			
			subscribe.get(i).setBounds(800-80*admin, 22+16*i, 101-admin*20,15);			
			this.add(subscribe.get(i));			
			subscribe.get(i).setVisible(false);
			subscribe.get(i).setVisible(true);			
			subscribe.get(i).setBorder(null);
			subscribe.get(i).setEnabled(false);
			}
			

		}
	currentpage.setBounds(799,510,60,20);
	this.add(currentpage);
	back.setBounds(589,510,86,20);
	previouspage.setBounds(224,510,80,20);
	nextpage.setBounds(314,510,80,20);
	page.setBounds(479,510,80,20);
	pageinput.setBounds(444,511,32,20);
	changeto.setBounds(404,510,80,20);
	confirm.setBounds(499,510,80,20);
	}
	
	
}
public void guanli(int x) 
{
	libadm = new libraryadmin(); 
	libadm.setsearchpanel(this);
	libadm.setVisible(true);
	libadm.tablenumber=x;
	libadm.ABLETOBORROW.setText(ALLData.get(pagenumber)[x][5]);
	libadm.BOOKNAME.setText(ALLData.get(pagenumber)[x][1]);
	libadm.BOOKNUMBER.setText(ALLData.get(pagenumber)[x][0]);
	libadm.TOTAL.setText(ALLData.get(pagenumber)[x][4]);
	
	
	
	
}


int returnNumber(int i){
	return i;
	
}
void pageplus(){
	if(pagenumber<maxpage-1)
	{pagenumber++;
	for(int i=0;i<=29;i++) {
		for(int j=0;j<=7;j++) {searchData[i][j]=ALLData.get(pagenumber)[i][j];}
		int temp=Integer.parseInt(searchData[i][5]);
		if( temp!=0){subscribe.get(i).setText("预约");	subscribe.get(i).setEnabled(true);}
		else{subscribe.get(i).setText("不可借");	subscribe.get(i).setEnabled(false);}
	}
	BOOKSEARCH.setVisible(false);BOOKSEARCH.setVisible(true);
	currentpage.setText(pagenumber+1+"/"+maxpage+"页");
	

}}
void pageminus(){
	if(pagenumber>0)
	{pagenumber--;
	for(int i=0;i<=29;i++) {
		for(int j=0;j<=7;j++) {searchData[i][j]=ALLData.get(pagenumber)[i][j];}
		int temp=Integer.parseInt(searchData[i][5]);
		if( temp!=0){subscribe.get(i).setText("预约");	subscribe.get(i).setEnabled(true);}
		else{subscribe.get(i).setText("不可借");	subscribe.get(i).setEnabled(false);}
	}
	BOOKSEARCH.setVisible(false);BOOKSEARCH.setVisible(true);
	currentpage.setText(pagenumber+1+"/"+maxpage+"页");
}}
void pageto(){
	pagenumber=Integer.parseInt(pageinput.getText())-1;
	if(pagenumber>=0&&pagenumber<maxpage)
	{for(int i=0;i<=29;i++) {
		for(int j=0;j<=7;j++) {searchData[i][j]=ALLData.get(pagenumber)[i][j];}
		int temp=Integer.parseInt(searchData[i][5]);
		if( temp!=0){subscribe.get(i).setText("预约");	subscribe.get(i).setEnabled(true);}
		else{subscribe.get(i).setText("不可借");	subscribe.get(i).setEnabled(false);}
	}
	BOOKSEARCH.setVisible(false);BOOKSEARCH.setVisible(true);
	currentpage.setText(pagenumber+1+"/"+maxpage+"页");
	}
	
}

}