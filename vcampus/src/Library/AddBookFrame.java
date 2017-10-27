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


public class AddBookFrame extends JFrame{
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
	JButton confirm=new JButton("确认");	
	JButton cancel=new JButton("取消");
	
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

	//HomePanel home_panle=new HomePanel();
	
	
	public AddBookFrame() {		
		this.add(bookname);	this.add(booknumber);this.add(total);this.add(abletoborrow);
		this.add(BOOKNUMBER);add(BOOKNAME);add(ABLETOBORROW);this.add(TOTAL);
		;this.add(confirm);this.add(cancel);
		this.add(author);this.add(author_input);this.add(press);this.add(press_input);
		this.add(location);this.add(classifiction);this.add(class_input);this.add(location_input);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		//for(int i=0;i<=5;i++)for(int j=0;j<=1;j++)borrowData[i][j]=mPanel_searchPanel.ALLData.get(0)[0][0];

		this.setBounds(0, 0, 350, 450);
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
	
	
		confirm.setBounds(60,355, 100, 30);
		cancel.setBounds(190, 355, 100, 30);
		this.setVisible(true);
		cancel.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {

			close();

	
			
	
	
		}

		});
		
		


		//BOOKNUMBER.setText(mPanel_searchPanel.searchData[0][0]);
		//BOOKNAME.setText(mPanel.searchData[tablenumber][1]);
		//TOTAL.setText(mPanel.searchData[tablenumber][4]);
		//ABLETOBORROW.setText(mPanel.searchData[tablenumber][5]);
		
		
		
		
		
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
	

	public void close()
	{
		this.setVisible(false);
	}

}
