package Chat;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.hxtt.b.n;



public class ChatFrame extends JFrame{
	
	
	int chatnumber =1;
	String id="";

    JPanel chatFriendPanel=new JPanel();
    JLayeredPane backJLayeredPane = new JLayeredPane();
    JLabel shadowLabel =new JLabel();
	ArrayList<ChatName> FriendButtonArray = new ArrayList<ChatName>();
	ArrayList<JLabel> NameArray = new ArrayList<JLabel>();
	ArrayList<JLabel> HeadLabelArray = new ArrayList<JLabel>();
	ArrayList<ImageIcon> HeadImageArray = new ArrayList<ImageIcon>();
	ArrayList<ChatPanel> ChatWindows = new ArrayList<ChatPanel>();
	ArrayList<String> chattingFriendArray = new ArrayList<String>();
	
	
	JScrollPane friendScrollPane;
	JButton closeButton=new JButton("关闭");
	JLabel backgroundLabel2 = new JLabel();
	ImageIcon closeButtonpicture = new ImageIcon("images/CloseButton.png");
	ImageIcon backicon = new ImageIcon("image/deepback.png");
	ImageIcon friendButtonBackground = new ImageIcon("images/buttonbackground.png");
	ImageIcon fakeicon = new ImageIcon("");
	ImageIcon shadowIcon = new ImageIcon("images/shadowLabel.png");
	
	public void addPanel(int m)
	{
		this.setVisible(true);
		FriendButtonArray.get(m).setIcon(friendButtonBackground);
		
		for(int i=0;i<FriendButtonArray.size();i++)
		{
			if(m!=i)
			{
				ChatWindows.get(i).setBounds(1000, 1000, 700, 500);
				FriendButtonArray.get(i).setIcon(fakeicon);
			}
		}
	}
	

	


