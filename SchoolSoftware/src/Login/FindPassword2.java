package Login;
import javax.swing.*;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

public class FindPassword2 extends JPanel{
	public JButton refer;
	final JTextField passwordinput;
	JTextField confirmpasswordinput;
	
	public FindPassword2(){
	this.setLayout(null);
	this.setBackground(Color.WHITE);
	
	
//	JButton huakuai = new JButton();
//	huakuai.setBounds(120, 0, 120, 5);
//	huakuai.setBackground(new Color(0xB0E2FF));
//	this.add(huakuai);
//	huakuai.setBorderPainted(false);

	passwordinput=new JTextField("请输入密码");
	this.add(passwordinput);
	passwordinput.setBounds(20, 45, 200, 30);
	passwordinput.addMouseListener(new MouseListener(){

		public void mouseClicked(MouseEvent arg0) {
			passwordinput.setText("");
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

	confirmpasswordinput=new JTextField("请确认密码");
	this.add(confirmpasswordinput);
	confirmpasswordinput.setBounds(20, 105, 200, 30);
	confirmpasswordinput.addMouseListener(new MouseListener(){

		public void mouseClicked(MouseEvent arg0) {
			confirmpasswordinput.setText("");
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
	
	
	refer=new JButton("确认");


	refer.setBounds(0,180,240,45);
	refer.setBounds(20,180,200,40);
//	 登录按钮的坐标及大小
	refer.setFont(new Font("微软雅黑",Font.PLAIN,20));
	this.add(refer);
	refer.setBackground(new Color(0x5CACEE));
	refer.setBorderPainted(false);
	refer.setFocusPainted(false);

	this.setBounds(0, 80, 240, 280);

	}
	
	public String getnewPas(){
		String a = passwordinput.getText();
		String b = confirmpasswordinput.getText();
		if(a.equals(b)){
			return passwordinput.getText();
		}
		else{
			return null;
		}
	}

}


