package AdmOffice;


import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HandbookPanel extends JPanel{
	public HandbookPanel(){
		Font font=new Font("黑体", Font.BOLD, 20);
		JTextArea textbook=new JTextArea("                                  学生手册",25,78);
   	 textbook.setFont(font);
   	 textbook.setBackground(new Color(211,211,211));
   	 this.add(textbook);
	}

}