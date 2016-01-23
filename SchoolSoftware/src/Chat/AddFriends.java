package Chat;
import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class AddFriends extends JPanel {
	
	public JButton AddFriend = new JButton();
	JButton blueline = new JButton();
	
	public AddFriends(){
		
		this.setLayout(null);
		this.setBounds(1100, 0, 250, 700);
		this.setBackground(Color.white);
		this.setVisible(true);
		
		blueline.setBounds(0, 0, 2, 700);
		blueline.setBackground(new Color(0x87CEFF));
		this.add(blueline);
		blueline.setBorderPainted(false);
		blueline.setFocusPainted(false);
		
		final JTextField Zhanghao = new JTextField();
		this.add(Zhanghao);
		Zhanghao.setBounds(20, 320, 200, 30);
		
		ImageIcon addfriend = new ImageIcon("images/addfriend.jpg");
		AddFriend.setBounds(50, 620, 150, 40);
		AddFriend.setIcon(addfriend);
		this.add(AddFriend);
		
		JLabel text = new JLabel("请输入添加好友的学号：");
		text.setFont(new Font("微软雅黑",Font.PLAIN,17));
		text.setOpaque(true);
		text.setBackground(Color.WHITE);
		text.setBounds(20, 270, 200, 30);
		this.add(text);
		
		
		
		
		
	}

}
