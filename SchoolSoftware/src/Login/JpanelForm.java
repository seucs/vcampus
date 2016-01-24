package Login;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Connect.Client;
import Login.FindPassword1;
import Login.FindPassword2;
import Login.Login;

public class JpanelForm implements Serializable {

	/**
	 * @param args
	 */

	JFrame frame = new JFrame("虚拟校园");

	public final Login p1 = new Login();
	public final signin p2 = new signin();// 滑动面板2
	public final psw p3 = new psw();// 滑动面板3
	public final FindPassword1 p4 = new FindPassword1();
	public final FindPassword2 p5 = new FindPassword2();

	private JButton login;

	private Client mClient;

	JPanel contentPanel = new JPanel();// 主面板

	JPanel topPanel = new JPanel();// 顶面板

	final JPanel centerPanel = new JPanel();// 中间面板

	public JpanelForm(Client client) {

		mClient = client;
		frame.setBounds(700, 300, 240, 320);
		// contentPanel.setBackground(Color.black);
		frame.setContentPane(contentPanel);
		frame.setUndecorated(true);
		contentPanel.setLayout(new BorderLayout());

		login = new JButton("登     录");
		login.setFont(new Font("微软雅黑", Font.PLAIN, 20));

		login.setBounds(20, 230, 200, 40);
		// 登录按钮的坐标及大小
		login.setBackground(new Color(0x5CACEE));
		login.setBorderPainted(false);
		login.setFocusPainted(false);

		p1.setBackground(Color.white);
		p2.setBackground(Color.white);
		p4.setBackground(Color.WHITE);
		p5.setBackground(Color.WHITE);

		topPanel.setBackground(Color.white);
		topPanel.setPreferredSize(new Dimension(contentPanel.getWidth(), 35));
		topPanel.setLayout(null);

		// PA.setPreferredSize(new Dimension(contentPanel.getWidth(), 50));
		// PA.setLayout(null);

		centerPanel.setBackground(Color.white);
		centerPanel.setLayout(null);
		centerPanel.add(login);
		// final ImageIcon regnormal =new ImageIcon("reg_normal.png");
		// final ImageIcon reghilight =new ImageIcon("reg_hilight.png");

		final JButton jb2 = new JButton("注   册");
		jb2.setBorderPainted(false);
		jb2.setBackground(Color.WHITE);
		jb2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		jb2.setFocusPainted(false);
		// final ImageIcon loginhilight =new ImageIcon("login_hilight.png");
		// final ImageIcon loginnormal =new ImageIcon("login_normal.png");

		final JButton jb1 = new JButton("登   录");
		jb1.setBorderPainted(false);
		jb1.setBackground(Color.WHITE);
		jb1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		jb1.setFocusPainted(false);

		jb1.setBounds(0, 0, 120, 35);
		jb2.setBounds(120, 0, 120, 35);
		jb1.addActionListener(new java.awt.event.ActionListener() {// jb1事件

			public void actionPerformed(java.awt.event.ActionEvent e) {
				xiaoGuo2(p1);

			}

		});

		jb2.addActionListener(new java.awt.event.ActionListener() {// jb1事件

			public void actionPerformed(java.awt.event.ActionEvent e) {
				xiaoGuo(p2);

			}

		});

		// p2.refer.addActionListener(new java.awt.event.ActionListener() {//
		// jb1事件
		//
		// public void actionPerformed(java.awt.event.ActionEvent e) {
		// xiaoGuo(p3);
		// }
		//
		// });

		p1.forgetpassword.addActionListener(new java.awt.event.ActionListener() {// jb1事件

			public void actionPerformed(java.awt.event.ActionEvent e) {
				xiaoGuo(p4);
			}

		});

		// p4.refer.addActionListener(new java.awt.event.ActionListener() {//
		// jb1事件
		//
		// public void actionPerformed(java.awt.event.ActionEvent e) {
		// xiaoGuo(p5);
		// }
		//
		// });

		p3.refer.addActionListener(new java.awt.event.ActionListener() {// jb1事件

			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (p3.getnewPas() != null) {
					mClient.sendNewPass(p3.getnewPas());
					xiaoGuo(p1);
				}
			}

		});

