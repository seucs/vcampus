package AdmOffice;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.io.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Person extends JPanel {
  // JFrame frame;
  // JPanel panel;
   JPanel photoPanel;
   JLabel labelphoto;
   ImageIcon photo;
   JLabel lblNewLabel;
   JLabel label;
   JTextField textField;
   JTextField textField_1;
   JLabel label_2;
   JTextField textField_2;
   private JLabel label_3;
   private JTextField textField_3;
   private JLabel label_4;
   private JTextField textField_4;
   private JLabel label_5;
   private JTextField textField_5;
   private JLabel label_6;
   private JTextField textField_6;
   private JLabel label_7;
   private JTextField textField_7;
   private JLabel label_8;
   public Person(){
	  // frame=new JFrame("个人信息门户");
	 //  panel = new JPanel();
	  // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   //frame.setBounds(200, 20, 900, 700);
	  // frame.getContentPane().add(panel);
	 //  frame.setVisible(true);
	  this.setBackground(new Color(250, 250, 250));
	 //  this.setBounds(200, 0, 900, 700);
	   Font font = new Font("微软雅黑",Font.PLAIN,14);
	   this.setLayout(null);
	   //头像
	   photoPanel=new JPanel();
	   Border b1 =BorderFactory.createLineBorder(new Color(217,194,130), 5);
	   Border b2 =BorderFactory.createEtchedBorder();
	   photoPanel.setBorder(BorderFactory.createCompoundBorder(b1, b2));
	   this.add(photoPanel);
	   photoPanel.setBounds(250, 50, 105, 125);
	   photoPanel.setLayout(null);  
	   labelphoto = new JLabel();
	   labelphoto.setBounds(5, 5, 95, 115);
	   photoPanel.add(labelphoto);
	   labelphoto.setIcon(new ImageIcon("images/default_headportrait.png"));
	   //this.validate();
	   //更换头像按钮
	   JButton button = new JButton("更换头像");
	   button.setFont(font);
	   button.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			do_button_actionPerformed(e);
		}
	});
	   this.add(button);
	   button.setBounds(370, 145, 90, 30);
	   
	   label = new JLabel("姓        名 ：");
	   label.setBounds(260, 191, 66, 21);
	   this.add(label);
	   
	   textField = new JTextField();
	   textField.setText("王华威");
	   textField.setBounds(350, 191, 66, 21);
	   this.add(textField);
	   textField.setColumns(10);
	   
	   JLabel label_1 = new JLabel("性        别 ：");
	   label_1.setBounds(260, 222, 66, 18);
	   this.add(label_1);
	   
	   textField_1 = new JTextField();
	   textField_1.setText("男");
	   textField_1.setBounds(350, 219, 61, 21);
	   this.add(textField_1);
	   textField_1.setColumns(10);
	   
	   label_2 = new JLabel("民        族 ：");
	   label_2.setBounds(260, 247, 66, 16);
	   this.add(label_2);
	   
	   textField_2 = new JTextField();
	   textField_2.setText("汉族");
	   textField_2.setBounds(350, 244, 61, 21);
	   this.add(textField_2);
	   textField_2.setColumns(10);
	   
	   label_3 = new JLabel("一卡通号：");
	   label_3.setBounds(260, 272, 66, 16);
	   this.add(label_3);
	   
	   textField_3 = new JTextField();
	   textField_3.setText("213133987");
	   textField_3.setBounds(350, 269, 66, 21);
	   this.add(textField_3);
	   textField_3.setColumns(10);
	   
	   label_4 = new JLabel("学        号 ：");
	   label_4.setBounds(260, 294, 66, 16);
	   this.add(label_4);
	   
	   textField_4 = new JTextField();
	   textField_4.setText("21113101");
	   textField_4.setBounds(350, 294, 66, 21);
	   this.add(textField_4);
	   textField_4.setColumns(10);
	   
	   label_5 = new JLabel("专        业 ：");
	   label_5.setBounds(260, 319, 66, 16);
	   this.add(label_5);
	   
	   textField_5 = new JTextField();
	   textField_5.setText("国际关系研究专业");
	   textField_5.setBounds(350, 319, 110, 21);
	   this.add(textField_5);
	   textField_5.setColumns(10);
	   
	   label_6 = new JLabel("所在院系：");
	   label_6.setBounds(260, 344, 66, 16);
	   this.add(label_6);
	   
	   textField_6 = new JTextField();
	   textField_6.setText("国际贸易学院");
	   textField_6.setBounds(350, 341, 110, 21);
	   this.add(textField_6);
	   textField_6.setColumns(10);
	   
	   label_7 = new JLabel("卡上余额：");
	   label_7.setBounds(260, 369, 66, 16);
	   this.add(label_7);
	   
	   textField_7 = new JTextField();
	   textField_7.setText("100,000.00");
	   textField_7.setBounds(350, 366, 110, 21);
	   this.add(textField_7);
	   textField_7.setColumns(10);
	   
	   label_8 = new JLabel("借阅书籍：");
	   label_8.setBounds(260, 394, 66, 16);
	   this.add(label_8);
	   
	   JLabel label_9 = new JLabel("最近订单：");
	   label_9.setBounds(260, 475, 66, 16);
	   this.add(label_9);
	   
	   JButton button_1 = new JButton("修   改");
	   button_1.setForeground(Color.BLACK);
	   button_1.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent arg0) {
	   	}
	   });
	   button_1.setBounds(236, 588, 75, 30);
	   this.add(button_1);
	   
	   JButton button_2 = new JButton("保  存");
	   button_2.setForeground(Color.BLACK);
	   button_2.setBounds(491, 588, 75, 30);
	   this.add(button_2);
	  // this.repaint();
	   
   }
   
   protected void do_button_actionPerformed(ActionEvent e){
	   JFileChooser chooser = new JFileChooser();
	   FileNameExtensionFilter filter = new FileNameExtensionFilter("图片选择", "jpg","gif","png","jpeg");
	   chooser.setFileFilter(filter);
	   int option = chooser.showOpenDialog(photoPanel);
	   if(option == JFileChooser.APPROVE_OPTION){
		   File file = chooser.getSelectedFile();
		   try{	   
			   ImageIcon image = new ImageIcon(file.toURI().toURL());
			   //photoPanel.setImage(image.getImage());
			   labelphoto.setVisible(false);
			   labelphoto = new JLabel(image); 
			   
			   labelphoto.setBounds(0, 0, 105, 125); 
			   photoPanel.add(labelphoto); 
			   photoPanel.repaint();
		   }catch (MalformedURLException e1){
			   e1.printStackTrace();
		   }
	   }
   }

//   public static void main(String[] args){
//	   new Person();
//   }
}
