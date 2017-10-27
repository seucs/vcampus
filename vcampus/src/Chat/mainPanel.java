package Chat;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class mainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7897159627764422938L;
	public final JButton AddFriend = new JButton();
	public int aminating = 0;
	public int flag = 0;
	public int count1 = 1;
	public int count2 = 1;
	public int count3 = 1;
	public int count4 = 1;
	private JScrollPane jsp1;
	private JScrollPane jsp2;
	private JScrollBar bar1;
	private JScrollBar bar2;
	
	int chattingFriendNumber = 0;
	
	

	public void panel1out() {
		this.add(jsp1);
		jsp1.setVisible(true);
	}

	public void panel1go() {
		jsp1.setVisible(false);
	}

	public void panel2out() {
		this.add(jsp2);
		jsp2.setVisible(true);
	}

	public void panel2go() {
		jsp2.setVisible(false);
	}
	
	
	
	public final FriendsPanel friendsPanel = new FriendsPanel();
	public final FriendsPanel classmatesPanel = new FriendsPanel();

	
	
	public mainPanel() {

		int friendsnumber = friendsPanel.FriLabelAl.size();
		int classmatesnumber = classmatesPanel.ClassLabelAl.size();

		final JLabel GroupHead = new JLabel("群组——————————————");
		final JButton MyClassGroup = new JButton("我的班群");
		final JLabel contactperson = new JLabel("联系人—————————————");
		final JButton MyFriends = new JButton("我的好友");
		final JButton Myclassmates = new JButton("我的同学");
		final JLabel schoolinformation = new JLabel("校园信息————————————");
		final JButton schoolserver = new JButton("校园助手");
		final JButton blackline = new JButton();



		final JLabel classgrouppic = new JLabel("");
		final JLabel rightlabel2 = new JLabel("");
		final JLabel rightlabel3 = new JLabel("");
		final JLabel serverpic = new JLabel("");

		final ImageIcon right11 = new ImageIcon("images/down.jpg");
		final ImageIcon right1 = new ImageIcon("images/right.jpg");
		final ImageIcon serverhead = new ImageIcon("images/Serverhead.jpg");
		final ImageIcon grouphead = new ImageIcon("images/Classgrouphead.jpg");


		
		this.setLayout(null);
		this.setBounds(1100, 0, 250, 700);
		this.setBackground(Color.WHITE);

		friendsPanel.setPreferredSize(new Dimension(210, 50 * friendsnumber + 100));
		classmatesPanel.setPreferredSize(new Dimension(210, 50 * classmatesnumber + 100));

		jsp1 = new JScrollPane(friendsPanel);
		jsp1.setBounds(17, 160, 230, 400);
		jsp1.setBackground(new Color(0xBBFFFF));

		bar1 = jsp1.getVerticalScrollBar();
		bar1.setBackground(Color.white);

		jsp2 = new JScrollPane(classmatesPanel);
		jsp2.setBounds(17, 200, 230, 360);
		jsp2.setBackground(new Color(0xBBFFFF));

		bar2 = jsp2.getVerticalScrollBar();
		bar2.setBackground(Color.white);

		blackline.setBounds(0, 0, 2, 700);
		blackline.setBackground(new Color(0x836FFF));
		this.add(blackline);
		blackline.setBorderPainted(false);
		blackline.setFocusPainted(false);

		GroupHead.setForeground(new Color(0xABABAB));
		GroupHead.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		GroupHead.setBackground(Color.white);
		GroupHead.setBounds(20, 5, 220, 30);
		this.add(GroupHead);

		MyClassGroup.setBounds(70, 40, 180, 35);
		MyClassGroup.setBackground(Color.white);
		MyClassGroup.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		this.add(MyClassGroup);
		MyClassGroup.setHorizontalAlignment(JButton.LEFT);
		MyClassGroup.setBorder(new EmptyBorder(0, 0, 0, 0));
		MyClassGroup.setBorderPainted(false);
		MyClassGroup.setFocusPainted(false);

		MyClassGroup.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {

			}

		});

		classgrouppic.setBounds(23, 43, 30, 30);
		classgrouppic.setBackground(Color.BLACK);
		classgrouppic.setIcon(grouphead);
		this.add(classgrouppic);

		contactperson.setForeground(new Color(0xABABAB));
		contactperson.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		contactperson.setBackground(Color.white);
		contactperson.setBounds(20, 95, 220, 30);
		this.add(contactperson);

		MyFriends.setBounds(45, 120, 180, 35);
		MyFriends.setBackground(Color.white);
		MyFriends.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		this.add(MyFriends);
		MyFriends.setHorizontalAlignment(JButton.LEFT);
		MyFriends.setBorder(new EmptyBorder(0, 0, 0, 0));
		MyFriends.setBorderPainted(false);
		MyFriends.setFocusPainted(false);

		MyFriends.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {

				count2++;

				if (count2 % 2 == 0) {
					rightlabel2.setIcon(right11);
					panel1out();

					Myclassmates.setVisible(false);
					schoolinformation.setVisible(false);
					schoolserver.setVisible(false);
					rightlabel3.setVisible(false);
					serverpic.setVisible(false);
				} else {
					rightlabel2.setIcon(right1);
					panel1go();

					Myclassmates.setVisible(true);
					schoolinformation.setVisible(true);
					schoolserver.setVisible(true);
					rightlabel3.setVisible(true);
					serverpic.setVisible(true);
				}
			}

		});
		
		
