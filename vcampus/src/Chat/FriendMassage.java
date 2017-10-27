package Chat;
import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class FriendMassage extends JPanel {
	
	public JButton AddFriend = new JButton();
	private JButton blueline = new JButton();
	
	public FriendMassage(){
		
		this.setLayout(null);
		this.setBounds(1100, 0, 250, 700);
		this.setBackground(Color.white);
		this.setVisible(true);
		
		blueline.setBounds(0, 0, 2, 700);
		blueline.setBackground(new Color(0xBBFFFF));
		this.add(blueline);
		blueline.setBorderPainted(false);
		blueline.setFocusPainted(false);
		
		JLabel name = new JLabel("姓名 ：  江义胜");
		name.setFont(new Font("微软雅黑",Font.PLAIN,17));
		name.setOpaque(true);
		name.setBackground(Color.WHITE);
		name.setBounds(20, 270, 200, 30);
		this.add(name);
		
		JLabel number = new JLabel("学号 ： 09013111");
		number.setFont(new Font("微软雅黑",Font.PLAIN,17));
		number.setOpaque(true);
		number.setBackground(Color.WHITE);
		number.setBounds(20, 320, 200, 30);
		this.add(number);
		
		ImageIcon addfriend = new ImageIcon("images/addfriend.jpg");
		AddFriend.setBounds(50, 620, 150, 40);
		AddFriend.setIcon(addfriend);
		this.add(AddFriend);
		

		
		
		
	}

}
