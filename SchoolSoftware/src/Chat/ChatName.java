package Chat;

import javax.swing.*;

import java.awt.*;

public class ChatName extends JButton{
	JButton line = new JButton();
	

	

	public ChatName(JLabel name,JLabel pic,ImageIcon image){
		this.setLayout(null);
		this.setSize(199, 50);
		this.setBackground(new Color(0x8EE5EE));
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		line.setBackground(Color.GRAY);
		line.setBounds(0, 49, 199, 1);
		this.add(line);

		this.add(name);
		this.add(pic);

		name.setBounds(55,10,120,30);
		name.setFont(new Font("Dialog",Font.PLAIN,17));
		pic.setBounds(10, 5, 40,40);
		pic.setOpaque(true);
		pic.setBackground(Color.BLACK);
		image.setImage(image.getImage().getScaledInstance(pic.getWidth(),pic.getHeight(),Image.SCALE_DEFAULT));
		pic.setIcon(image);
	}


}
