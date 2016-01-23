package Library;
import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.io.Closeable;
import java.lang.*;
import java.util.*;


public class libraryadmin extends JFrame{
	JFrame yuyue=new JFrame("确认预约");
	JFrame huanshu=new JFrame("还书");
	JLabel booknumber=new JLabel("图书编号:");
	JLabel bookname=new JLabel("书名:");
	JLabel total =new JLabel("总本数:");
	JLabel abletoborrow =new JLabel("可借本数:");
	JLabel message=new JLabel("请输入一卡通号：");
	JButton returnbook =new JButton("还书");
	JButton subscribe =new JButton("预约确认");
	JButton save=new JButton("保存");	
	JButton cancel=new JButton("取消");
	JButton cancelyuyue=new JButton("取消");
	JButton cancelhuanshu=new JButton("取消");
	JButton confirmhuanshu=new JButton("确认");
	JButton confirmyuyue=new JButton("确认");
	JTextField BOOKNUMBER =new JTextField();
	JTextField BOOKNAME =new JTextField();
	JTextField ABLETOBORROW =new JTextField();
	JTextField TOTAL =new JTextField();
	JTextField IDinput= new JTextField();
	//SearchPanel mPanel_searchPanel=new SearchPanel();
	SearchPanel mPanel_searchPanel=new SearchPanel(null);
	int tablenumber;
	String[] colname={"一卡通号","状态"};
	String[][] borrowData=new String[100][2];
	JTable borrow =new JTable(borrowData,colname);
	JScrollPane jsp=new JScrollPane(borrow);
	
	
	public libraryadmin() {		
		this.add(bookname);	this.add(booknumber);this.add(total);this.add(abletoborrow);
		this.add(BOOKNUMBER);add(BOOKNAME);add(ABLETOBORROW);this.add(TOTAL);
		this.add(subscribe);this.add(save);this.add(cancel);this.add(returnbook);
		this.add(jsp);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		for(int i=0;i<=5;i++)for(int j=0;j<=1;j++)borrowData[i][j]=mPanel_searchPanel.ALLData.get(0)[0][0];
		borrow.setEnabled(false);
		this.setBounds(0, 0, 350, 600);
		booknumber.setBounds(60, 50, 100, 30);
		bookname.setBounds(60, 90, 100, 30);
		total.setBounds(60, 130, 100, 30);
		abletoborrow.setBounds(60, 170, 100, 30);
		BOOKNUMBER.setBounds(140, 52, 150, 30);
		BOOKNAME.setBounds(140, 92, 150, 30);
		TOTAL.setBounds(140, 132, 150, 30);
		ABLETOBORROW.setBounds(140, 172, 150, 30);
		jsp.setBounds(60, 210, 230, 200);
		subscribe.setBounds(60, 420, 100, 30);
		returnbook.setBounds(190, 420, 100, 30);
		save.setBounds(60,480, 100, 30);
		cancel.setBounds(190, 480, 100, 30);
		cancel.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {

			close();

	
			
	
	
		}

		});
		
		
		save.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
			
			save();
	
		}

		});
		
		subscribe.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {


				yuyue.setLayout(null);
				yuyue.setVisible(true);
				yuyue.setLocationRelativeTo(null);
				yuyue.setSize(300, 250);
				yuyue.add(message);
				yuyue.add(confirmyuyue);
				yuyue.add(IDinput);
				yuyue.add(cancelyuyue);
				message.setBounds(90, 20, 300, 60);
				IDinput.setBounds(80, 80, 127, 30);
				confirmyuyue.setBounds(30, 140, 100, 40);
				cancelyuyue.setBounds(160, 140, 100, 40);;
				cancelyuyue.addActionListener(new java.awt.event.ActionListener() {

					public void actionPerformed(java.awt.event.ActionEvent e) {

					yuyue.setVisible(false);
			
				}

				});
				
	
		}

		});
		returnbook.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {

	
				huanshu.setLayout(null);
				huanshu.setVisible(true);
				huanshu.setLocationRelativeTo(null);
				huanshu.setSize(300, 250);
				huanshu.add(message);
				huanshu.add(confirmhuanshu);
				huanshu.add(IDinput);
				huanshu.add(cancelhuanshu);
				message.setBounds(90, 20, 300, 60);
				IDinput.setBounds(80, 80, 127, 30);
				confirmhuanshu.setBounds(30, 140, 100, 40);
				cancelhuanshu.setBounds(160, 140, 100, 40);
				confirmhuanshu.addActionListener(new java.awt.event.ActionListener() {

					public void actionPerformed(java.awt.event.ActionEvent e) {
					String temp;
					temp=IDinput.getText();

					for (int i=0;i<=99;i++)if(temp.equals(borrowData[i][0])){
						borrowData[i][0]="";borrowData[i][1]="";
						borrow.setVisible(false);borrow.setVisible(true);
					}
						
					
			
				}

				});
				cancelhuanshu.addActionListener(new java.awt.event.ActionListener() {

					public void actionPerformed(java.awt.event.ActionEvent e) {

					huanshu.setVisible(false);
			
				}

				});
				

				
	
		}

		});
		//BOOKNUMBER.setText(mPanel_searchPanel.searchData[0][0]);
		//BOOKNAME.setText(mPanel.searchData[tablenumber][1]);
		//TOTAL.setText(mPanel.searchData[tablenumber][4]);
		//ABLETOBORROW.setText(mPanel.searchData[tablenumber][5]);
		
		
		
		
		
	}
	
	protected void save(){
			close();
			mPanel_searchPanel.ALLData.get(mPanel_searchPanel.pagenumber)[tablenumber][0]=BOOKNUMBER.getText();
			mPanel_searchPanel.ALLData.get(mPanel_searchPanel.pagenumber)[tablenumber][1]=BOOKNAME.getText();	
			mPanel_searchPanel.ALLData.get(mPanel_searchPanel.pagenumber)[tablenumber][5]=ABLETOBORROW.getText() ;
			mPanel_searchPanel.ALLData.get(mPanel_searchPanel.pagenumber)[tablenumber][4]=TOTAL.getText();
			mPanel_searchPanel.searchData[tablenumber][4]=TOTAL.getText();
			mPanel_searchPanel.searchData[tablenumber][0]=BOOKNUMBER.getText();
			mPanel_searchPanel.searchData[tablenumber][1]=BOOKNAME.getText();	
			mPanel_searchPanel.searchData[tablenumber][5]=ABLETOBORROW.getText() ;
			
			mPanel_searchPanel.SEARCHBOOK.setVisible(false);
			mPanel_searchPanel.SEARCHBOOK.setVisible(true);
		// TODO 自动生成的方法存根
		
	}

	public  void setbooknumber(String Booknumber){
		BOOKNAME.setText(Booknumber);
		
	}
	public void setbookname(String Bookname){
		BOOKNAME.setText(Bookname);
	}
	public void settotal(String Total){
		TOTAL.setText(Total);
	}
	public void setabletoborrow(String Abletoborrow){
		abletoborrow.setText(Abletoborrow);
	}
	
	public void setsearchpanel(SearchPanel m) {
		mPanel_searchPanel = m;
	}
	public void close()
	{
		this.setVisible(false);
	}
	
}
