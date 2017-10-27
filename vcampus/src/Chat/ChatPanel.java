package Chat;
import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import CallBack.ChatCallBack;
import Home.RunHomepage;
import Message.ChatMessage;
import Message.Message;


public class ChatPanel extends JPanel{
	JTextArea inputArea=new JTextArea("");
	JTextArea messageArea=new JTextArea("");
	JButton sendButton=new JButton("发送");
	JButton faceButton=new  JButton("添加表情");
	JLabel chattingFriendName=new JLabel();
	JButton grayLine1 = new JButton();
	JButton grayLine2 = new JButton();
	JButton grayLine3 = new JButton();
	JLabel backgroundLabel1 = new JLabel();
	JLabel backgroundLabel2 = new JLabel();
	ImageIcon faceButtonPicture = new ImageIcon("images/FaceButton.png");
	

	JScrollPane inputJScrollPane=new JScrollPane(inputArea);
	JScrollPane messageJScrollPane=new JScrollPane(messageArea);


	public ChatPanel(final String myname,final String name) {
		
		chattingFriendName.setText("   "+name);
		this.setBounds(350, 100, 594, 560);
		this.setLayout(null);
		this.setVisible(true);
		this.add(inputJScrollPane);
		this.add(messageJScrollPane);
	    this.add(sendButton);
		this.add(chattingFriendName);
		//this.add(faceButton);
		this.add(grayLine1);
		//this.add(grayLine2);
		this.add(grayLine3);
		this.add(backgroundLabel1);
		this.add(backgroundLabel2);
		
		chattingFriendName.setBounds(0, 0, 460, 49);
		chattingFriendName.setFont(new Font("微软雅黑", Font.ROMAN_BASELINE, 20));
		chattingFriendName.setForeground(new Color(0x6B6B6B));
		chattingFriendName.setOpaque(true);
		chattingFriendName.setBackground(Color.white);
		
		grayLine1.setBounds(0, 49, 500, 1);
		grayLine1.setBackground(new Color(0x6B6B6B));
		
		grayLine2.setBounds(0, 459, 500, 1);
		grayLine2.setBackground(new Color(0x6B6B6B));
		
		grayLine3.setBounds(0, 349, 500, 1);
		grayLine3.setBackground(new Color(0x6B6B6B));
		
	
		messageArea.setEnabled(false);
		messageArea.setFont(new Font("微软雅黑",Font.PLAIN,14));
		//messageArea.set
		messageJScrollPane.setBounds(0,50, 520, 299);
		messageJScrollPane.setHorizontalScrollBarPolicy( 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		messageJScrollPane.setVerticalScrollBarPolicy( 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		messageJScrollPane.setBorder(null);
		
		
		inputJScrollPane.setHorizontalScrollBarPolicy( 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		inputJScrollPane.setVerticalScrollBarPolicy( 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		inputJScrollPane.setBounds(0, 350, 430, 150);
		inputJScrollPane.setBorder(null);
		
		backgroundLabel1.setBounds(430, 350, 70, 110);
		backgroundLabel1.setOpaque(true);
		backgroundLabel1.setBackground(Color.WHITE);
		
		backgroundLabel2.setBounds(460, 40, 40, 10);
		backgroundLabel2.setOpaque(true);
		backgroundLabel2.setBackground(Color.white);

		
		faceButton.setIcon(faceButtonPicture);
		faceButton.setBounds(430,390, 70, 70);
		faceButton.setBorderPainted(false);

		
		sendButton.setBounds(430, 460, 70, 40);
		sendButton.setBackground(new Color(0xD1EEEE));
		sendButton.setFocusPainted(false);
		sendButton.setBorderPainted(false);
		sendButton.setFont(new Font("微软雅黑",Font.PLAIN,18));
		sendButton.setForeground(Color.BLACK);
		
		sendButton.addActionListener(new java.awt.event.ActionListener() {// jb1事件

			public void actionPerformed(java.awt.event.ActionEvent e) {
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time=format.format(date);
				messageArea.append("\n"+myname+"  "+time+"\n"+inputArea.getText());
				
				String a = "";
				if(RunHomepage.getclient().id.equals("09013112"))
				{
					a = "王瑞明";
				}
				
				else{
					a = "朴智新";
				}
				
				RunHomepage.getclient().sendMessage(new Message("Chat", 5, new ChatMessage(time, RunHomepage.getclient().id,a, inputArea.getText())));
				inputArea.setText(null);
			}

		});
		
		
		RunHomepage.getclient().messageThread.setChatCallBack(new ChatCallBack() {
			
			@Override
			public void recived(ChatMessage m) {
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time=format.format(date);
				messageArea.append("\n"+m.getRecipient()+"  "+time+"\n"+m.getContent());
				
			}
		});
		
		

		
		
	
		
		
	}

}
