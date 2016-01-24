package Login;
/*
 * Created on 2015-8-31
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author C5241
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import javax.swing.*;

//import com.sun.glass.events.KeyEvent;

import java.awt.*;
import java.io.File;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.text.AttributedString;

public class Login extends JPanel{
	public JButton forgetpassword;
	public JButton login = new JButton("登     录");
	private final JTextField Zhanghao;
	private final JPasswordField Password;
	private final JTextField fake;
	
	public void magic(){
		this.remove(fake);
	}
	
	public void magic2(){
		this.add(Password);
	}
	
	public Login(){
	
		//UIManager.put("Button.select","");
		
		this.setLayout(null);
		
	

		
		Zhanghao = new JTextField("请输入账号");
		Zhanghao.addMouseListener(new MouseListener(){

			
			public void mouseClicked(MouseEvent arg0) {
				Zhanghao.setText("");
				// TODO 自动生成的方法存根
				
			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				
				
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO 自动生成的方法存根
			}

			public void mousePressed(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				
			}

			public void mouseReleased(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				
				
			}
			
			
		}
		);

		this.add(Zhanghao);
		Zhanghao.setBounds(20, 30, 200, 30);
//		 账号输入框的坐标及大小
		
		JButton huakuai = new JButton();
		huakuai.setBounds(0, 0, 120, 5);
		huakuai.setBackground(new Color(0xB0E2FF));
		this.add(huakuai);
		huakuai.setBorderPainted(false);
		
		fake = new JTextField("请输入密码");
		fake.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent arg0) {
				magic();
				magic2();
				// TODO 自动生成的方法存根
				
			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				
				
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO 自动生成的方法存根
			}

			public void mousePressed(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				
			}

			public void mouseReleased(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				
				
			}
			
			
		}
		);
		
		this.add(fake);
		fake.setBounds(20, 80, 200, 30);
		
		
		Password = new JPasswordField("");
//		Password.addMouseListener(new MouseListener(){
//
//			public void mouseClicked(MouseEvent arg0) {
//				Password.setText("");
//				// TODO 自动生成的方法存根
//				
//			}
//
//			public void mouseEntered(MouseEvent arg0) {
//				// TODO 自动生成的方法存根
//				
//				
//			}
//
//			public void mouseExited(MouseEvent arg0) {
//				// TODO 自动生成的方法存根
//			}
//
//			public void mousePressed(MouseEvent arg0) {
//				// TODO 自动生成的方法存根
//				
//			}
//
//			public void mouseReleased(MouseEvent arg0) {
//				// TODO 自动生成的方法存根
//				
//				
//			}
//			
//			
//		}
//		);
		
		//this.add(Password);
		Password.setBounds(20, 80, 200, 30);
//		 密码输入框的坐标及大小
		

		forgetpassword = new JButton("忘记密码?");
		forgetpassword.setFont(new Font("微软雅黑",Font.PLAIN,12));
		//forgetpassword.setMnemonic(KeyEvent.VK_S);
		forgetpassword.setBounds(140, 110, 100, 20);
		this.add(forgetpassword);
		forgetpassword.setBackground(Color.white);
		forgetpassword.setBorderPainted(false);
		forgetpassword.setFocusPainted(false);
		
		
		
		
		final JButton student = new JButton("学生");
		student.setFont(new Font("微软雅黑",Font.PLAIN,15));
		this.add(student);
		student.setBounds(0,140,120,40);
//		 学生选择按钮的坐标及大小
		student.setBorderPainted(false);
		student.setFocusPainted(false);
		
		
		final JButton manager = new JButton("管理员");
		manager.setFont(new Font("微软雅黑",Font.PLAIN,15));
		this.add(manager);
		manager.setBounds(120,140,120,40);
//		 管理员选择按钮的坐标及大小
		manager.setBorderPainted(false);
		manager.setFocusPainted(false);
		
		
		
		final ImageIcon studentclick =new ImageIcon("images/student_click.jpg");
		final ImageIcon studentunclick =new ImageIcon("images/student_unclick.jpg");
		
		final ImageIcon managerclick =new ImageIcon("images/manager_click.jpg");
		final ImageIcon managerunclick =new ImageIcon("images/manager_unclick.jpg");
		
		student.setIcon(studentunclick);
		manager.setIcon(managerunclick);
		
		student.addActionListener(new java.awt.event.ActionListener() {// jb1事件
			

			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				student.setIcon(studentclick);
				manager.setIcon(managerunclick);
				

			}

		});



		manager.addActionListener(new java.awt.event.ActionListener() {// jb1事件

			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				manager.setIcon(managerclick);
				student.setIcon(studentunclick);
			}

		});
		

		student.setIcon(studentclick);
		
//		JButton login = new JButton("登     录");
//		login.setFont(new Font("微软雅黑",Font.PLAIN,20));
//		this.add(login);
//		login.setBounds(20,190,200,40);
////		 登录按钮的坐标及大小
//		login.setBackground(new Color(0x5CACEE));
//		login.setBorderPainted(false);
//		login.setFocusPainted(false);
		
		
		
		this.setBounds(0,0,240,285);
	  
	}  
	
	public String getId(){
		return Zhanghao.getText();
	}
	
	public String getPassword(){
		return Password.getText();
	}
}
