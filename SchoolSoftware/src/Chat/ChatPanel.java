package Chat;
import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class ChatPanel extends JPanel{
	JTextArea inputArea=new JTextArea("");
	JTextArea msgArea=new JTextArea("");
	JButton send=new JButton("发送");
//	JButton close=new JButton("关闭");
	JScrollPane inputjsp=new JScrollPane(inputArea);
	JScrollPane msgjsp=new JScrollPane(msgArea);
	//String myname =new String("父亲");
	JButton face=new  JButton("添加表情");

	
	JLabel objname=new JLabel();
	
	
	public ChatPanel(final String myname,final String name) {
		
		objname.setText(name);
		this.setBounds(350, 100, 594, 560);
		this.setLayout(null);
		this.setVisible(true);
//		this.add(close);
		//this.add(inputArea);
		this.add(inputjsp);
		//this.add(msgArea);
		this.add(msgjsp);
		this.add(send);
		
		this.add(objname);
		this.add(face);
	
		msgjsp.setBounds(0,50, 577, 344);
		msgArea.setEnabled(false);
		objname.setBounds(10, 8, 200, 30);
		objname.setFont(new Font("微软雅黑", Font.ROMAN_BASELINE, 20));
		objname.setForeground(Color.BLUE);
//		msgArea.setText();
		inputjsp.setHorizontalScrollBarPolicy( 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		inputjsp.setVerticalScrollBarPolicy( 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		msgjsp.setHorizontalScrollBarPolicy( 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		msgjsp.setVerticalScrollBarPolicy( 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		inputjsp.setBounds(0, 413, 577, 80);

//		close.setBounds(429, 495, 72, 25);
		send.setBounds(500, 492, 76, 38);
		send.setBackground(new Color(0xD1EEEE));
		send.setFocusPainted(false);
		send.setBorderPainted(false);
		send.setFont(new Font("微软雅黑",Font.PLAIN,18));
		send.setForeground(Color.BLACK);//new Color(0xD1EEEE));
		face.setBounds(0,393, 80, 20);
		face.setFont(new Font("Dialog",Font.PLAIN,10));
//		close.addActionListener(new java.awt.event.ActionListener() {// jb1事件
//
//			public void actionPerformed(java.awt.event.ActionEvent e) {
//				closepanel();
//			}
//
//		});
		send.addActionListener(new java.awt.event.ActionListener() {// jb1事件

			public void actionPerformed(java.awt.event.ActionEvent e) {
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time=format.format(date);
				msgArea.append("\n"+myname+"  "+time+"\n"+inputArea.getText());
				inputArea.setText(null);
			}

		});
	
		
		
	}

}
