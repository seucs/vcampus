package Library;
import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Connect.Server;

import java.io.Closeable;
import java.lang.*;
import java.net.BindException;
import java.util.*;


public class libraryadmin extends JFrame{
	JFrame yuyue=new JFrame("确认预约");
	JFrame huanshu=new JFrame("还书");
	JLabel booknumber=new JLabel("图书编号:");
	JLabel bookname=new JLabel("书名:");
	JLabel total =new JLabel("总本数:");
	JLabel author =new JLabel("作者");
	JLabel press =new JLabel("出版社");
	JLabel  classifiction=new JLabel("分类");
	JLabel  location=new JLabel("存放处");
	JLabel abletoborrow =new JLabel("可借本数:");
	JLabel message=new JLabel("请输入一卡通号：");
	JButton delete_button=new JButton("删除图书");
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
	JTextField author_input= new JTextField();
	JTextField press_input= new JTextField();
	JTextField class_input= new JTextField();
	JTextField location_input= new JTextField();
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
		this.add(author);this.add(author_input);this.add(press);this.add(press_input);
		this.add(location);this.add(classifiction);this.add(class_input);this.add(location_input);
		this.add(jsp);this.add(delete_button);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		//for(int i=0;i<=5;i++)for(int j=0;j<=1;j++)borrowData[i][j]=mPanel_searchPanel.ALLData.get(0)[0][0];
		borrow.setEnabled(false);
		this.setBounds(0, 0, 350, 600);
		booknumber.setBounds(60, 30, 100, 30);
		bookname.setBounds(60, 70, 100, 30);
		author.setBounds(60, 110, 100, 30);
		press.setBounds(60, 150, 100, 30);
		total.setBounds(60, 190, 100, 30);
		abletoborrow.setBounds(60, 230, 100, 30);
		classifiction.setBounds(60, 270, 100, 30);
		location.setBounds(60, 310, 100, 30);
		BOOKNUMBER.setBounds(140, 32, 150, 30);
		BOOKNAME.setBounds(140, 72, 150, 30);
		author_input.setBounds(140, 112, 150, 30);
		press_input.setBounds(140, 152, 150, 30);
		TOTAL.setBounds(140, 192, 150, 30);
		ABLETOBORROW.setBounds(140, 232, 150, 30);
		class_input.setBounds(140, 272, 150, 30);
		location_input.setBounds(140, 312, 150, 30);
		delete_button.setBounds(125, 530, 100, 20);
	
		jsp.setBounds(60, 350, 230, 80);
		subscribe.setBounds(60, 445, 100, 30);
		returnbook.setBounds(190, 445, 100, 30);
		save.setBounds(60,490, 100, 30);
		cancel.setBounds(190, 490, 100, 30);
		this.setVisible(true);
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
		delete_button.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
			
				delete();
	
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
			mPanel_searchPanel.table.setTextTableCell(tablenumber, 5,ABLETOBORROW.getText());
			mPanel_searchPanel.table.setTextTableCell(tablenumber, 1,BOOKNAME.getText());
			mPanel_searchPanel.table.setTextTableCell(tablenumber, 0,BOOKNUMBER.getText());
			mPanel_searchPanel.table.setTextTableCell(tablenumber, 4,TOTAL.getText());
			mPanel_searchPanel.table.setTextTableCell(tablenumber, 2,author_input.getText());
			mPanel_searchPanel.table.setTextTableCell(tablenumber, 3,press_input.getText());
			mPanel_searchPanel.table.setTextTableCell(tablenumber, 6,class_input.getText());
			mPanel_searchPanel.table.setTextTableCell(tablenumber, 7,location_input.getText());
			
			mPanel_searchPanel.jsp.setVisible(false);
			mPanel_searchPanel.jsp.setVisible(true);
		// TODO 自动生成的方法存根
		
	}
	protected void delete(){
		close();
		mPanel_searchPanel.table.setTextTableCell(tablenumber, 5,"");
		mPanel_searchPanel.table.setTextTableCell(tablenumber, 1,"");
		mPanel_searchPanel.table.setTextTableCell(tablenumber, 0,"");
		mPanel_searchPanel.table.setTextTableCell(tablenumber, 4,"");
		mPanel_searchPanel.table.setTextTableCell(tablenumber, 2,"");
		mPanel_searchPanel.table.setTextTableCell(tablenumber, 3,"");
		mPanel_searchPanel.table.setTextTableCell(tablenumber, 6,"");
		mPanel_searchPanel.table.setTextTableCell(tablenumber, 7,"");
		
		mPanel_searchPanel.jsp.setVisible(false);
		mPanel_searchPanel.jsp.setVisible(true);
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