	public ChatFrame(String id) {
		
		if(id.equals("09013112"))
		{
			this.setLayout(null);
			this.add(closeButton);
			this.setLocation(220,80 );
			this.setBackground(Color.black);
			this.setUndecorated(true);
			this.setVisible(true);
			this.getContentPane().add(backJLayeredPane);
			this.getContentPane().setLayout(null);
				

			backJLayeredPane.setBounds(0, 0, 700, 500);
			backJLayeredPane.add(shadowLabel, new Integer(3));

			
			shadowLabel.setBounds(0, 0, 200, 500);
			shadowLabel.setIcon(shadowIcon);
			
			
			chatFriendPanel.setPreferredSize(new Dimension(200, 50 * chatnumber + 50));
			chatFriendPanel.setLayout(null);
			chatFriendPanel.add(backgroundLabel2);
			chatFriendPanel.setBackground(new Color(0x9AC0CD));
			
			
			backgroundLabel2.setBounds(0, 0, 200, 500+50*chatnumber);
			backgroundLabel2.setVisible(true);
			
			
			friendScrollPane = new JScrollPane(chatFriendPanel);
			this.add(friendScrollPane);
			friendScrollPane.setBounds(0, 0, 230, 500);
			friendScrollPane.setVisible(true);
			friendScrollPane.getVerticalScrollBar().setUnitIncrement(8);

		    
			backJLayeredPane.add(friendScrollPane,new Integer(1));
			
			
			for(int i=0;i<chatnumber;i++)
			{
				NameArray.add(new JLabel());
				HeadLabelArray.add(new JLabel());	
			}
			
			NameArray.get(0).setText("朴智新");
//			NameArray.get(1).setText("王瑞明");
//			NameArray.get(2).setText("朴智新");
//			NameArray.get(3).setText("严晟嘉");
//			NameArray.get(4).setText("王华威");
//			NameArray.get(5).setText("邹东棋");
//			NameArray.get(6).setText("王瑞明");
//			NameArray.get(7).setText("朴智新");
//			NameArray.get(8).setText("严晟嘉");
//			NameArray.get(9).setText("王华威");
//			NameArray.get(10).setText("邹东棋");
//			NameArray.get(11).setText("王瑞明");

			
			HeadImageArray.add(new ImageIcon("images/person1.jpg"));
//			HeadImageArray.add(new ImageIcon("images/person2pic.jpg"));
//			HeadImageArray.add(new ImageIcon("images/person1.jpg"));
//			HeadImageArray.add(new ImageIcon("images/person3.jpg"));
//			HeadImageArray.add(new ImageIcon("images/person2.jpg"));
//			HeadImageArray.add(new ImageIcon("images/person3pic.jpg"));
//			HeadImageArray.add(new ImageIcon("images/person2pic.jpg"));
//			HeadImageArray.add(new ImageIcon("images/person1.jpg"));
//			HeadImageArray.add(new ImageIcon("images/person3.jpg"));
//			HeadImageArray.add(new ImageIcon("images/person2.jpg"));
//			HeadImageArray.add(new ImageIcon("images/person3pic.jpg"));
//			HeadImageArray.add(new ImageIcon("images/person2pic.jpg"));

			

			
			
			
			for(int i=0;i<chatnumber;i++)
			{
				
				ChatWindows.add(new ChatPanel("王瑞明",NameArray.get(i).getText()));
				backJLayeredPane.add(ChatWindows.get(i),new Integer(2));
				
				
				FriendButtonArray.add(new ChatName(NameArray.get(i), HeadLabelArray.get(i), HeadImageArray.get(i)));
				
				FriendButtonArray.get(i).setBounds(0, i*50, 190, 50);
				chatFriendPanel.add(FriendButtonArray.get(i));
				
				final int j=i;
				FriendButtonArray.get(i).addActionListener(new java.awt.event.ActionListener() {

					public void actionPerformed(java.awt.event.ActionEvent e) {
					addPanel(j);
					ChatWindows.get(j).setBounds(200, 0, 500, 500);
					ChatWindows.get(j).setVisible(true);
					}
					

				});
			}
			ChatWindows.get(0).setBounds(200, 0, 500, 500);
			ChatWindows.get(0).setVisible(true);

			
			this.setSize(700, 500);

			closeButton.setBounds(660, 0, 40, 40);
			closeButton.setBackground(new Color(0xD6D6D6));
			closeButton.setBorderPainted(false);
			closeButton.setIcon(closeButtonpicture);
//			closeButton.setFocusPainted(false);	
//			closeButton.setFont(new Font("微软雅黑",Font.PLAIN,18));
//			closeButton.setForeground(new Color(0xEE4000));
			
			closeButton.addActionListener(new java.awt.event.ActionListener() {// jb1事件

				public void actionPerformed(java.awt.event.ActionEvent e) {
					closeframe();
				}

			});
			
			
			// TODO 自动生成的构造函数存根
		}
		else{
			this.setLayout(null);
			this.add(closeButton);
			this.setLocation(220,80 );
			this.setBackground(Color.black);
			this.setUndecorated(true);
			this.setVisible(true);
			this.getContentPane().add(backJLayeredPane);
			this.getContentPane().setLayout(null);
				

			backJLayeredPane.setBounds(0, 0, 700, 500);
			backJLayeredPane.add(shadowLabel, new Integer(3));

			
			shadowLabel.setBounds(0, 0, 200, 500);
			shadowLabel.setIcon(shadowIcon);
			
			
			chatFriendPanel.setPreferredSize(new Dimension(200, 50 * chatnumber + 50));
			chatFriendPanel.setLayout(null);
			chatFriendPanel.add(backgroundLabel2);
			chatFriendPanel.setBackground(new Color(0x9AC0CD));
			
			
			backgroundLabel2.setBounds(0, 0, 200, 500+50*chatnumber);
			backgroundLabel2.setVisible(true);
			
			
			friendScrollPane = new JScrollPane(chatFriendPanel);
			this.add(friendScrollPane);
			friendScrollPane.setBounds(0, 0, 230, 500);
			friendScrollPane.setVisible(true);
			friendScrollPane.getVerticalScrollBar().setUnitIncrement(8);

		    
			backJLayeredPane.add(friendScrollPane,new Integer(1));
			
			
			for(int i=0;i<chatnumber;i++)
			{
				NameArray.add(new JLabel());
				HeadLabelArray.add(new JLabel());	
			}
			
			NameArray.get(0).setText("王瑞明");
//			NameArray.get(1).setText("王瑞明");
//			NameArray.get(2).setText("朴智新");
//			NameArray.get(3).setText("严晟嘉");
//			NameArray.get(4).setText("王华威");
//			NameArray.get(5).setText("邹东棋");
//			NameArray.get(6).setText("王瑞明");
//			NameArray.get(7).setText("朴智新");
//			NameArray.get(8).setText("严晟嘉");
//			NameArray.get(9).setText("王华威");
//			NameArray.get(10).setText("邹东棋");
//			NameArray.get(11).setText("王瑞明");

			
			HeadImageArray.add(new ImageIcon("images/person1.jpg"));
//			HeadImageArray.add(new ImageIcon("images/person2pic.jpg"));
//			HeadImageArray.add(new ImageIcon("images/person1.jpg"));
//			HeadImageArray.add(new ImageIcon("images/person3.jpg"));
//			HeadImageArray.add(new ImageIcon("images/person2.jpg"));
//			HeadImageArray.add(new ImageIcon("images/person3pic.jpg"));
//			HeadImageArray.add(new ImageIcon("images/person2pic.jpg"));
//			HeadImageArray.add(new ImageIcon("images/person1.jpg"));
//			HeadImageArray.add(new ImageIcon("images/person3.jpg"));
//			HeadImageArray.add(new ImageIcon("images/person2.jpg"));
//			HeadImageArray.add(new ImageIcon("images/person3pic.jpg"));
//			HeadImageArray.add(new ImageIcon("images/person2pic.jpg"));

			

			
			
			
			for(int i=0;i<chatnumber;i++)
			{
				
				ChatWindows.add(new ChatPanel("朴智新",NameArray.get(i).getText()));
				backJLayeredPane.add(ChatWindows.get(i),new Integer(2));
				
				
				FriendButtonArray.add(new ChatName(NameArray.get(i), HeadLabelArray.get(i), HeadImageArray.get(i)));
				
				FriendButtonArray.get(i).setBounds(0, i*50, 190, 50);
				chatFriendPanel.add(FriendButtonArray.get(i));
				
				final int j=i;
				FriendButtonArray.get(i).addActionListener(new java.awt.event.ActionListener() {

					public void actionPerformed(java.awt.event.ActionEvent e) {
					addPanel(j);
					ChatWindows.get(j).setBounds(200, 0, 500, 500);
					ChatWindows.get(j).setVisible(true);
					}
					

				});
			}
			ChatWindows.get(0).setBounds(200, 0, 500, 500);
			ChatWindows.get(0).setVisible(true);

			
			this.setSize(700, 500);

			closeButton.setBounds(660, 0, 40, 40);
			closeButton.setBackground(new Color(0xD6D6D6));
			closeButton.setBorderPainted(false);
			closeButton.setIcon(closeButtonpicture);
//			closeButton.setFocusPainted(false);	
//			closeButton.setFont(new Font("微软雅黑",Font.PLAIN,18));
//			closeButton.setForeground(new Color(0xEE4000));
			
			closeButton.addActionListener(new java.awt.event.ActionListener() {// jb1事件

				public void actionPerformed(java.awt.event.ActionEvent e) {
					closeframe();
				}

			});
			
		}
	}
	protected void closeframe() {
		
		this.setVisible(false);
		// TODO 自动生成的方法存根
		
	}
	

}
