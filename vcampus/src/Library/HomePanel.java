package Library;


import javax.swing.*;

import Connect.Client;
import Message.BookMessage;
import Message.Message;

import java.awt.*;
import java.util.*;
import java.lang.*;
public class HomePanel extends JPanel{
	

	JLabel welcome=new JLabel("欢迎进入图书馆系统！");
	JLabel select= new JLabel("请选择上方功能。");
	JButton add_Button=new JButton();
	int admin=1;
	ImageIcon img=new ImageIcon("images/add_book_bt.png");
	AddBookFrame add_frame;
	Client mClient;
	
	public HomePanel(Client client){
		mClient = client;
		this.setLayout(null);
		this.setSize(900, 700);
		add_Button.setBounds(283, 425, 300, 50);
		welcome.setBounds(240,60,600,300);
		welcome.setFont(new Font("微软雅黑",Font.ROMAN_BASELINE,40));
		select.setBounds(285,110,750,300);
		select.setFont(new Font("微软雅黑",Font.ROMAN_BASELINE,40));
		add_Button.setFont(new Font("微软雅黑",Font.ROMAN_BASELINE,20));
		add_Button.setBorderPainted(false);
		add_Button.setBackground(Color.white);
		add_Button.setIcon(img);
		welcome.setEnabled(true);

		this.add(welcome);
		this.add(select);
	if(admin==1)	this.add(add_Button);
	add_Button.addActionListener(new java.awt.event.ActionListener() {

		public void actionPerformed(java.awt.event.ActionEvent e) {
			
		add_frame=new AddBookFrame();
		add_frame.confirm.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				mClient.sendBookupdate(new Message("Bookupdate",0,new BookMessage(add_frame.BOOKNUMBER.getText(), "", add_frame.BOOKNAME.getText(), add_frame.location_input.getText(), add_frame.author_input.getText(), add_frame.press_input.getText(), 0, 0, 0, 0, 0, "")));
				
			}
			});
		//add_frame.=HomePanel.this;
		//add_frame.setVisible(true);


		


	}

	});


}

}

