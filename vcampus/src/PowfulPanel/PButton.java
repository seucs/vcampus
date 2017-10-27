package PowfulPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.rmi.server.SkeletonNotFoundException;

import javax.swing.JButton;
import javax.swing.JLabel;

public class PButton extends JButton{

	
	public PButton(String text) {
		// TODO 自动生成的构造函数存根
		super(text);
		this.setLayout(new FlowLayout());
		this.setFont(new Font ("微软雅黑", Font.BOLD, 20));
		this.setForeground(new Color(254,254,254));
		this.setBackground(new Color(206,206,206));
		this.setFocusable(false);
		this.setBorder(null);
		
	}
	
}
