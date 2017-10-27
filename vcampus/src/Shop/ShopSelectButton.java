package Shop;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ShopSelectButton extends JButton{
	private JLabel content=new JLabel("",JLabel.CENTER);
	private ImageIcon selected_pic=new ImageIcon("images/Pick_o_yes.png");
	private ImageIcon notselected_pic=new ImageIcon("images/Pick_o_no.png");
	private JLabel pic_located=new JLabel();
	private boolean is_selected=false;
	public ShopSelectButton(String contentString) {
		this.setSize(100,30);
		content.setText(contentString);
		this.add(content);
		this.setLayout(null);
		content.setBounds(30,0, 70, 30);
		this.add(pic_located);
		pic_located.setBounds(0, 0, 30, 30);
		pic_located.setIcon(notselected_pic);
		this.setContentAreaFilled(false);
		content.setFont(new Font("ProFont",Font.BOLD,15));
//		this.setOpaque(false);
		this.setBorderPainted(false);
		this.addActionListener(new java.awt.event.ActionListener() {// jb1事件

			public void actionPerformed(java.awt.event.ActionEvent e) {
				is_selected=!is_selected;
				if(is_selected==true){pic_located.setIcon(selected_pic);}
				else{pic_located.setIcon(notselected_pic);}
				
					
				
				
			}
		
		});
		// TODO 自动生成的构造函数存根
	}
	
	public void setContent(String CONTENT) {
		content.setText(CONTENT);
		
	}
//	public static void main(String[] args) 
//	{  JFrame jf=new JFrame();
//	jf.setVisible(true);
//	jf.setSize(600,600);
//	jf.setLayout(null);
//	SelectButton a= new SelectButton("测试五个字");
//	jf.add(a);
//	a.setLocation(0, 0);
//	
//		
//	}
	public boolean getIsSelected() {
		return is_selected;
		
	}
	public void setSelected(boolean true_or_false){
		is_selected=true_or_false;
		if(is_selected==true){pic_located.setIcon(selected_pic);}
		else{pic_located.setIcon(notselected_pic);}
	}
}
