package AdmOffice;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class admHomePanel extends JPanel{
     public admHomePanel(){
    	 JPanel panel=new JPanel();
    	 panel.setLayout(new GridBagLayout());
    	 this.add(panel);
    	 Font font=new Font("楷体", Font.BOLD, 24);
    	 panel.setBackground(Color.white);
    	 //教务信息标签
    	 JLabel label1=new JLabel("教务信息：                                  ",SwingConstants.LEFT);
    	 label1.setFont(font);
    	 
    	 GridBagConstraints conLabelName = new GridBagConstraints();
    	 conLabelName.fill=GridBagConstraints.NONE;
    	 conLabelName.weightx=0.2;
    	 conLabelName.gridx=0;
    	 conLabelName.gridy=0;
    	 conLabelName.anchor=GridBagConstraints.LINE_END;
    	 panel.add(label1, conLabelName);
    	 
    	 //设置背景图片
    	 //BackgroundPanel backgroundPanel =new BackgroundPanel();
    	// backgroundPanel.setImage(getToolkit().getImage(getClass().getResource("background.jpg")));
    	// panel.add(backgroundPanel);
    	 ImageIcon icon = new ImageIcon("images/background.jpg");
    	// backgroundPanel.;
    	 
    	//教务信息文本区
    	 JTextArea textA=new JTextArea("关于2015年国庆节放假的通知"+"         "+" 2015-09-09 ",8,40);
    	 textA.setFont(font);
    	 textA.setBorder(BorderFactory.createLineBorder(Color.black, 2 ));
    	 textA.setBackground(Color.cyan);
    	 GridBagConstraints contextA = new GridBagConstraints();
    	 contextA.fill = GridBagConstraints.HORIZONTAL;
    	 contextA.weightx=0.8;
    	 contextA.weighty=0.5;
    	 contextA.gridx=0;
    	 contextA.gridy=1;
    	 panel.add(textA, contextA);
    	 
    	 //校园活动标签
    	 JLabel label2=new JLabel("校园活动：                                  ",SwingConstants.LEFT);
    	 
    	 label2.setFont(font);
    	 GridBagConstraints conLabelName2 = new GridBagConstraints();
    	 conLabelName2.fill=GridBagConstraints.NONE;
    	 conLabelName2.weightx=0.2;
    	 conLabelName2.gridx=0;
    	 conLabelName2.gridy=2;
    	 conLabelName2.anchor=GridBagConstraints.LINE_END;
    	 panel.add(label2, conLabelName2);
    	 
    	 //校园活动文本区
    	 JTextArea textB=new JTextArea("关于公布各院（系）2016年推荐优秀应届本科毕业..."+"     "+"2015-09-09",8,40);
    	 textB.setFont(font);	
    	 textB.setBorder(BorderFactory.createLineBorder(Color.black, 2 ));
    	 textB.setBackground(Color.cyan);
    	 panel.add(textB); 
    	 GridBagConstraints contextB = new GridBagConstraints();
    	 contextB.fill = GridBagConstraints.HORIZONTAL;
    	 contextB.weightx=0.8;
    	 contextB.weighty=0.5;
    	 contextB.gridx=0;
    	 contextB.gridy=3;
    	 panel.add(textB, contextB);
     }
}
