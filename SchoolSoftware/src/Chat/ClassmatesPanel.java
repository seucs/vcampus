package Chat;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.util.ArrayList;

public class ClassmatesPanel extends JPanel{
	
	ArrayList<JLabel> ClassLabelAl = new ArrayList();
	ArrayList<JButton> ClassNameAl = new ArrayList();
	
	ImageIcon person1 = new ImageIcon("images/person3pic.jpg");
	
	public ClassmatesPanel(int n){
		this.setLayout(null);
		this.setBackground(new Color(0xBBFFFF));
		
		
		for (int i = 0; i <=n; i++) {
		
			ClassLabelAl.add(new JLabel());
		}
	
		for (int i = 0; i <ClassLabelAl.size(); i++){
			
			ClassLabelAl.get(i).setBounds(6, 20+50*i, 30, 30);
			ClassLabelAl.get(i).setOpaque(true);
			ClassLabelAl.get(i).setBackground(Color.RED);
			this.add(ClassLabelAl.get(i));
			ClassLabelAl.get(i).setIcon(person1);
			
		}
		
		
		
		for (int i = 0; i <=n; i++) {
			
			ClassNameAl.add(new JButton("就不告诉你"));
		}
		
		for (int i = 0; i <ClassNameAl.size(); i++){
			
			ClassNameAl.get(i).setBounds(53, 17+50*i, 150, 35);
			ClassNameAl.get(i).setBackground(Color.BLUE);
			this.add(ClassNameAl.get(i));
			ClassNameAl.get(i).setBackground(new Color(0xBBFFFF));
			ClassNameAl.get(i).setFont(new Font("微软雅黑",Font.PLAIN,17));
			ClassNameAl.get(i).setHorizontalAlignment(JButton.LEFT);
			ClassNameAl.get(i).setBorder(new EmptyBorder(0,0,0,0));
			ClassNameAl.get(i).setBorderPainted(false);
			ClassNameAl.get(i).setFocusPainted(false);
			
		}
		
	}

}
