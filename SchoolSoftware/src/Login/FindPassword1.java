package Login;
import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
public class FindPassword1 extends JPanel{
	
	public JButton refer;
	public JTextField studentcardIDinput;
	public JTextField studentIDinput;
	public FindPassword1(){
	this.setLayout(null);
	
//	JButton huakuai = new JButton();
//	huakuai.setBounds(120, 0, 120, 5);
//	huakuai.setBackground(new Color(0xB0E2FF));
//	this.add(huakuai);
//	huakuai.setBorderPainted(false);

	
	studentIDinput=new JTextField("请输入学号");
	this.add(studentIDinput);
	studentIDinput.setBounds(20, 45, 200, 30);
	studentIDinput.addMouseListener(new MouseListener(){

		public void mouseClicked(MouseEvent arg0) {
			studentIDinput.setText("");
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
	
	
	studentcardIDinput=new JTextField("请输入一卡通号");
	this.add(studentcardIDinput);
	studentcardIDinput.setBounds(20, 105, 200, 30);
	studentcardIDinput.addMouseListener(new MouseListener(){

		public void mouseClicked(MouseEvent arg0) {
			studentcardIDinput.setText("");
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
	refer.setBounds(20,180,200,40);
//	 登录按钮的坐标及大小
	refer.setFont(new Font("微软雅黑",Font.PLAIN,20));
	this.add(refer);
	refer.setBackground(new Color(0x5CACEE));
	refer.setBorderPainted(false);
	refer.setFocusPainted(false);
	
	
	this.setBounds(0, 80, 240, 280);
	
	}
	
	

}

