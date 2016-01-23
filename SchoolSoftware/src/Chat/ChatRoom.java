package Chat;
/*
 * Created on 2015-9-6
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author C4231
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import javax.swing.*;

import java.awt.*;
public class ChatRoom {
	JFrame chatframe = new JFrame("站内信");
	JPanel chatroom = new JPanel();
	
	final JPanel centerPanel = new JPanel();//中间面板
	final JPanel contentPanel = new JPanel();// 主面板
	
	final mainPanel pic1 = new mainPanel();
	
	
	public ChatRoom(){
		chatframe.setSize(250, 700);
		chatframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chatframe.setLocationRelativeTo(null);
		chatframe.setVisible(true);
		
		
	
		
		chatframe.setContentPane(contentPanel);
		contentPanel.setLayout(null);
		contentPanel.setBounds(0, 0, 250,700);
		
		contentPanel.add(centerPanel);
		centerPanel.setLayout(null);
		centerPanel.setBounds(0, 0, 250, 700);
		centerPanel.setBackground(Color.RED);
		centerPanel.add(pic1);
		
		
		

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatRoom();
	}

}
