package Chat;


import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class ChatFrame extends JFrame{
	
	ArrayList<ChatName> friendArray = new ArrayList<ChatName>();
	ArrayList<JLabel> nameArray = new ArrayList<JLabel>();
	ArrayList<JLabel> picArray = new ArrayList<JLabel>();
	ArrayList<ImageIcon> imageArray = new ArrayList<ImageIcon>();
	ArrayList<ChatPanel> chatPanels = new ArrayList<ChatPanel>();
	
	int chatnumber =2;
	


	JButton close=new JButton("关闭");
	//JPanel chatfriends=new JPanel();
	public void addPanel(int m){
		
		this.add(chatPanels.get(m));
		this.setVisible(true);
		
		friendArray.get(m).setBackground(new Color(0xFFD700));
		
		for(int i=0;i<friendArray.size();i++){
			if(m!=i){
				
				chatPanels.get(i).setVisible(false);
				friendArray.get(i).setBackground(new Color(0x8EE5EE));
	
			}
			
		}
		
		
	}
	

	
	
	
//	JPanel Background = new JPanel();
	JLabel bkgd1= new JLabel();
//	ImageIcon BG = new ImageIcon("background.jpg");
	public ChatFrame() {
		this.setLayout(null);
		this.add(close);
		this.setLocation(220,80 );
		this.setBackground(Color.black);
		this.setVisible(true);
		
//		Background.setLayout(null);
//		Background.setBounds(0, 0, 794, 560);
	    
	    bkgd1.setOpaque(true);
	    bkgd1.setBackground(Color.white);
	    bkgd1.setVisible(true);
	    this.add(bkgd1);
	    bkgd1.setBounds(200, 492, 429, 38);
//		bkgd.setIcon(BG);
//		Background.add(bkgd);
//		
//		this.setContentPane(Background);
		
		
		for(int i=0;i<chatnumber;i++){
			
			nameArray.add(new JLabel("王瑞明"));
			picArray.add(new JLabel());
			imageArray.add(new ImageIcon("images/person3pic.jpg"));
			
		}

		
		chatPanels.add(new ChatPanel("邹东棋","江义胜"));
		chatPanels.add(new ChatPanel("王瑞明","邹东棋"));
		chatPanels.add(new ChatPanel("朴智星","王瑞明"));
		chatPanels.add(new ChatPanel("王华威","朴智星"));
		chatPanels.add(new ChatPanel("严晟嘉","王华威"));
		chatPanels.add(new ChatPanel("江义胜","严晟嘉"));
		chatPanels.add(new ChatPanel("hehe","dfhgri"));
		chatPanels.add(new ChatPanel("yooooooooooo","dfoihbg"));
		chatPanels.add(new ChatPanel("bababl","dhfaish"));
		chatPanels.add(new ChatPanel("gun","dhgiug"));
	
		
		
		JPanel chatfriends=new JPanel();
		
		
		
		
		

		this.add(chatfriends);
	    chatfriends.setBackground(new Color(0x8EE5EE));
		chatfriends.setBounds(0, 0, 199, 560);
		chatfriends.setLayout(null);
		
		
		for(int i=0;i<chatnumber;i++)
		{
			friendArray.add(new ChatName(nameArray.get(i), picArray.get(i), imageArray.get(i)));
			
			friendArray.get(i).setBounds(0, i*50, 199, 50);
			chatfriends.add(friendArray.get(i));
			
			final int j=i;
			friendArray.get(i).addActionListener(new java.awt.event.ActionListener() {

				public void actionPerformed(java.awt.event.ActionEvent e) {
					
				addPanel(j);
				//hehe();
				//f(j);
				chatPanels.get(j).setBounds(200, 0, 594, 560);
				//chatPanels.get((j+1)%2).setVisible(false);
				chatPanels.get(j).setVisible(true);
				}

			});
		}
		

		
		this.setSize(785, 560);

		close.setBounds(629, 492, 72, 38);
		close.setBackground(new Color(0xD6D6D6));
		close.setFocusPainted(false);
		close.setBorderPainted(false);
		close.setFont(new Font("微软雅黑",Font.PLAIN,18));
		close.setForeground(new Color(0xEE4000));
		
		close.addActionListener(new java.awt.event.ActionListener() {// jb1事件

			public void actionPerformed(java.awt.event.ActionEvent e) {
				closeframe();
			}

		});
		
		
		// TODO 自动生成的构造函数存根
	}
	protected void closeframe() {
		
		this.setVisible(false);
		// TODO 自动生成的方法存根
		
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new ChatFrame();
		
	}
}
