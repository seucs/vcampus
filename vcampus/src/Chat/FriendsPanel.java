package Chat;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Message.FriendData;
import Message.LoginMessage;

import java.awt.*;
import java.util.ArrayList;

public class FriendsPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 773847690324146753L;
	public String uid = "" ;
	
	ArrayList<JLabel> FriLabelAl = new ArrayList<JLabel>();
	ArrayList<JButton> friNameButtons = new ArrayList<JButton>();
	ArrayList<JLabel> ClassLabelAl = new ArrayList<JLabel>();
	ArrayList<JButton> ClassNameButtons = new ArrayList<JButton>();
	
//	//ImageIcon person1pic = new ImageIcon("images/person1pic.jpg");
//	ImageIcon person3pic = new ImageIcon("image/person3pic.jpg");
//	ImageIcon person2pic = new ImageIcon("image/person2pic.jpg");
//	ImageIcon person1 = new ImageIcon("images/person1.jpg");
//	ImageIcon person3 = new ImageIcon("images/person3.jpg");
//	ImageIcon person2 = new ImageIcon("images/person2.jpg");
	
	public FriendsPanel()
	{
		this.setLayout(null);
		this.setBackground(new Color(0xBBFFFF));

//		showfriends(friendarray, classmatearray);

	}	
	


    public void showfriends(ArrayList<FriendData> friendarray,ArrayList<FriendData> classmatearray){
	
	for (int i=0; i<friendarray.size();i++)
	{
		FriLabelAl.add(new JLabel());
		FriLabelAl.get(i).setIcon(friendarray.get(i).img);
		FriLabelAl.get(i).setBounds(6, 20+50*i, 30, 30);
		FriLabelAl.get(i).setOpaque(true);
		this.add(FriLabelAl.get(i));
		
		friNameButtons.add(new JButton());
		friNameButtons.get(i).setText(friendarray.get(i).friendname);
		
		
		friNameButtons.get(i).setBounds(53, 17+50*i, 150, 35);
		this.add(friNameButtons.get(i));
		friNameButtons.get(i).setBackground(new Color(0xBBFFFF));
		friNameButtons.get(i).setFont(new Font("微软雅黑",Font.PLAIN,17));
		friNameButtons.get(i).setHorizontalAlignment(JButton.LEFT);
		friNameButtons.get(i).setBorder(new EmptyBorder(0,0,0,0));
		friNameButtons.get(i).setBorderPainted(false);
		friNameButtons.get(i).setFocusPainted(false);
		
	
		
		final int temp = i;
		
		friNameButtons.get(i).addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				
			
			ChatFrame ChatFrame = new ChatFrame(FriendsPanel.this.uid);
			ChatFrame.setVisible(true);
			//ChatFrame.chattingFriendArray.add(friNameButtons.get(temp).getText());
			
			}

		});
		
		
		
	}
	
	for (int i=0;i<classmatearray.size();i++)
	{
		ClassLabelAl.add(new JLabel());
		ClassLabelAl.get(i).setBounds(6, 20+50*i, 30, 30);
		ClassLabelAl.get(i).setOpaque(true);
		this.add(ClassLabelAl.get(i));
		ClassLabelAl.get(i).setIcon(classmatearray.get(i).img);
		
		ClassNameButtons.add(new JButton());
		ClassNameButtons.get(i).setText(classmatearray.get(i).friendname);
		
		ClassNameButtons.get(i).setBounds(53, 17+50*i, 150, 35);
		this.add(ClassNameButtons.get(i));
		ClassNameButtons.get(i).setBackground(new Color(0xBBFFFF));
		ClassNameButtons.get(i).setFont(new Font("微软雅黑",Font.PLAIN,17));
		ClassNameButtons.get(i).setHorizontalAlignment(JButton.LEFT);
		ClassNameButtons.get(i).setBorder(new EmptyBorder(0,0,0,0));
		ClassNameButtons.get(i).setBorderPainted(false);
		ClassNameButtons.get(i).setFocusPainted(false);
		
		
		
        final int temp = i;
		
		ClassNameButtons.get(i).addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				
			
			ChatFrame ChatFrame = new ChatFrame(FriendsPanel.this.uid);
			ChatFrame.setVisible(true);
			//ChatFrame.chattingFriendArray.add(friNameButtons.get(temp).getText());
			
			}

		});
	}
	
    }
    
    public void refreshPanel()
    {
    	
    	for (int i=0;i<FriLabelAl.size();i++)
    	{
    		FriLabelAl.get(i).setBounds(10000, 10000, 0, 0);
    		
    		friNameButtons.get(i).setBounds(10000, 10000, 0, 0);	
    	}
    	FriLabelAl.clear();
    	friNameButtons.clear();
    	
    	
    	for (int i=0;i<ClassLabelAl.size();i++)
    	{
    		ClassLabelAl.get(i).setBounds(10000, 10000, 0, 0);
    		
    		ClassNameButtons.get(i).setBounds(10000, 10000, 0, 0);
    	}
    	ClassLabelAl.clear();
    	ClassNameButtons.clear();
    	
    }


}



