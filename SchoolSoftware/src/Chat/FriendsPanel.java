package Chat;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.util.ArrayList;

public class FriendsPanel extends JPanel{
	
	ArrayList<JLabel> FriLabelAl = new ArrayList();
	ArrayList<JButton> FriNameAl = new ArrayList();
	
	ImageIcon person1pic = new ImageIcon("images/person1pic.jpg");
	
	public FriendsPanel(int m){
		this.setLayout(null);
		this.setBackground(new Color(0xBBFFFF));
	
		
		for (int i=0; i<=m;i++)
		{
			FriLabelAl.add(new JLabel());
			
		}
	
		for (int i = 0; i <FriLabelAl.size(); i++){
			
			FriLabelAl.get(i).setBounds(6, 20+50*i, 30, 30);
			FriLabelAl.get(i).setOpaque(true);
			FriLabelAl.get(i).setBackground(Color.RED);
			FriLabelAl.get(i).setIcon(person1pic);
			this.add(FriLabelAl.get(i));
		}
		
		
		
        for (int i = 0; i <=m; i++) {
			
        	FriNameAl.add(new JButton("猜猜我是谁"));
		}
		
		for (int i = 0; i <FriNameAl.size(); i++){
			
			FriNameAl.get(i).setBounds(53, 17+50*i, 150, 35);
			FriNameAl.get(i).setBackground(Color.BLUE);
			this.add(FriNameAl.get(i));
			FriNameAl.get(i).setBackground(new Color(0xBBFFFF));
			FriNameAl.get(i).setFont(new Font("微软雅黑",Font.PLAIN,17));
			FriNameAl.get(i).setHorizontalAlignment(JButton.LEFT);
			FriNameAl.get(i).setBorder(new EmptyBorder(0,0,0,0));
			FriNameAl.get(i).setBorderPainted(false);
			FriNameAl.get(i).setFocusPainted(false);
			
			FriNameAl.get(i).addActionListener(new java.awt.event.ActionListener() {

				public void actionPerformed(java.awt.event.ActionEvent e) {
					
				ChatFrame ChatFrame = new ChatFrame();
				ChatFrame.setVisible(true);
				
				}

			});
			
		}

	}	

}