//		for (int i=0;i<friendsnumber;i++)
//		{
//			final int temp = i;
//			friendsPanel.friNameButtons.get(i).addActionListener(new java.awt.event.ActionListener() {
//
//				public void actionPerformed(java.awt.event.ActionEvent e) {
//					
//					chattingFriendArray.add(friendsPanel.friNameButtons.get(temp).getText());
//				}
//
//			});
//		}
		
		
		

		rightlabel2.setBounds(20, 130, 15, 15);
		rightlabel2.setBackground(Color.BLACK);
		rightlabel2.setIcon(right1);
		this.add(rightlabel2);

		Myclassmates.setBounds(45, 155, 180, 35);
		Myclassmates.setBackground(Color.white);
		Myclassmates.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		this.add(Myclassmates);
		Myclassmates.setHorizontalAlignment(JButton.LEFT);
		Myclassmates.setBorder(new EmptyBorder(0, 0, 0, 0));
		Myclassmates.setBorderPainted(false);
		Myclassmates.setFocusPainted(false);

		Myclassmates.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {

				count3++;

				if (count3 % 2 == 0) {
					rightlabel3.setIcon(right11);
					panel2out();

					schoolinformation.setVisible(false);
					schoolserver.setVisible(false);
					serverpic.setVisible(false);
				} else {
					rightlabel3.setIcon(right1);
					panel2go();

					schoolinformation.setVisible(true);
					schoolserver.setVisible(true);
					serverpic.setVisible(true);
				}
			}

		});

		rightlabel3.setBounds(20, 165, 15, 15);
		rightlabel3.setBackground(Color.BLACK);
		rightlabel3.setIcon(right1);
		this.add(rightlabel3);

		schoolinformation.setForeground(new Color(0xABABAB));
		schoolinformation.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		schoolinformation.setBackground(Color.white);
		schoolinformation.setBounds(20, 230, 220, 30);
		this.add(schoolinformation);

		schoolserver.setBounds(70, 265, 180, 35);
		schoolserver.setBackground(Color.white);
		schoolserver.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		this.add(schoolserver);
		schoolserver.setHorizontalAlignment(JButton.LEFT);
		schoolserver.setBorder(new EmptyBorder(0, 0, 0, 0));
		schoolserver.setBorderPainted(false);
		schoolserver.setFocusPainted(false);

		serverpic.setBounds(23, 268, 30, 30);
		serverpic.setBackground(Color.BLACK);
		serverpic.setOpaque(true);
		serverpic.setIcon(serverhead);
		this.add(serverpic);

		ImageIcon addfriend = new ImageIcon("images/addfriend.jpg");

		AddFriend.setBounds(50, 620, 150, 40);
		AddFriend.setIcon(addfriend);

		this.add(AddFriend);

	}
}
