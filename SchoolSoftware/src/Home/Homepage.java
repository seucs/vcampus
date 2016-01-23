package Home;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.*;

import AdmOffice.Person;
import AdmOffice.admPanel;
import Chat.AddFriends;
import Chat.FriendMassage;
import Chat.mainPanel;
import Connect.Client;
import Library.libraryPanel;
import PowfulPanel.*;
import Shop.Shoppage;

public class Homepage extends JFrame {

	JPanel contentPanel = new JPanel();
	JButton Select_School = new JButton();
	JButton Select_Shop = new JButton();
	JButton Select_Book = new JButton();
	JButton Select_Pre = new JButton();
	PButton goChat = new PButton("新消息!");
	PowerSwitch Pw_S = new PowerSwitch();
	libraryPanel LIB;
	ImageIcon bgicon;
	Shoppage shop = new Shoppage();
	admPanel adm = new admPanel();
	int adminlib = 1;

	Person person = new Person();
	final mainPanel pic1 = new mainPanel();
	final AddFriends addfriends = new AddFriends();
	final FriendMassage friendMassage = new FriendMassage();

	JLabel Myname;
	JLabel Mynumber;
	JLabel Mystatus;

	public void mainPanelgone(final JPanel panel) {

		new Thread() {

			public void run() {
				int y = 700;

				for (int i = 710; i > 0; i -= 10) {
					// 设置面板位置

					panel.setBounds(1100, 0, 250, y);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					y -= 10;
				}
			}
		}.start();
	}

	public void mainPanelback(final JPanel panel) {

		new Thread() {

			public void run() {
				int y = 0;

				for (int i = 710; i > 0; i -= 10) {
					// 设置面板位置

					panel.setBounds(1100, 0, 250, y);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					y += 10;
				}
			}
		}.start();
	}

	Client mClient;

	public Homepage(Client m) {
		super("Homepage");
		mClient = m;
		LIB = new libraryPanel(m);
		this.setBounds(0, 0, 1100, 700);
		this.setLocation(200, 100);
		contentPanel.setLayout(null);
		this.setContentPane(contentPanel);
		this.setUndecorated(true);

		contentPanel.add(pic1);
		contentPanel.add(addfriends);
		contentPanel.add(friendMassage);

		pic1.AddFriend.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				mainPanelgone(pic1);

			}

		});

		addfriends.AddFriend.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {

				friendMassage.setBounds(1100, 0, 250, 700);
				mainPanelgone(addfriends);

			}

		});

		friendMassage.AddFriend.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {

				// mainPanelgone(friendMassage);

				mainPanelback(pic1);
				addfriends.setBounds(1100, 0, 250, 700);
			}

		});

		// 设置背景图片
		ImageIcon bgicon = new ImageIcon("images/HomePage_00.png");
		final JLabel backgroundlabel = new JLabel();
		backgroundlabel.setIcon(bgicon);
		backgroundlabel.setBounds(0, 0, 1100, 700);
		contentPanel.add(backgroundlabel);
		goChat.setBounds(1000, 670, 100, 30);
		backgroundlabel.add(goChat);
		// backgroundlabel.setLayout(null);

		Myname = new JLabel("江义胜");
		Myname.setBounds(105, 18, 80, 30);
		Myname.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		Myname.setForeground(Color.WHITE);
		backgroundlabel.add(Myname);

		Mynumber = new JLabel("09013111");
		Mynumber.setBounds(105, 38, 80, 30);
		Mynumber.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		Mynumber.setForeground(Color.WHITE);
		backgroundlabel.add(Mynumber);

		Mystatus = new JLabel("图书管理员");
		Mystatus.setBounds(105, 60, 80, 30);
		Mystatus.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		Mystatus.setForeground(Color.WHITE);
		backgroundlabel.add(Mystatus);

		goChat.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (pic1.aminating == 0) {
					new Thread() { // 弹出thread
						public void run() {
							pic1.aminating = 1;
							if (pic1.flag == 0) {
								pic1.flag = 1;
								for (int i = 1100; i <= 1350; i += 10) {
									setframe(i);
									try {
										Thread.sleep(5);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								pic1.aminating = 0;
							} else {
								pic1.flag = 0;
								for (int i = 1350; i >= 1100; i -= 10) {
									setframe(i);
									try {
										Thread.sleep(5);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								pic1.aminating = 0;
							}

						}
					}.start();
				}

			}
		});
		// 设置4个功能选择按钮

		Select_School.setBounds(0, 150, 200, 75);
		contentPanel.add(Select_School);
		Select_School.setOpaque(false);
		Select_School.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				ImageIcon bgicon = new ImageIcon("images/HomePage_01.png");
				backgroundlabel.setIcon(bgicon);
				backgroundlabel.remove(LIB);
				backgroundlabel.remove(shop);
				backgroundlabel.remove(person);
				adm.setBounds(200, 0, 900, 700);
				backgroundlabel.add(adm);

			}
		});

		Select_Shop.setBounds(0, 225, 200, 75);
		contentPanel.add(Select_Shop);
		Select_Shop.setOpaque(false);
		Select_Shop.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				ImageIcon bgicon = new ImageIcon("images/HomePage_02.png");
				backgroundlabel.setIcon(bgicon);
				backgroundlabel.remove(LIB);
				backgroundlabel.remove(adm);
				backgroundlabel.remove(person);
				shop.setBounds(200, 0, 900, 700);
				backgroundlabel.add(shop);

			}
		});

		Select_Book.setBounds(0, 300, 200, 75);
		contentPanel.add(Select_Book);
		Select_Book.setOpaque(false);
		LIB.admin = this.adminlib;
		Select_Book.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				ImageIcon bgicon = new ImageIcon("images/HomePage_03.png");
				backgroundlabel.setIcon(bgicon);
				backgroundlabel.remove(shop);
				backgroundlabel.remove(adm);
				backgroundlabel.remove(person);
				LIB.setBounds(200, 0, 900, 700);

				backgroundlabel.add(LIB);

			}
		});

		Select_Pre.setBounds(0, 375, 200, 75);
		contentPanel.add(Select_Pre);
		Select_Pre.setOpaque(false);
		Select_Pre.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				ImageIcon bgicon = new ImageIcon("images/HomePage_04.png");
				backgroundlabel.setIcon(bgicon);

				backgroundlabel.remove(shop);
				backgroundlabel.remove(adm);
				backgroundlabel.remove(LIB);
				person.setBounds(200, 0, 900, 700);

				backgroundlabel.add(person);
				person.setVisible(true);

			}
		});
		// 四个按钮完毕
		// 设置关闭键
		Pw_S.setBounds(-60, 500, 120, 60);
		backgroundlabel.add(Pw_S);
		Pw_S.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (Pw_S.getflag() == false) {
					Pw_S.turnon();
				} else {
					System.exit(0);
				}
			}
		});
		this.setVisible(true);
	}

	void setframe(int i) {
		this.setBounds(200, 100, i, 700);
	}

}