		p5.refer.addActionListener(new java.awt.event.ActionListener() {// jb1事件

			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (p5.getnewPas() != null) {
					mClient.sendNewPass(p5.getnewPas());
					xiaoGuo(p1);
				}
			}

		});
		// login.addActionListener(new java.awt.event.ActionListener() {// jb1事件
		//
		// public void actionPerformed(java.awt.event.ActionEvent e) {
		// hp.setVisible(true);
		// frame.setVisible(false);
		// //System.exit(0);
		// }
		//
		// });

		topPanel.add(jb1);
		topPanel.add(jb2);

		contentPanel.add(topPanel, BorderLayout.NORTH);
		contentPanel.add(centerPanel, BorderLayout.CENTER);
		centerPanel.add(p1);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	// 返回效果
	public void returnPanel(final JPanel panel) {
		panel.setBounds(0, 0, centerPanel.getWidth(), centerPanel.getHeight());// 设置滑动初始位置
		int count = centerPanel.getComponentCount();// 获取centerPanel中控件数
		List list = new ArrayList();//
		for (Component comp : centerPanel.getComponents()) {
			list.add(comp);// 给list赋值
		}
		if (count >= 0) {// 如果centerPanel中控件数大于0就执行效果
			for (int i = 0; i < count; i++) {
				Component comp = centerPanel.getComponent(i);// 获得该位置的控件

				if (comp instanceof JPanel) {// 判断控件类型
					final JPanel currentPanel = (JPanel) comp;// 获得当前panel
					if (currentPanel != panel) {

						new Thread() {

							public void run() {

								Rectangle rec = currentPanel.getBounds();// 获得当前面板的位置信息
								int y = centerPanel.getWidth();

								for (int i = 0; i >= -centerPanel.getWidth(); i -= 10) {
									// 设置面板位置
									currentPanel.setBounds(i, 0, centerPanel.getWidth(), centerPanel.getHeight());
									panel.setBounds(y, 0, centerPanel.getWidth(), centerPanel.getHeight());
									try {
										Thread.sleep(5);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									y -= 10;
								}

								centerPanel.remove(currentPanel);// 移除當前面板

								panel.setBounds(0, 0, centerPanel.getWidth(), centerPanel.getHeight());

							}
						}.start();
						break;
					}
				}
			}
		}

		if (!list.contains(panel)) {
			centerPanel.add(panel);// 添加要切换的面板
		}

		centerPanel.validate();// 重构内容面板
		centerPanel.repaint();// 重绘内容面板
	}

	// 滑动效果方法
	public void xiaoGuo(final JPanel panel) {
		panel.setBounds(0, 0, centerPanel.getWidth(), centerPanel.getHeight());// 设置滑动初始位置
		int count = centerPanel.getComponentCount();// 获取centerPanel中控件数
		List list = new ArrayList();//
		for (Component comp : centerPanel.getComponents()) {
			list.add(comp);// 给list赋值
		}
		if (count >= 0) {// 如果centerPanel中控件数大于0就执行效果
			for (int i = 0; i < count; i++) {
				Component comp = centerPanel.getComponent(i);// 获得该位置的控件

				if (comp instanceof JPanel) {// 判断控件类型
					final JPanel currentPanel = (JPanel) comp;// 获得当前panel
					if (currentPanel != panel) {

						new Thread() {

							public void run() {

								Rectangle rec = currentPanel.getBounds();// 获得当前面板的位置信息
								int y = -centerPanel.getWidth();

								for (int i = 0; i <= centerPanel.getWidth(); i += 10) {
									// 设置面板位置
									currentPanel.setBounds(i, 0, centerPanel.getWidth(), centerPanel.getHeight());
									panel.setBounds(y, 0, centerPanel.getWidth(), centerPanel.getHeight());
									try {
										Thread.sleep(5);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									y += 10;
								}

								centerPanel.remove(currentPanel);// 移除當前面板

								panel.setBounds(0, 0, centerPanel.getWidth(), centerPanel.getHeight());

							}
						}.start();
						break;
					}
				}
			}
		}

		if (!list.contains(panel)) {
			centerPanel.add(panel);// 添加要切换的面板
		}

		centerPanel.validate();// 重构内容面板
		centerPanel.repaint();// 重绘内容面板
	}

	public void xiaoGuo2(final JPanel panel) {
		panel.setBounds(0, 0, centerPanel.getWidth(), centerPanel.getHeight());// 设置滑动初始位置
		final int count = centerPanel.getComponentCount();// 获取centerPanel中控件数
		List list = new ArrayList();//
		for (Component comp : centerPanel.getComponents()) {
			list.add(comp);// 给list赋值
		}
		if (count >= 0) {// 如果centerPanel中控件数大于0就执行效果
			for (int i = 0; i < count; i++) {
				Component comp = centerPanel.getComponent(i);// 获得该位置的控件

				if (comp instanceof JPanel) {// 判断控件类型
					final JPanel currentPanel = (JPanel) comp;// 获得当前panel
					if (currentPanel != panel) {

						new Thread() {

							public void run() {

								Rectangle rec = currentPanel.getBounds();// 获得当前面板的位置信息
								int y = centerPanel.getWidth();

								for (int i = 0; i >= -centerPanel.getWidth(); i -= 10) {
									// 设置面板位置
									currentPanel.setBounds(i, 0, centerPanel.getWidth(), centerPanel.getHeight());
									panel.setBounds(y, 0, centerPanel.getWidth(), centerPanel.getHeight());
									try {
										Thread.sleep(5);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									y -= 10;
								}

								centerPanel.remove(currentPanel);// 移除當前面板

								panel.setBounds(0, 0, centerPanel.getWidth(), centerPanel.getHeight());

							}
						}.start();
						break;
					}
				}
			}
		}

		if (!list.contains(panel)) {
			centerPanel.add(panel);// 添加要切换的面板
		}

		centerPanel.validate();// 重构内容面板
		centerPanel.repaint();// 重绘内容面板

	}

	public String getStuid() {
		return p1.getId();
	}

	public String getPass() {
		return p1.getPassword();
	}

	public JButton getLgBt() {
		return login;
	}
}
